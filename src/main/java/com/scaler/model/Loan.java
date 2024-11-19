package com.scaler.model;

import com.scaler.strategy.InterestStrategy;

import java.util.List;

public class Loan {
    private String adminUserName;
    private String customerUserName;
    private double principalAmount;
    private double interestRate;
    private int loanTenure;
    private List<Double> emiPayments;
    private double remainingAmount;

    public Loan(String adminUserName, String customerUserName, double principalAmount, double interestRate, int loanTenure) {
        this.adminUserName = adminUserName;
        this.customerUserName = customerUserName;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTenure = loanTenure;
    }

    private void calculateEmiPayments(InterestStrategy interestStrategy) {
        double interest = interestStrategy.calculateInterest(principalAmount, interestRate, loanTenure);
        double totalAmount = principalAmount + interest;
        double emi = totalAmount / (loanTenure * 12);
        for(int i = 0; i < loanTenure; i++) {
            emiPayments.add(emi);
        }
        remainingAmount = totalAmount;
    }
    public void makeEmiPayments(double amount) {
        if(remainingAmount > 0 && !emiPayments.isEmpty()) {
          emiPayments.remove(0);
          remainingAmount -= amount;
        }
    }
    public void fetchLoanInfo(){
        System.out.println("Loan Details: ");
        System.out.println("Admin User Name: " + adminUserName);
        System.out.println("Customer User Name: " + customerUserName);
        System.out.println("Principal Amount: " + principalAmount);
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Loan Tenure: " + loanTenure);
        System.out.println("EMI Payments Done: " + (loanTenure * 12 - emiPayments.size()));
        System.out.println("Remaining Emi's: " + emiPayments.size());
    }

    public String getCustomerUserName(){
        return customerUserName;
    }
}
