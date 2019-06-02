/* 6) Considere dois números inteiros a e b (b ≥ 0) lidos pelo teclado. Faça um algoritmo recursivo para calcular o valor de a^b. */ 
package exercicio6;

import java.util.Scanner;

public class Exercicio6{
    
    public static int potencia(int a, int b){
        if(b==0)
            return 1;
        else if(b==1)
            return a;
        else
            return a*potencia(a, b-1);
    }
    
    public static void main(String []args){
        int A, B, X;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o valor de a");
        A = entrada.nextInt();
        
        System.out.println("Digite o valor de b (b>=0)");
        B = entrada.nextInt();
        
        if(B<0)
            System.out.println("Valor de b inválido");
        else
            System.out.println(A+"^"+B+" = "+potencia(A,B));
    }
}
