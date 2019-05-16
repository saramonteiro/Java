import java.util.Scanner;

public class exercicio7{
    
    public static void organizaVetor(int []vetor, int partida,int fim)
    {
      
        if((partida == vetor.length-1) || (partida==fim)){
            return;
        }
        if(verificaComposto(vetor[partida])==false){
            int temp = vetor[partida];
            vetor[partida]=vetor[fim];
            vetor[fim]= temp;
            organizaVetor(vetor,partida,fim-1);
        }else{
            organizaVetor(vetor,partida+1,fim);
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
    public static void printaVetor(int[] v){
        for (int i = 0; i < v.length; i++) {
        System.out.print(v[i]);

    }
    System.out.println("");
    }
    public static void main(String []args){
        int[] vetor= new int[5];
        vetor[0]=2;
        vetor[1]=3;
        vetor[2]=4;
        vetor[3]=8;
        vetor[4]=7;
        organizaVetor(vetor,0,vetor.length-1);
        printaVetor(vetor);
    //     B = entrada.nextInt();
        
    }
}