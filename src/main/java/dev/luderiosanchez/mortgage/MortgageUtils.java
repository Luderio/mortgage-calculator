package dev.luderiosanchez.mortgage;

import java.util.Scanner;

public class MortgageUtils {

    private static final ConsoleLogger log = new ConsoleLogger();
    private static final Scanner scanner = new Scanner(System.in);

    public static Number inputValidator(int min, int max, String fieldName) {
        while (true) {
            System.out.print(fieldName + ": ");
            switch (fieldName) {
                case "Principal":
                    double principal = scanner.nextDouble();
                    if (principal < min || principal > max) {
                        log.warning("Enter an amount between " + min + " and " + max + ".");
                        continue;
                    } else {
                        return principal;
                    }
                case "Annual Interest":
                    float annualInterest = scanner.nextFloat();
                    if (annualInterest <= min || annualInterest > max) {
                        log.warning("Enter a value greater than " + min + " and less than or equal to " + max + ".");
                        continue;
                    } else {
                        return annualInterest;
                    }
                case "Period (in years)":
                    byte period = scanner.nextByte();
                    if (period < min || period > max) {
                        log.warning("Enter a value between" + min + " and " + max + ".");
                        continue;
                    } else {
                        return period;
                    }
                default:
                    log.warning("Invalid Field Added. Please make sure that you added a correct field.");
            }
        }
    }
}
