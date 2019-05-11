/* 4) Considere o arquivo “Numeros.txt” com 30 números inteiros. Faça um algoritmo para armazenar esses números em um vetor e depois ordenar este mesmo vetor de maneira não-decrescente. Utilize três procedimentos: um para preencher o vetor, outro para ordenar o vetor e um terceiro para imprimir o vetor antes e depois da ordenação.
Obs.: Não é permitido utilizar qualquer outro vetor/matriz para auxiliar a ordenação.*/ 

package exercicio4;

public class Exercicio4{
    static int []V = {13, -11, 4, 0, 3, 1, 0,  10, -11, -2, 8, 90, 11, 2, 15, 11, -2, 18, 0, 131, 9, -32, 4, 21, -9, 9, -4, 28, 7, 30};

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
        System.out.println("V antes da ordenação:");
        mostraVetor(V);
        
        ordenaVetor(V);
        
        System.out.println("V depois da ordenação:");
        mostraVetor(V);
    }
}
