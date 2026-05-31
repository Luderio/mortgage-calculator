package dev.luderiosanchez.mortgage;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {
    final static byte MONTHS_IN_A_YEAR = 12;
    final static byte PERCENT = 100;

    private double principal;
    private float annualInterest;
    private byte period;

    public MortgageCalculator(double principal, float annualInterest, byte period) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.period = period;
    }

    public MortgageCalculator() {
    }

    public String calculateMortgage() {

       double monthlyInterest = getMonthlyInterest();
       int numberOfPayments = getNumberOfPayments();
       double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
       return NumberFormat.getCurrencyInstance(Locale.of("en", "PH")).format(mortgage);
    }

    public void getMortgage() {
        System.out.println("Mortgage Calculator");
        System.out.println("------------------------------------");

        double principal = (double) MortgageReport.inputValidator(1_000, 1_000_000, "Principal");
        float annualInterest = (float) MortgageReport.inputValidator(0, 30, "Annual Interest");
        byte period = (byte) MortgageReport.inputValidator(1, 30, "Period (in years)");

        var mortgage = new MortgageCalculator(principal, annualInterest, period);
        var mortgageDetails = new MortgageReport(mortgage);
        mortgageDetails.getMonthlyPayments();
        mortgageDetails.getPaymentSchedule();
    }

    public float getMonthlyInterest() {
        return (annualInterest / PERCENT) / MONTHS_IN_A_YEAR;
    }

    public int getNumberOfPayments() {
        return period * MONTHS_IN_A_YEAR;
    }

    public double getPrincipal() {
        return principal;
    }
}