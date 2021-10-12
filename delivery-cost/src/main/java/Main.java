import calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //result = m*pricePerKg + km*pricePerKm;
        //prop / json/ csv

        BigDecimal weight, pricePerKg, length, pricePerKm;

        try(Scanner scanner = new Scanner(System.in)) {
            do {
                weight = getValueFromCom(scanner, "Enter weight:");
                pricePerKg = getValueFromCom(scanner, "Enter pricePerKg:");
                length = getValueFromCom(scanner, "Enter km:");
                pricePerKm = getValueFromCom(scanner, "Enter pricePerKm:");


                System.out.println("Result: " + new CalcImpl().handle(weight,pricePerKg,length,pricePerKm));
                System.out.println("Enter 'q' to exit and 'c' to continue");
            }while (!scanner.hasNext("q"));
        }
    }
    private static BigDecimal getValueFromCom(Scanner scanner, String outputMesage) {
        BigDecimal enteredValue;
        System.out.print(outputMesage);
        enteredValue = scanner.nextBigDecimal();
        return enteredValue;
    }
}
