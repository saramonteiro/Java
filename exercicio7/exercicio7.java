import java.util.Scanner;
/*
7) Considere um vetor com 20 números naturais maiores do que 1 lidos pelo
teclado. Faça um algoritmo recursivo que organize esse vetor de modo que os
números compostos fiquem nas primeiras posições e os números que não são
compostos nas últimas posições. Essa organização deve ser realizada sem utilizar
qualquer estrutura de dados auxiliar.
Crie e utilize dois procedimentos: um para preencher o vetor e outro
recursivo para realizar a organização do vetor. Crie e utilize também uma função
para retornar 1, se um número natural for composto, ou retornar 0, caso contrário.
Obs. 1: Um número natural C é composto se ele tem mais de dois divisores
naturais distintos.
Obs. 2: Não é permitido utilizar qualquer outro vetor/matriz para auxiliar a
ordenação.
*/

public class exercicio7{
    
    public static void organizaVetor(int []vetor, int partida,int fim)
    {
      
        if((partida == vetor.length-1) || (partida==fim)){
            return;
        }
        if(verificaComposto(vetor[partida])==true)
        {
            organizaVetor(vetor,partida+1,fim);
        }else
        {
            int temp = vetor[partida];
            vetor[partida]=vetor[fim];
            vetor[fim]= temp;
            organizaVetor(vetor,partida,fim-1);
        }
       
    }
    public static boolean verificaPrimo(int numero)
    {
        int restoZero = 0, index;
        for(index = 1; index <= numero; index++)
        {
            if((numero%index)==0)
                restoZero++;
        }
        if(restoZero == 2)
            return true;
        else
            return false;
    }
    public static boolean verificaComposto(int numero)
    {
        if(verificaPrimo(numero) == true)
            return false;
        else
            return true;
    }
    public static void imprimeVetor(int []vetor)
    {
        for(int i=0; i<vetor.length; i++)
        {
            System.out.print(vetor[i]+"  ");
        }
        System.out.println();
    }
    public static void preencheVetor(int []vetor)
    {
        int index, valor;
        Scanner in = new Scanner(System.in);
        for(index = 0; index < vetor.length; index++)
        {
            valor = in.nextInt();
            if(valor <= 1)
            {
                System.out.println("Valor não compatível, digite outro. (Natural)");
                index--;
            }
            else
                vetor[index] = valor;
        }
    }
    public static void teste(int numero)
    {
        int i;
        for(i = 2;i <= numero;i++)
        {
            if(verificaComposto(i) == true)
                System.out.print(i+ "   ");
        }
        System.out.println();
    }
    public static void main(String []args){
        System.out.println("********************************EXERCÍCIO 7********************************");
        //int[] vetor= new int[20];
        //preencheVetor(vetor);
        int []vetor  = {2,  3,  4,  5,  6,  7,  8,  9,  10,  11,  12,  13,  14,  15,  16,  17,  18,  19,  20,  21};
        //resultado esperado: 21  20  4  18  6  16  8  9  10  15  12  14  13  11  17  7  19  5  3  2 
        imprimeVetor(vetor);
        organizaVetor(vetor,0,vetor.length-1);
        imprimeVetor(vetor);      
    }
}