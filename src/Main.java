import java.util.Scanner;

public class Main {

    /*
     * Função que calcula o imposto (INSS) incidente sobre o salário bruto
     * (parametro), de acordo com as faixas de salários fornecidas.
     */

    public static double calcularInss(double salarioB) {
        double inss = 0.0;

        if (salarioB <= 1212.00) {

            inss = salarioB * 0.075;

        } else if (salarioB <= 2427.35) {

            inss = salarioB * 0.09;

        } else if (salarioB <= 3641.03) {

            inss = salarioB * 0.12;

        } else if (salarioB > 3641.03) {

            inss = salarioB * 0.14;

        }

        return inss;
    }

    /*
     * Função que calcula o imposto de renda incidente sobre o salário bruto
     * (parametro), de acordo com as faixas de salários fornecidas.
     */

    public static double calcularIr(double salarioB) {

        double ir = 0.0;

        if (salarioB <= 1903.98) {

            ir = 0.0;

        } else if (salarioB <= 2826.65) {

            ir = salarioB * 0.075;

        } else if (salarioB <= 3751.05) {

            ir = salarioB * 0.15;

        } else if (salarioB <= 4664.68) {

            ir = salarioB * 0.225;

        } else if (salarioB > 4664.68) {

            ir = salarioB * 0.275;

        }

        return ir;
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // Legenda matriz salarios:
        // [0] -> Salário bruto
        // [1] -> INSS
        // [2] -> Imposto de Renda
        // [3] -> Salário Líquido
        double[][] salarios = new double[5][4];

        /*
         * Esta matriz de strings será utilizada no momento de exibir os slários no
         * terminal
         */
        String[] posicoes = { "primeiro", "segundo", "terceiro", "quarto", "quinto" };

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Nesta parte você digitara 5 salários bruto dos seus funcionários:");
        System.out.println("Neste formato, por gentileza: 1000 ou 1000.00");
        System.out.println("-----------------------------------------------------------------\n");

        /*
         * for que solicita ao usuario os salários, com verificação de salario negativo
         * digitado.
         */

        for (int i = 0; i < salarios.length; i++) {

            System.out.printf("Digite o %s Salário: ", posicoes[i]);
            salarios[i][0] = scanner.nextDouble();

            if (salarios[i][0] < 0) {
                System.out.println("\n Digite um salário válido! ------\n");
                i--;
            }
        }

        /*
         * Parte final do código que chama as funções calcularInss e CalcularIr, e exibe
         * para o usuário os salários líquidos calculados.
         */
        System.out.println("\n------------- Resultados -------------");

        for (int i = 0; i < salarios.length; i++) {

            System.out.printf("\nCalculo do %s salário:\n", posicoes[i]);
            salarios[i][1] = calcularInss(salarios[i][0]);
            salarios[i][2] = calcularIr(salarios[i][0]);
            salarios[i][3] = salarios[i][0] - salarios[i][1] - salarios[i][2];

            System.out.printf(" -Salário bruto: R$ %.2f\n", salarios[i][0]);
            System.out.printf(" -Desconto INSS: R$ %.2f\n", salarios[i][1]);
            System.out.printf(" -Desconto Imposto de Renda: R$ %.2f\n", salarios[i][2]);
            System.out.printf(" -Salário Líquido: R$ %.2f\n", salarios[i][3]);
        }
        scanner.close();
    }

}
