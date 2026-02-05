import java.util.Scanner;

public class Execução_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int somatoria = 0;
        int somatoriaDiagonal = 0;

        System.out.println("Preencha a matriz 3x3: ");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Digite o valor para a posição [" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = scanner.nextInt();
                somatoria = somatoria + matriz[linha][coluna];

                if (linha == coluna) {
                    somatoriaDiagonal = somatoriaDiagonal + matriz[linha][coluna];
                }
            }
        }
        System.out.println("\n Matriz preenchida:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(matriz[linha][coluna] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n\nA somatória da matriz é: " + somatoria);
        System.out.print("\nSOMATORIA DIAGONAL: " + somatoriaDiagonal);
        scanner.close();
    }
}