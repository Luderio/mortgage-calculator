package dev.luderiosanchez;

import dev.luderiosanchez.mortgage.MortgageCalculator;

public class Main {
    public static void main(String[] args) {
        String mortgage = MortgageCalculator.getMortgage();
        System.out.println(mortgage);
    }
}
