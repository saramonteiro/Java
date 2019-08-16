import java.util.Scanner;
import java.util.concurrent.Semaphore;
public class sistema_linear 
{
	private  volatile float somatorio[];
	private  volatile float solucoes[];
	private boolean parar = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		sistema_linear meu_sistema = new sistema_linear();
		meu_sistema.executar();
	}
	private void executar()
	{
		Scanner in = new Scanner(System.in);
        System.out.println("Entre com o número da ordem da matriz:");
        int ordem = in.nextInt();
        System.out.println("Ordem: "+ordem);
        float matriz[][] = new float[ordem][ordem];
        preencheMatriz(matriz);
        if(verificaValidez(matriz, ordem))
        {
	        System.out.print("*** Matriz ***\n");
	        imprimeMatriz(matriz);
	        float b[] = new float[ordem];
	        preencheVetor(b);
	        System.out.print("\n*** Vetor ***\n");
	        imprimeVetor(b); 
			solucoes = new float[ordem];
	        somatorio = new float[ordem];
			Somador thread_1 = new Somador(matriz, ordem);
			new Thread(thread_1).start();
			Solucionador thread_2 = new Solucionador(matriz, ordem, b);
			new Thread(thread_2).start();
			thread_1.setSemaforoLiberar(thread_2.getSemaforoBloqueante());
			thread_2.setSemaforoLiberar(thread_1.getSemaforoBloqueante());
			thread_1.getSemaforoBloqueante().release();
		}
		else
		{
			System.out.print("*** Insolucionável ***\n");
		}
	}
	class Somador implements Runnable 
	{
		private int ordem, i,j; 
		private float soma = 0;
        private float matriz[][];
        private Semaphore semaforo, semaforodoSolucionador;

		public Somador(float [][]matriz, int ordem)
        {
            this.matriz = matriz;
            this.ordem = ordem;
            this.semaforo = new Semaphore(0);
        }
        public Semaphore getSemaforoBloqueante()
        {
            return this.semaforo;
        }
        public void setSemaforoLiberar(Semaphore semaforodoSolucionador)
        {
            this.semaforodoSolucionador = semaforodoSolucionador;
        }
    	@Override
    	public void run() 
    	{
    		for(i = (ordem-1); i >= 0; i--)
            {
            	try
                {
                    this.semaforo.acquire();
                    for(j = (ordem-1);j > i;j--)
            		{
            			soma+=(matriz[i][j]*solucoes[j]);
            		}
                }
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                finally
                {
                	somatorio[i] = soma;
                	//System.out.println("Soma "+soma);
            		soma = 0;
                    this.semaforodoSolucionador.release();
                }
            }
            // System.out.print("\n*** Somatorio ***\n");
            // imprimeVetor(somatorio);
    	}
  	}
  	class Solucionador implements Runnable 
	{
		private int ordem, i,j; 
		private float solucao = 0;
        private float matriz[][];
        private float b[];
        private Semaphore semaforo, semaforodoSomador;

		public Solucionador(float [][]matriz, int ordem, float []b)
        {
            this.matriz = matriz;
            this.ordem = ordem;
            this.b = b;
            this.semaforo = new Semaphore(0);
        }
        public Semaphore getSemaforoBloqueante()
        {
            return this.semaforo;
        }
        public void setSemaforoLiberar(Semaphore semaforodoSomador)
        {
            this.semaforodoSomador = semaforodoSomador;
        }
    	@Override
    	public void run() 
    	{
    		for(i = (ordem-1); i >= 0; i--)
            {
            	try
                {
                    this.semaforo.acquire();
                    solucao = (b[i]-somatorio[i])/matriz[i][i];
                }
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                finally
                {
                	solucoes[i] = solucao;
                	//System.out.println("Solucao "+solucao);
            		solucao = 0;
                    this.semaforodoSomador.release();
                }
            }
            System.out.print("\n*** Solucoes ***\n");
            imprimeVetor(solucoes);
    	}
  	}
	public static void imprimeMatriz(float [][]matriz)
    {
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j]+"     ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean verificaValidez(float [][]matriz, int ordem)
    {
    	int i;
    	boolean solucionavel = true;
    	for(i = 0;i < ordem;i++)
    	{
    		if(matriz[i][i] == 0.0)
    		{
    			solucionavel = false;
    		}
    	}
    	return solucionavel;
    }
    public static void imprimeVetor(float []vetor)
    {
        for(int i=0; i<vetor.length; i++)
        {
            System.out.print(vetor[i]+"     ");
        }
        System.out.println();
    }
    public static void preencheMatriz(float [][]matriz)
    {
        int linha, coluna; 
        for(linha = 0; linha < matriz.length; linha++)
        {
            for(coluna = linha; coluna < matriz[linha].length; coluna++)
            {
                Scanner in = new Scanner(System.in);
                System.out.println("matriz["+linha+"]["+coluna+"]");
                matriz[linha][coluna] = in.nextInt();
            }
        }
    }
    public static void preencheVetor(float []vetor)
    {
        int linha; 
        for(linha = 0; linha < vetor.length; linha++)
        {
                Scanner in = new Scanner(System.in);
                System.out.println("b["+linha+"]");
                vetor[linha]= in.nextInt();
        }
    }
}