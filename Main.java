import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var atheletes = new ArrayList<Athelete>();

        System.out.print("Digite quantos atletas serão cadastrados: ");
        var amountAthletes = scanner.nextInt();
        
        scanner.nextLine();

        for (var i = 0; i < amountAthletes; i++) {
            System.out.println("Digite os dados do atleta numero " + i + ": ");

            System.out.print("Nome: ");
            var name = scanner.nextLine();

            System.out.print("Sexo (M/F): ");
            var sex = scanner.next().charAt(0);

            if (sex != 'M' && sex != 'F') {
                System.out.println("Valor invalido! Favor digitar F ou M.");
                return;
            }

            System.out.print("Altura: ");
            var height = scanner.nextDouble();

            if (height <= 0) {
                System.out.println("Valor invalido! Favor digitar um valor positivo.");
                return;
            }

            System.out.print("Peso: ");
            var weight = scanner.nextDouble();
            if (weight <= 0) {
                System.out.println("Valor invalido! Favor digitar um valor positivo.");
                return;
            }

            atheletes.add(
                new Athelete(
                    name, sex, 
                    height, weight
                )
            );

            scanner.nextLine();  // Limpar o buffer
        }

        // Relatório
        generateReport(atheletes);
    }

    public static void generateReport(List<Athelete> atheletes) {
        var men = 0;
        var women = 0;
        double totalWeight = 0;
        double totalHeightWomen = 0;
        Athelete highestAthelete = null;

        for (Athelete athelete : atheletes) {
            totalWeight += athelete.getWeight();

            if (athelete.getSex() == 'M') {
                men++;
            } else {
                women++;
                totalHeightWomen += athelete.getHeight();
            }

            if (highestAthelete == null || athelete.getHeight() > highestAthelete.getHeight()) {
                highestAthelete = athelete;
            }
        }

        double averageWeight = totalWeight / atheletes.size();
        double menPercentage = (men * 100.0) / atheletes.size();
        double averageWomenHeight = women > 0 ? totalHeightWomen / women : 0;

        System.out.println("RELATÓRIO!!");
        System.out.printf("Peso médio dos atletas: %.2f%n", averageWeight);
        System.out.println("Atleta mais alto: " + (highestAthelete != null ? highestAthelete.getName() : "N/A"));
        System.out.printf("Porcentagem de homens: %.1f %% %n", menPercentage);
        if (women > 0) {
            System.out.printf("Altura média das mulheres: %.2f%n", averageWomenHeight);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }
    }
}