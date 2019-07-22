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
        int numeroPermissoes = 1;
        Semaphore semaforoCores = new Semaphore(numeroPermissoes);
        System.out.println("Entre com o número de vezes na qual deseja executar o semáforo:");
        int i = in.nextInt();
        System.out.println("Numero de vezes: "+i);
        //cria as duas threads e as inicializa
        Cor thread_vermelha = new Cor(semaforoCores, "Vermelho");
        Cor thread_amarela = new Cor(semaforoCores, "Amarelo");
        Cor thread_verde = new Cor(semaforoCores, "Verde");
        thread_vermelha.start();
        thread_amarela.start();
        thread_verde.start();
    }
    //Runnable é a interface padrão para Thread
    //Implementamos Runnable sobrescrevendo o método run() que é executado ao inicializar a Thread com o método start()
    public static class Cor extends Thread 
    {
        private Semaphore semaforo;
        private String cor;
        public Cor(Semaphore semaforo, String cor)
        {
            this.semaforo = semaforo;
            this.cor = cor;
        }
        public void run()
        {
            Random random = new Random();
            int t;
            t = random.nextInt(10)+1;
            //semaforo
            try 
            {

                this.semaforo.acquire();
                //delay
                System.out.println("A Thread " + this.cor+" vai dormir por "+t+" segundos!");
                try
                {
                    Thread.sleep(t*1000); //.sleep(tempo em milissegundos) dispara exceção (InterruptedException) se a thread atual for interrompida ou se o valor do tempo nao estiver entre 0 e 999999 (IllegalArgumentException) 
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }catch (InterruptedException e) 
            {
                e.printStackTrace();
            }finally 
            {
                System.out.println(this.cor);
                this.semaforo.release();
            }
        }
    };  
}
