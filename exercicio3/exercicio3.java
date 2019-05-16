/*3) Considere um vetor que armazena 10 números inteiros pares e 10 números
inteiros ímpares todos embaralhados, ou seja, sem qualquer ordem preestabelecida.
Faça um algoritmo para ler esse vetor do arquivo “Vetor.txt” e depois organizá-lo
de modo que os números pares fiquem nas posições ímpares do vetor e os
números ímpares fiquem nas posições pares do vetor. Crie dois procedimentos:
um para preencher o vetor com os números do arquivo e o outro para organizá-lo.
Obs.: Não é permitido utilizar qualquer outro vetor/matriz para auxiliar a
organização.*/
import java.util.Random;
public class exercicio3
{
	public static void preencheVetor(int []vetor)
	{
		Random random = new Random();
		int index, max = 10, impares = 0, pares = 0, numero = 0;
		for(index = 0; index < vetor.length; index++)
		{
			numero =random.nextInt(20); 
			if(((numero%2) == 0) && (pares < max))
			{
				pares++;
				vetor[index] = numero;
			}
			else 
			{
				impares++;
				vetor[index] = numero;
			}
		}
	}
	public static void organizaVetor(int []vetor)
	{
		int indiceFora, indiceInterno, auxiliar = 0;
		for(indiceFora = 0; indiceFora < vetor.length; indiceFora++)
		{
			indiceInterno = indiceFora;
			//se o indice do vetor for par
			if((indiceFora % 2) == 0)
			{
				//percorrer o vetor a partir da atual posição até encontrar um impar
				while((vetor[indiceInterno] % 2) == 0)
				{
					indiceInterno++;
				}
			}
			else
			{
				//percorrer o vetor a partir da atual posição até encontrar um par
				while((vetor[indiceInterno] % 2) != 0)
				{
					indiceInterno++;
				}
			}
			//trocar
			auxiliar = vetor[indiceFora];
			vetor[indiceFora] = vetor[indiceInterno];
			vetor[indiceInterno] = auxiliar;
		}	
	}
	public static void imprimeVetor(int []vetor)
	{
		for(int i=0; i<vetor.length; i++)
        {
            System.out.print(i+ "  ");
        }
        System.out.println();
        for(int i=0; i<vetor.length; i++)
        {
            System.out.print(vetor[i]+"  ");
        }
        System.out.println();
    }
	public static void main(String[] args)
	{
		System.out.println("********************************EXERCÍCIO 3********************************");
		int []vetor = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};//= new int[20];
		//preencheVetor(vetor);
		imprimeVetor(vetor);
		organizaVetor(vetor);
		imprimeVetor(vetor);
	}
}