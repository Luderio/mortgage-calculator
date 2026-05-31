package dev.luderiosanchez.mortgage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MortgageReport {

    private final MortgageCalculator calculator;
    private static final Scanner scanner = new Scanner(System.in);
    private static final ConsoleLogger log = new ConsoleLogger();

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

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

    public void printMonthlyPayments() {
        double monthlyPayments = calculator.calculateMortgage();
        System.out.println("------------------------------------ \n Monthly Payments: " + monthlyPayments);
    }

    public void printPaymentSchedule() {
        ArrayList<String> paymentSchedule = calculator.getPaymentSchedule();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < paymentSchedule.toArray().length; i++) {
            result.append("payment ").append(i + 1).append(": ").append(paymentSchedule.toArray()[i]).append("\n");
        }

        System.out.println("------------------------------------ \n Payment Schedule: \n------------------------------------ \n".concat(result.toString()));
    }


}
