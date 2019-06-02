/*5) Considere um número inteiro n (n ≥ 0) lido pelo teclado. Faça um algoritmo
recursivo para calcular o fatorial de n.*/
import java.util.Scanner;
public class exercicio5
{
	public static int fatorial(int numero)
	{
		int anterior, fatorial;
		if(numero == 1 || numero == 0)
			return 1;
		else
		{
			anterior = numero - 1;
			fatorial = numero*fatorial(anterior);
			return fatorial;
		}

	}
	public static void main(String[] args)
	{
		System.out.println("********************************EXERCÍCIO 5********************************");
		Scanner in = new Scanner(System.in);
		System.out.println("Entre com um numero para ser calculado o fatorial:");
		int i = in.nextInt();
		System.out.println("Numero: "+i);
		System.out.println("Fatorial: "+fatorial(i));
	}
}