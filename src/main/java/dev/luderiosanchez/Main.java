package dev.luderiosanchez;

import dev.luderiosanchez.mortgage.MortgageCalculator;

public class Main {
    public static void main(String[] args) {
        var mortgage = new MortgageCalculator("en", "PH");
        mortgage.getMortgage();
    }
}
