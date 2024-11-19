package com.scaler.service;

import com.scaler.model.Loan;
import com.scaler.model.User;
import com.scaler.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanService {
    private static LoanService instance;
    private Map<String, List<Loan>> loans;
    private UserService userService;

     private LoanService() {
         loans = new HashMap<>();
         userService = userService.getInstance();
     }

     public static synchronized LoanService getInstance() {
         if (instance == null) {
             instance = new LoanService();
         }
         return instance;
     }
      public void createLoan(String adminUserName, String customerUserName, double principalAmount, double interestRate, int loanTenure, InterestStrategy interestStrategy) {

         User admin = userService.getUser(adminUserName);
         if(admin != null && admin.isAdmin()){
             Loan newLoan = new Loan(adminUserName, customerUserName, principalAmount, interestRate, loanTenure);
             loans.computeIfAbsent(adminUserName, k -> new ArrayList<>()).add(newLoan);
             System.out.println("Created loan: " + newLoan);
         }
         else {
             System.out.println("User not found");
         }
      }
      public void makeEmiPayment(String customerUserName, double amount){
         List<Loan> customerLoans = loans.get(customerUserName);
         if(customerLoans != null && customerLoans.size() > 0){
             for(Loan loan : customerLoans){
                 loan.makeEmiPayments(amount);
             }
             System.out.println("Emi payment made");
         }
         else{
             System.out.println("No active loans found for the User:" + customerUserName);
         }
      }
      public void fetchLoanInfo(String customerUserName, String requestUserName){
         if(!customerUserName.equals(requestUserName)){
             System.out.println("Access denied. You are not authorized");
             return;
         }
         List<Loan> customerLoans = loans.get(customerUserName);
         if(customerLoans != null && customerLoans.size() > 0){
             for(Loan loan : customerLoans){
                 loan.fetchLoanInfo();
                 System.out.println("Fetched loan info");
             }
         }
         else{
             System.out.println("No active Loan found for the User:" + customerUserName);
         }
      }

      public void fetchAllLoan(String adminUserName){
         User adminUser = userService.getUser(adminUserName);
         if(adminUser != null && adminUser.isAdmin()){
             for(List<Loan> loans : loans.values()){
                 for(Loan loan : loans){
                     loan.fetchLoanInfo();
                     System.out.println("Fetched loan info");
                 }
             }
         }
         else{
             System.out.println("Admin with User Name" + adminUserName + " not found");
         }
      }
}
