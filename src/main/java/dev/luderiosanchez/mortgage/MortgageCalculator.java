package dev.luderiosanchez.mortgage;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {
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
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

       double monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_A_YEAR;
       int numberOfPayments = period * MONTHS_IN_A_YEAR;
       double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
       return NumberFormat.getCurrencyInstance(Locale.of("en", "PH")).format(mortgage);
    }

    public double getPrincipal() {
        return principal;
    }

    public float getAnnualInterest() {
        return annualInterest;
    }

    public byte getPeriod() {
        return period;
    }

        public void getMortgage() {
        System.out.println("Mortgage Calculator");
        System.out.println("------------------------------------");

        double principal = (double) MortgageReport.inputValidator(1_000, 1_000_000, "Principal");
        float annualInterest = (float) MortgageReport.inputValidator(0, 30, "Annual Interest");
        byte period = (byte) MortgageReport.inputValidator(1, 30, "Period (in years)");

            var calculator = new MortgageCalculator(principal, annualInterest, period);
            var mortgage = new MortgageReport(calculator);
            mortgage.getMonthlyPayments();
            mortgage.getPaymentSchedule();
    }


}