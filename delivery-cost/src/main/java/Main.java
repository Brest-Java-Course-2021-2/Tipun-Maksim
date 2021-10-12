import calc.CalcImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //result = m*pricePerKg + km*pricePerKm;
        //prop / json/ csv

        BigDecimal weight, pricePerKg, length, pricePerKm;
        String close;
        File file = new File("inputdata.txt");
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            String[]numbers = line.split(" ");

            if(numbers.length % 4 != 0){
                throw new IllegalArgumentException();}
                int quantytyNumbers = numbers.length;
                int i = 0;
            do {
                weight = getValueFromCom(numbers[i], "Weight:");
                pricePerKg = getValueFromCom(numbers[i+1], "PricePerKg:");
                length = getValueFromCom(numbers[i+2], "km:");
                pricePerKm = getValueFromCom(numbers[i+3], "PricePerKm:");

                System.out.println("Result: " + new CalcImpl().handle(weight,pricePerKg,length,pricePerKm));
                quantytyNumbers -= 4;
                i += 4;
            }while (quantytyNumbers != 0);
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }catch (IllegalArgumentException e){
            System.out.println("Некорректный входной файл");
        }
    }
    private static BigDecimal getValueFromCom(String number, String outputMesage) {
        BigDecimal enteredValue = new BigDecimal(number);
        System.out.println(outputMesage + " = " + enteredValue);
        return enteredValue;
    }
}
