import java.util.Scanner;

public class vetores {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        String[] nomes = new String[5];
        int[] quantidades = new int[5];
        double[] precos = new double[5];

        //vetores
        for (int i = 0; i < 5; i++) {
            System.out.println("Produto " + (i + 1));

            System.out.print("Nome: ");
            nomes[i] = scanner.nextLine();

            System.out.print("Quantidade em estoque: ");
            quantidades[i] = scanner.nextInt();

            System.out.print("Preço unitário: ");
            precos[i] = scanner.nextDouble();
            scanner.nextLine(); // limpa o buffer

            System.out.println();
        }

        double valorTotalEstoque = 0;
        double somaPrecos = 0;

        int indiceMaisCaro = 0;
        int indiceMaisBarato = 0;

        //dados
        for (int i = 0; i < 5; i++) {
            valorTotalEstoque += quantidades[i] * precos[i];
            somaPrecos += precos[i];

            if (precos[i] > precos[indiceMaisCaro]) {
                indiceMaisCaro = i;
            }

            if (precos[i] < precos[indiceMaisBarato]) {
                indiceMaisBarato = i;
            }
        }

        // Exibindo resultados
        System.out.println("Valor total do estoque: R$ " + valorTotalEstoque);

        System.out.println("\nProdutos com estoque baixo:");
        for (int i = 0; i < 5; i++) {
            if (quantidades[i] < 10) {
                System.out.println("- " + nomes[i] + " (Quantidade: " + quantidades[i] + ")");
            }
        }

        System.out.println("\nProduto mais salgado: " + nomes[indiceMaisCaro] +
        " (R$ " + precos[indiceMaisCaro] + ")");

        System.out.println("Produto mais barato: " + nomes[indiceMaisBarato] +
        " (R$ " + precos[indiceMaisBarato] + ")");

        double media = somaPrecos / 5;
        System.out.println("\nValor médio dos produtos: R$ " + media);

        scanner.close();
    }
}
