import java.util.Scanner;

public class Matriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int somatoria = 0;
        if (linha == coluna) {
            somatoriaDiagonal = somatoriaDiagonal + matriz[linha][coluna];
        }

        // perguntar o user
        System.out.println("Sua Matriz tem quantas linhas? ");
        int tamanhoLinha = scanner.nextInt();

        System.out.println("Sua Matriz tem quantas colunas? ");
        int tamanhoColuna = scanner.nextInt();
        
        int[][] matriz = new int[tamanhoLinha][tamanhoColuna];


        //Preenchendo a matriz
        System.out.println("Preencha a matriz: ");
        for (int linha = 0; linha < tamanhoLinha; linha++) {
            for (int coluna = 0; coluna < tamanhoColuna; coluna++){
                System.out.print("Digite o valor para posição [" + linha +"][" + coluna +"]: ");
                matriz[linha][coluna] = scanner.nextInt();
            }
        }
        // Exibindo a matrix
        System.out.println("\nMatriz preeenchida:");
        for (int linha = 0; linha < tamanhoLinha; linha++) {
             for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                System.out.print(matriz[linha][coluna] + "  ");
                somatoria = somatoria + matriz[linha][coluna];
                somatoriaDiagonal =somatoriaDiagonal + matriz[i][i];
             }
             System.out.println(); // Nova linha após cada linha matriz
        }
        System.out.print("\n\nSOMATORIA:" + somatoria);
        System.out.print("\nSOMATORIA:" + somatoriaDiagonal);


        scanner.close();

    }
}
