import java.util.Scanner;

public class atividade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos alunos tem na sala?");
        int quantidadeAlunos = Integer.parseInt(scanner.nextLine());

        String nomes[] = new String[quantidadeAlunos];
        int idades[] = new int[quantidadeAlunos];

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Nome do Aluno:");
            nomes[i] = scanner.nextLine();

            System.out.println("idade do aluno:");
            idades[i] = scanner.nextInt();
        }

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println(idades[i] + " ANOS - " + nomes[i]);
        }

        scanner.close();
    }
}