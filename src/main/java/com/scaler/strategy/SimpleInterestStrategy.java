package com.scaler.strategy;

public class SimpleInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double principal, double interestRate, int loanTenure) {
        return (principal * interestRate * loanTenure) / 100;
    }
}
