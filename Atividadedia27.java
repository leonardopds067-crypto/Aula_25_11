import java.util.Scanner;

public class Atividadedia27 {

    public static double calcularIMC(double peso, double altura) {
        // função 1
        double imc = peso / (altura * altura);
        return imc;
    }

    public static String classificacarIMC(double imc) {
        // função 2
        if (imc <= 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "peso normal";
        } else if (imc >= 25.0 && imc <= 29.9) {
            return "sobrepeso";
        } else {
            return "obesidade";
        }
    }

    // inserir peso e altura
    public static void main(String[] args) {
        Scanner entradaDados = new Scanner(System.in);
        System.out.println("Digite o peso (kg):");
        double peso = entradaDados.nextDouble();
        
        System.out.println("Digite a altura (m):");
        double altura = entradaDados.nextDouble();
        
        double imc = calcularIMC(peso, altura);
        String classificacao = classificacarIMC(imc);
        
        System.out.printf("IMC: %.2f - %s%n", imc, classificacao);
        
        entradaDados.close();
    }
}
