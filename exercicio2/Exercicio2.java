/* 2) Considere uma matriz M de ordem 3 de números inteiros armazenada no arquivo
“MatrizM.txt”. Faça um algoritmo para ler esta matriz do arquivo e imprimir na tela se ela é ou não uma Matriz Ortogonal.
    Utilize três procedimentos: um para gerar a matriz M, outro para calcular a sua matriz Transposta (MT) e o terceiro para calcular a multiplicação M.MT.
    Utilize também uma função para retornar se a matriz M é Ortogonal ou não.
    A impressão dessa informação tem que ser na função main.
Obs.: Se uma matriz quadrada M é uma matriz ortogonal, então M.MT = I, onde MT é a matriz transposta de M e I a matriz identidade.*/

package exercicio2;

public class Exercicio2{

    public static void calculaTransposta(int [][]m, int [][]mt){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                mt[j][i] = m[i][j];
            }
        }        
    }
    
    public static void multiplicaMatriz(int [][]m, int [][]mt, int [][]r){        
        
        for(int i=0; i<r.length; i++){
            for(int j=0; j<r[i].length; j++){
                r[i][j] = 0;
                for(int k=0; k<mt.length; k++){
                    r[i][j] += m[i][k]*mt[k][j];
                }
            }
        }
    }
    
    public static int verificaOrtogonal(int [][]r){
        int [][]I = {{1,0,0}, {0,1,0}, {0,0,1}};
        int v = 0;
        
        for(int i=0; i<r.length; i++){
            for(int j=0; j<r[i].length; j++){
                if(r[i][j]!=I[i][j])
                    v = 1;
            }
        }
        return v;
    }
    
    public static void mostraMatriz(int [][]matriz){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        int [][]M = {{1,2,3}, {4,5,6}, {7,8,9}};
        int [][]Mt = new int[3][3];
        int [][]R = new int[3][3];
        int [][]Id = {{1,0,0}, {0,1,0}, {0,0,1}};
        
        calculaTransposta(M, Mt);
        
        System.out.println("Matriz M");
        mostraMatriz(M);
        
        System.out.println("Matriz Mt");
        mostraMatriz(Mt);
        
        multiplicaMatriz(M, Mt, R);
        
        System.out.println("M*Mt");
        mostraMatriz(R);
        
        if(verificaOrtogonal(R)==0)
            System.out.println("A matriz M é ortogonal.");
        else
            System.out.println("A matriz M não é ortogonal.");
    }
}
