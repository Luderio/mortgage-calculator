package dev.luderiosanchez.mortgage;

import java.util.Scanner;

public class MortgageUtils {
    public enum LogType {INFO, WARNING, ERROR}
    public static Number inputValidator(int min, int max, String fieldName, Scanner scanner) {
        while (true) {
            System.out.print(fieldName + ": ");
            switch (fieldName) {
                case "Principal":
                    double principal = scanner.nextDouble();
                    if (principal < min || principal > max) {
                        log(LogType.WARNING,"Enter an amount between " + min + " and " + max + ".");
                        continue;
                    } else {
                        return principal;
                    }
                case "Annual Interest":
                    float annualInterest = scanner.nextFloat();
                    if (annualInterest <= min || annualInterest > max) {
                        log(LogType.WARNING, "Enter a value greater than " + min + " and less than or equal to " + max + ".");
                        continue;
                    } else {
                        return annualInterest;
                    }
                case "Period (in years)":
                    byte period = scanner.nextByte();
                    if (period < min || period > max) {
                        log(LogType.WARNING, "Enter a value between" + min + " and " + max + ".");
                        continue;
                    } else {
                        return period;
                    }
                default:
                    log(LogType.WARNING, "Enter a value between" + min + " and " + max + ".");
            }
        }
    }
    public static void log(LogType type, Object data, String message) {
        String output = "[" + type.name() + "] " + message + ".";

        if (data != null) {
            output = "[" + type.name() + "] " + message + " " + data.toString() + ".";
        }

        switch (type) {
            case INFO, WARNING:
                System.out.println(output);
                break;
            case ERROR:
                throw new RuntimeException(output);
            default:
                System.out.println("The provided log type is invalid!");
        }
    }

    public static void log(LogType type, String message) {
        String outputWithoutData = "[" + type.name() + "] " + message;

        switch (type) {
            case INFO, WARNING:
                System.out.println(outputWithoutData);
                break;
            case ERROR:
                throw new RuntimeException(outputWithoutData);
            default:
                System.out.println("The provided log type is invalid!");
        }
    }
}
