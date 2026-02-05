import java.util.Scanner;

public class desafio {
    public static void main(String[] args) {
        Scanner entradaDados = new Scanner(System.in);
        int[][] matriz = new int[4][4];

        // Preencher a matriz
        System.out.println("Digite os 16 valores da matriz:");
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = entradaDados.nextInt();

            }
        }

        // Escolher a linha
        System.out.println("Digite o número da linha (1 a 4)");
        int linhaEscolhida = entradaDados.nextInt();
        linhaEscolhida--; // ajustar o indice para 0

        // Calcular a soma da linha escolhida
        int soma = 0;
        for (int j = 0; j < 4; j++) {
            soma += matriz[linhaEscolhida][j];
        }
        // Exibir o resultado
        System.out.println("A soma dos elementos da linha " + (linhaEscolhida + 1) + " é:" + soma);

    }

}
