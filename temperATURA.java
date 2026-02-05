import java.util.Scanner;

public class temperATURA {
    public static void main(String[] args) {

        // Declaração de variaveis
        double temperaturaMediaAnoAtual = 0;
        double temperaturaMediaAnoAnterior = 0;

        // Declaração dos vetores de meses
        String[] meses = {
                "Janeiro", "Fevereiro", "Março", "Maio", "Abril", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
                "Novembro", "Dezembro"
        };

        // Declaração dos vetores de temperaturas
        double[] tempAnoAtual = { 25.0, 26.5, 28.0, 30.0, 32.5, 35.0, 36.0, 35.5, 33.0, 30.0, 28.0, 26.0 };
        double[] tempAnoAnterior = { 24.0, 25.5, 27.0, 29.0, 31.5, 34.0, 35.0, 34.5, 32.0, 29.0, 27.0, 25.0 };

        // Declaração de variaveis
        double Maiortemperatura = tempAnoAtual[0];
        double Menortemperatura = tempAnoAtual[0];

        // Calcule a temperatura anual desse ano
        double somaAnoAtual = 0;
        double somaAnoAnterior = 0;

        for (int i = 0; i < 12; i++) {
            // somaAtual = soamAnoAtual + tempAnoAtual[1];
            somaAnoAtual += tempAnoAtual[i];
            somaAnoAnterior += tempAnoAnterior[i];

            temperaturaMediaAnoAnterior += tempAnoAnterior[i] / 12;

            // Localizando a maior e menor temperatura
            if (tempAnoAtual[i] > Maiortemperatura) {
                Maiortemperatura = tempAnoAtual[i];
            }
            if (tempAnoAtual[i] < Menortemperatura) {
                Menortemperatura = tempAnoAtual[i];
            }
        }
        temperaturaMediaAnoAtual = somaAnoAtual / 12;
        // APRESENTAÇÃO DO RESULTADO
        System.out.println("=== ANALISE DE TEMPERATURAS MENSAIS ===\n");
        System.out.println(
                "Temperatura média anual do (ano atual):" + String.format("%.2f", temperaturaMediaAnoAtual) + "°C");
        System.out.println("Temperatura média anual do (ano amterior):"
                + String.format("%.2f", temperaturaMediaAnoAnterior) + "°C\n");

        System.out.println(" Maior Temperatura média anual do (ano atual):" + String.format("%.2f", Maiortemperatura) + "°C");
        System.out.println(" Menor Temperatura média anual do (ano amterior):" + String.format("%.2f", Menortemperatura) + "°C\n");

    }

}
