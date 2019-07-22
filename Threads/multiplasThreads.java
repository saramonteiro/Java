/*Sara e Uanderson
Instruções de compilação Ubuntu 18.04 pelo terminal
compilar:
javac multiplasThreads.java
executar:
java multiplasThreads
*/
public class multiplasThreads
{
    public static void main(String[] args)
    {
        System.out.println("Duas Threads em paralelo!");
        //cria as duas threads e as inicializa
        new Thread(thread2).start();
        new Thread(thread1).start();
    }
    //Runnable é a interface padrão para Thread
    //Implementamos Runnable sobrescrevendo o método run() que é executado ao inicializar a Thread com o método start()
    private static Runnable thread1 = new Runnable() 
    {
        public void run()
        {
        	System.out.println("Programação Paralela!");
        }
    };
    private static Runnable thread2 = new Runnable() 
    {
        public void run()
        {
        	System.out.println("Instituto Federal Fluminense.");
        }
    };
}
