package com.scaler.factory;

import com.scaler.model.Loan;

public class LoanFactory {
    public static Loan createLoan(String adminUserName, String customerUserName, double principalAmount, double interestRate, int loanTenure){
        return new Loan(adminUserName, customerUserName, principalAmount, interestRate, loanTenure);
    }
}
