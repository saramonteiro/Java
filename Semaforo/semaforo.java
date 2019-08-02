/*Sara e Uanderson
Instruções de compilação Ubuntu 18.04 pelo terminal
compilar:
javac semaforo.java
executar:
java semaforo
*/
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.Semaphore;
public class semaforo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Entre com o número de vezes na qual deseja executar o semáforo:");
        int iteracoes = in.nextInt();
        System.out.println("Numero de vezes: "+iteracoes);

        //Criação das threads
        Cor thread_vermelha = new Cor("Vermelho", iteracoes);
        Cor thread_amarela = new Cor("Amarelo", iteracoes);
        Cor thread_verde = new Cor("Verde", iteracoes);
        //Inicialização das threads
        thread_vermelha.start();
        thread_amarela.start();
        thread_verde.start();
        //Link de semaforos para a sequencia (passando os ponteiros de semaforos)
        thread_vermelha.setSemaforoLiberar(thread_amarela.getSemaforoCor());
        thread_amarela.setSemaforoLiberar(thread_verde.getSemaforoCor());
        thread_verde.setSemaforoLiberar(thread_vermelha.getSemaforoCor());
        //Iniciar pela vermelha
        thread_vermelha.getSemaforoCor().release();
    }
    public static class Cor extends Thread 
    {
        private Semaphore semaforoDaCor,semaforoDaProximaCor;
        private String cor;
        private int iteracoes; 
        public Cor(String cor, int iteracoes)
        {
            this.cor = cor;
            this.iteracoes = iteracoes;
            this.semaforoDaCor = new Semaphore(0);//inicia bloqueado
        }
        public Semaphore getSemaforoCor()
        {
            return this.semaforoDaCor;
        }
        public void setSemaforoLiberar(Semaphore proximaCor)
        {
            this.semaforoDaProximaCor = proximaCor;
        }
        public void run()
        {
            Random random = new Random();
            int t, index;
            for(index = 0;index < this.iteracoes; index++)
            {
                try
                {
                    this.semaforoDaCor.acquire();
                    t = random.nextInt(10)+1;
                    System.out.println("A Thread " + this.cor+" vai dormir por "+t+" segundos!");
                    try
                    {
                        Thread.sleep(t*1000); //.sleep(tempo em milissegundos) dispara exceção (InterruptedException) se a thread atual for interrompida ou se o valor do tempo nao estiver entre 0 e 999999 (IllegalArgumentException) 
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    System.out.println(this.cor);
                }
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                finally
                {
                    this.semaforoDaProximaCor.release();
                }
            }
        }
    };  
}
