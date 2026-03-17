import java.util.Scanner;

public class atividade0202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistema de aprovação de alunos");

        int nota = scanner.nextInt();
        int valor = nota > 7 ? 50 : 100;
        String resultado = valor == 50 ? "Aprovado" : "Reprovado seu burro2";
        System.out.println(resultado);

        


    }
}
