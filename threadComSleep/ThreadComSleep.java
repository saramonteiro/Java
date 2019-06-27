/*Sara e Uanderson
Instruções de compilação Ubuntu 18.04 pelo terminal
compilar:
javac threadComSleep.java
executar:
java threadComSleep
*/

import java.util.Random;

public class ThreadComSleep implements Runnable
{
   
   //Runnable é a interface padrão para Thread
    //Implementamos Runnable sobrescrevendo o método run() que é executado ao inicializar a Thread com o método start()   
        Random random = new Random();
        int t;
        
        public void run()
        {
        	t = random.nextInt(20)+1;
        	System.out.println("Eu sou a Thread " +Thread.currentThread().getName()+ " e vou dormir por "+t+" segundos!");
        	try{
                Thread.sleep(t*1000); //.sleeep(tempo em milissegundos) pode disparar exceção pois uma thread pode interrompida quando outra thread acordar
        	}catch(Exception e){
                System.out.println(e);
        	}
        	System.out.println("Eu sou a Thread "+Thread.currentThread().getName()+". Já se passaram "+t+" segundos e eu serei finalizada!");
        }
    
     public static void main(String[] args) throws Exception //A excução das threads com sleep pode disparar exceção
    {
        System.out.println("4 threads com sleep");
        //cria as quatro threads e as inicializa
        new Thread(new ThreadComSleep(),"0").start();
        new Thread(new ThreadComSleep(),"1").start();
        new Thread(new ThreadComSleep(),"2").start();
        new Thread(new ThreadComSleep(),"3").start();
    }
} 
