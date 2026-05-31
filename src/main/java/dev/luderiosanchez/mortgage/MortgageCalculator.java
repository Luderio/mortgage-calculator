package dev.luderiosanchez.mortgage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    private static String calculateMortgage(double principal, float annualInterest, byte period) {
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

       double monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_A_YEAR;
       int numberOfPayments = period * MONTHS_IN_A_YEAR;
       double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
       return NumberFormat.getCurrencyInstance(Locale.of("en", "PH")).format(mortgage);
    }

    public static String getMortgage() {
        System.out.println("Mortgage Calculator");
        System.out.println("------------------------------------");

        double principal = (double) MortgageUtils.inputValidator(1_000, 1_000_000, "Principal");
        float annualInterest = (float) MortgageUtils.inputValidator(0, 30, "Annual Interest");
        byte period = (byte) MortgageUtils.inputValidator(1, 30, "Period (in years)");

        String monthlyPayments = calculateMortgage(principal, annualInterest, period);
        StringBuilder paymentSchedule = getPaymentSchedule(principal, annualInterest, period);
        return "Monthly Payments: "
                + monthlyPayments + "\n"
                + "Payment Schedule \n"
                + "------------------------------------ \n"
                + paymentSchedule;
    }

    private static StringBuilder getPaymentSchedule(double principal, float annualInterest, byte period) {
        /**
         * formula: B = L[(1+c)^n - (1+c)^p]/[(1+c)^n-1]
         * where:
         * B = Loan Balance
         * L = Loan amount/Principal
         * c = monthly interest
         * n = number of payments
         * p = number of payments made/paid
         **/

        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

        double monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_A_YEAR;
        int numberOfPayments = period * MONTHS_IN_A_YEAR;
        int numberOfPaymentsMade = 1;
        ArrayList<String> paymentSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        while (numberOfPaymentsMade < numberOfPayments + 1) {
            double loanBalance = principal * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
            paymentSchedule.add(NumberFormat.getCurrencyInstance(Locale.of("en", "PH")).format(loanBalance));
             numberOfPaymentsMade++;

        }

        for (int i = 0; i < paymentSchedule.toArray().length; i++) {
            result.append("payment ").append(i + 1).append(": ").append(paymentSchedule.toArray()[i]).append("\n");
        }

        return result;
    }


}