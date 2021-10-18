import calc.CalcImpl;
import model.ReadData;
import model.Status;
import model.StatusType;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //TODO read from file
        //pricePerKg = getValueFromCom(scanner, "Enter pricePerKg:");
        //pricePerKm = getValueFromCom(scanner, "Enter pricePerKm:");




        try(Scanner scanner = new Scanner(System.in)) {
            Status currentStatus = new ReadData(scanner);
            while (currentStatus.getType() != StatusType.EXIT) {
                System.out.println("current type: " + currentStatus.getType());
                currentStatus = currentStatus.handle();
            }
        }


    }
}
