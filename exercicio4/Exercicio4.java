/* 4) Considere o arquivo “Numeros.txt” com 30 números inteiros. Faça um algoritmo para armazenar esses números em um vetor e depois ordenar este mesmo vetor de maneira não-decrescente. Utilize três procedimentos: um para preencher o vetor, outro para ordenar o vetor e um terceiro para imprimir o vetor antes e depois da ordenação.
Obs.: Não é permitido utilizar qualquer outro vetor/matriz para auxiliar a ordenação.*/ 

package exercicio4;

import java.util.Random;

public class Exercicio4{

    public static void preencheVetorAleatorio(int []v){
    
        Random random = new Random();
        
        for(int i = 0; i < v.length; i++)
			{
				v[i] = random.nextInt(100);
			}
    }

    public static void ordenaVetor(int []v){
        int aux;
        
        for(int i=0; i<v.length; i++){
            for(int j=i; j<v.length; j++){
                if(v[i]>v[j]){
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
    }
    
    public static void mostraVetor(int []v){
        for(int i=0; i<v.length; i++)
            System.out.print(v[i]+" ");
        System.out.println();
    }
    
    public static void main(String []args){
        int []V = new int[30];
        
        preencheVetorAleatorio(V);
    
        System.out.println("V antes da ordenação:");
        mostraVetor(V);
        
        ordenaVetor(V);
        
        System.out.println("V depois da ordenação:");
        mostraVetor(V);
    }
}
