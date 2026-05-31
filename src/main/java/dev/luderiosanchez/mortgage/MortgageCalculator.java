package dev.luderiosanchez.mortgage;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {
    public static String calculateMortgage(double principal, float annualInterest, byte period) {
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

       double monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_A_YEAR;
       int numberOfPayments = period * MONTHS_IN_A_YEAR;
       double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
       return NumberFormat.getCurrencyInstance(Locale.of("en", "PH")).format(mortgage);
    }

    public static void getMortgage() {
        System.out.println("Mortgage Calculator");
        System.out.println("------------------------------------");

        double principal = (double) MortgageUtils.inputValidator(1_000, 1_000_000, "Principal");
        float annualInterest = (float) MortgageUtils.inputValidator(0, 30, "Annual Interest");
        byte period = (byte) MortgageUtils.inputValidator(1, 30, "Period (in years)");

        String monthlyPayments = MortgageUtils.getMonthlyPayments(principal, annualInterest, period);
        String paymentSchedule = MortgageUtils.getPaymentSchedule(principal, annualInterest, period);

        System.out.println(monthlyPayments);
        System.out.println(paymentSchedule);
    }


}