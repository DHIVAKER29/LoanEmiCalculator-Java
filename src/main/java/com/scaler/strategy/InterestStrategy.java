package com.scaler.strategy;

public interface InterestStrategy {
    double calculateInterest(double principal, double interestRate, int loanTenure);
}
