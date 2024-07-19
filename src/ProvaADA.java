import java.util.Scanner;

public class ProvaADA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] salarioBto = new double[5];
        double[] salarioLiq = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o salário  " + (i + 1) + ": ");
            salarioBto[i] = sc.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            salarioLiq[i] = calculoSalarioLiquido(salarioBto[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Funcionário " + (i + 1) + ":");
            System.out.printf("BRUTO: R$ %.2f\n", salarioBto[i]);
            System.out.printf(" INSS: R$ %.2f\n", descontoInss(salarioBto[i]));
            System.out.printf("IR: R$ %.2f\n", descontoImpostoRenda(salarioBto[i]));
            System.out.printf("Salário COM DESCONTOS: R$ %.2f\n", salarioLiq[i]);
            System.out.println();
        }

        sc.close();
    }
    public static double descontoInss(double salarioBto) {
        if (salarioBto <= 1212.00) {
            return salarioBto * 0.075;
        } else if (salarioBto <= 2427.35) {
            return salarioBto * 0.09;
        } else if (salarioBto <= 3641.03) {
            return salarioBto * 0.12;
        } else {
            return salarioBto * 0.14;
        }
    }

    public static double descontoImpostoRenda(double salarioBruto) {
        if (salarioBruto <= 1903.98) {
            return 0;
        } else if (salarioBruto <= 2826.65) {
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 3751.05) {
            return salarioBruto * 0.15;
        } else if (salarioBruto <= 4664.68) {
            return salarioBruto * 0.225;
        } else {
            return salarioBruto * 0.275;
        }
    }

    public static double calculoSalarioLiquido(double salarioBruto) {
        double descontoINSS = descontoInss(salarioBruto);
        double descontoIR = descontoImpostoRenda(salarioBruto);
        return salarioBruto - descontoINSS - descontoIR;


    }




}
