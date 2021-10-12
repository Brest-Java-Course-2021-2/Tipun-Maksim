import calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        BigDecimal weight, pricePerKg, length, pricePerKm;
        String close;


        try(Scanner scanner = new Scanner(System.in)) {
            do {
                Scanner scanner2 = new Scanner(System.in);
                weight = getValueFromCom(scanner, "Enter weight:");
                pricePerKg = getValueFromCom(scanner, "Enter pricePerKg:");
                length = getValueFromCom(scanner, "Enter km:");
                pricePerKm = getValueFromCom(scanner, "Enter pricePerKm:");

                System.out.println("Result: " + new CalcImpl().handle(weight,pricePerKg,length,pricePerKm));
                System.out.println("Enter 'q' to exit, or continue typing");
                close = scanner2.nextLine();
            }while (!close.equals("q"));
            System.out.println("Ввод завершен");
        }
    }
    private static BigDecimal getValueFromCom(Scanner scanner, String outputMesage) {
        BigDecimal enteredValue;
        System.out.print(outputMesage);
        enteredValue = scanner.nextBigDecimal();
        return enteredValue;
    }
}
