import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class NotasAlunos {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 Map<String, Double> valor = new HashMap<>();

 // Cadastrar notas
 valor.put("Banana", 8.5);
 valor.put("Ferro", 7.0);
 valor.put("Carro", 9.2);
 valor.put("Diamante", 6.5);

 // Exibir todas as notas
 System.out.println("=== Produtos ===");
 for (Map.Entry<String, Double> entrada : valor.entrySet()) {
 String produto = entrada.getKey();
 Double valores = entrada.getValue();
 System.out.println(produto + ": " + valor);
 }

 // Calcular média da turma
 double soma = 0;
 for (Double produto : valor.values()) {
 soma += valor;
 }
 double media = soma / valor.size();
 System.out.println("\nMédia da turma: " + media);

 // Buscar nota de um aluno específico
 System.out.print("\nDigite o nome do aluno: ");
 String nomeBusca = scanner.nextLine();

 if (valor.containsKey(nomeBusca)) {
 System.out.println("Nota de " + nomeBusca + ": " +
 valor.get(nomeBusca));
 } else {
 System.out.println("Aluno não encontrado!");
 }
 }
}