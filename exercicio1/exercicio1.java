/*1) Considere a matriz A=[ a ij ] n×m , onde n = 4 e m = 5, com números inteiros
positivos gerados aleatoriamente de 1 até 20. Faça um algoritmo para gerar a matriz
A e verificar se ela satisfaz a seguinte condição:
n−1
Min
∑ a ij
0≤ j≤m−1 i=0
m−1
≤
Max ∏ a ij
0≤i≤n−1 j= 0
Crie um procedimento para gerar a matriz e uma função para realizar a
verificação. De acordo com o retorno da função de verificação, deve-se imprimir na
função main: “Condicao Satisfeita” ou “Condicao Nao Satisfeita”.*/
import java.util.Random;
public class exercicio1
{
	public static void preencheMatrizAleatoria(int [][]matriz)
	{
		Random random = new Random();
		int linha, coluna; 
		for(linha = 0; linha < matriz.length; linha++)
		{
			for(coluna = 0; coluna < matriz[linha].length; coluna++)
			{
				matriz[linha][coluna] = random.nextInt(1,20);
			}
		}
	}
	public static int minSomaColuna(int [][]matriz)
	{
		int minimo = 20*matriz.length, soma = 0, linha, coluna, colunas = matriz[0].length;
		for(coluna = 0; coluna < colunas; coluna++)
		{
			for(linha = 0; linha < matriz.length; linha++)
			{
				soma += matriz[linha][coluna];
			}
			if(soma < minimo)
			{
				minimo = soma;
			}
			soma = 0;
		}
		return minimo;
	}
	public static int maxProdutoLinha(int [][]matriz)
	{
		int linha, coluna, maximo = 1, temporario = 1;; 
		for(linha = 0; linha < matriz.length; linha++)
		{
			for(coluna = 0; coluna < matriz[linha].length; coluna++)
			{
				temporario*=matriz[linha][coluna];
			}
			if(temporario > maximo)
			{
				maximo = temporario;
			}
			temporario = 1;
		}
		return maximo;
	}
	public static void verifica(int somaMinima, int produtoMaximo)
	{
		if(somaMinima <= produtoMaximo)
			System.out.println("Condição Satisfeita");
		else	
			System.out.println("Condição não Satisfeita");
	}
	public static void imprimeMatriz(int [][]matriz)
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
    public static void main(String[] args)
    {
        System.out.println("********************************EXERCÍCIO 1********************************");
        int [][]matriz = new int[4][5];
        int minsoma, maxproduto;
        preencheMatrizAleatoria(matriz);
        System.out.print("Matriz "+matriz.length+"x"+matriz[0].length+".\n");
        imprimeMatriz(matriz);
        minsoma = minSomaColuna(matriz);
        maxproduto = maxProdutoLinha(matriz);
        System.out.println("minSomaColuna  "+minsoma);
        System.out.println("maxProdutoLinha  "+maxproduto);
        verifica(minsoma, maxproduto);
    }
}
