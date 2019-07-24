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
        int numeroPermissoes = 0;
        Semaphore semaforoVermelho, semaforoAmarelo, semaforoVerde;
        semaforoVermelho = new Semaphore(numeroPermissoes);
        semaforoAmarelo = new Semaphore(numeroPermissoes);
        semaforoVerde = new Semaphore(numeroPermissoes);
        System.out.println("Entre com o número de vezes na qual deseja executar o semáforo:");
        int iteracoes = in.nextInt();
        System.out.println("Numero de vezes: "+iteracoes);
        //cria as duas threads e as inicializa
        Cor thread_vermelha = new Cor("Vermelho", iteracoes, semaforoVermelho, semaforoAmarelo);
        Cor thread_amarela = new Cor("Amarelo", iteracoes, semaforoAmarelo, semaforoVerde);
        Cor thread_verde = new Cor("Verde", iteracoes, semaforoVerde, semaforoVermelho);
        thread_vermelha.start();
        thread_amarela.start();
        thread_verde.start();
        semaforoVermelho.release();
    }
    public static class Cor extends Thread 
    {
        private Semaphore  aguarda, libera;
        private String cor;
        private int iteracoes; 
        public Cor(String cor, int iteracoes, Semaphore aguarda, Semaphore libera)
        {
            this.aguarda = aguarda;
            this.libera = libera;
            this.cor = cor;
            this.iteracoes = iteracoes;
            //this.aguarda.release();
        }
        public void run()
        {
            Random random = new Random();
            int t, index;
            for(index = 0;index < this.iteracoes; index++)
            {
                try
                {
                    this.aguarda.acquire();
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
                    this.libera.release();
                }
            }
        }
    };  
}
