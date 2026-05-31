package dev.luderiosanchez.mortgage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MortgageCalculator {
    final static byte MONTHS_IN_A_YEAR = 12;
    final static byte PERCENT = 100;
    private NumberFormat currency;

    private double principal;
    private float annualInterest;
    private byte period;

    private MortgageCalculator(double principal, float annualInterest, byte period) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.period = period;

        currency = NumberFormat.getCurrencyInstance(Locale.of("en", "PH"));
    }

    public MortgageCalculator() {
    }

    public String calculateMortgage() {
       double monthlyInterest = getMonthlyInterest();
       int numberOfPayments = getNumberOfPayments();
       double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
       return currency.format(mortgage);
    }

    public ArrayList<String> getPaymentSchedule() {
        /*
          formula: B = L[(1+c)^n - (1+c)^p]/[(1+c)^n-1]
          where:
          B = Loan Balance
          L = Loan amount/Principal
          c = monthly interest
          n = number of payments
          p = number of payments made/paid
         */

        double monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();
        int numberOfPaymentsMade = 1;
        ArrayList<String> paymentSchedule = new ArrayList<>();


        while (numberOfPaymentsMade < numberOfPayments + 1) {
            double loanBalance = getPrincipal() * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
            paymentSchedule.add(currency.format(loanBalance));
            numberOfPaymentsMade++;

        }
        return paymentSchedule;
    }

    public void getMortgage() {
        System.out.println("Mortgage Calculator");
        System.out.println("------------------------------------");

        double principal = (double) MortgageReport.inputValidator(1_000, 1_000_000, "Principal");
        float annualInterest = (float) MortgageReport.inputValidator(0, 30, "Annual Interest");
        byte period = (byte) MortgageReport.inputValidator(1, 30, "Period (in years)");

        var mortgage = new MortgageCalculator(principal, annualInterest, period);
        var mortgageDetails = new MortgageReport(mortgage);

        mortgageDetails.printMonthlyPayments();
        mortgageDetails.printPaymentSchedule();
    }


    private float getMonthlyInterest() {
        return (annualInterest / PERCENT) / MONTHS_IN_A_YEAR;
    }

    private int getNumberOfPayments() {
        return period * MONTHS_IN_A_YEAR;
    }

    private double getPrincipal() {
        return principal;
    }
}