package dev.luderiosanchez;

import dev.luderiosanchez.mortgage.MortgageCalculator;
import dev.luderiosanchez.mortgage.MortgageReport;

public class Main {
    public static void main(String[] args) {

        double principal = (double) MortgageReport.inputValidator(1_000, 1_000_000, "Principal");
        float annualInterest = (float) MortgageReport.inputValidator(0, 30, "Annual Interest");
        byte period = (byte) MortgageReport.inputValidator(1, 30, "Period (in years)");

        var calculator = new MortgageCalculator(principal, annualInterest, period);
        var mortgage = new MortgageReport(calculator);
        mortgage.getMonthlyPayments();
        mortgage.getPaymentSchedule();
    }
}
