/* 8) Considere o arquivo “Numeros.txt” com 20 números inteiros que devem ser armazenados em um vetor. Faça um algoritmo recursivo para imprimir o maior valor deste vetor.
Obs.: Não é permitido utilizar qualquer outro vetor/matriz para auxiliar.*/ 
package exercicio8;

import java.lang.Math;

public class Exercicio8{
    
    public static int encontraMaior(int []v, int i, int posicao){
    
        if(i==1)
        //Retorna o valor que ficou sem par ao final da divisão do vetor
            return v[posicao];
        else if(i==2){
        //Compara os valores nos pares ao final da divisão do vetor
            if(v[posicao]>v[posicao+1])
                return v[posicao];
            else
                return v[posicao+1];
        }
        else{
        //Vai dividindo o vetor ao meio até que sobrem pares
            int a, b;

            a = encontraMaior(v, (int)Math.floor((float)i/2), posicao);
            b = encontraMaior(v, (int)(Math.ceil((float)i/2)), posicao+(int)Math.floor((float)i/2));
            
            if(a>b)//Compara o retorno das funções empilhadas par a par. O maior valor prevalecerá
                return a;
            else
                return b;
        }
    }
    
    public static void main(String []args){
        int []V = {13, 14, 7, 3, 1, 9, 110, 0, 12, -11, 88, 0, 7, -1, 167, 2, 31, 2, 6, 20};
        int []W = {-13, -14, -7, 3, 1, 9, 110, 0, 12, -11, 88, 0, 7, -1, -167, 2, 31, 2, 6, -20, 200};
        
        System.out.print("Vetor: ");
        for(int j=0;j<V.length;j++)
           System.out.print(V[j]+" ");
        System.out.println();
        
        System.out.println("Maior valor: "+encontraMaior(V, V.length, 0));
    }
}
