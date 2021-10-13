import calc.CalcImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //result = m*pricePerKg + km*pricePerKm;
        //prop / json/ csv

        BigDecimal weight, pricePerKg, length, pricePerKm, result;
        File file = new File("inputdata.txt");
        File fileOut = new File("result.txt");
        try (Scanner scanner = new Scanner(file); PrintWriter pw = new PrintWriter(fileOut)) {
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
                result = new CalcImpl().handle(weight,pricePerKg,length,pricePerKm);
                System.out.println("Result: " + result);
                pw.println(result);
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
