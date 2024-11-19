package com.scaler;

import com.scaler.factory.LoanFactory;
import com.scaler.factory.Userfactory;
import com.scaler.service.LoanService;
import com.scaler.service.UserService;
import com.scaler.strategy.SimpleInterestStrategy;

public class LoanEmiCalculator {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserService userService = UserService.getInstance();
        LoanService loanService = LoanService.getInstance();

        userService.createUser(Userfactory.createUser("admin1", true).getUserName(), true);
        userService.createUser(Userfactory.createUser("customer1", false).getUserName(), false);

        loanService.createLoan("admin1", "customer1", 10000, 5.0, 2, new SimpleInterestStrategy());

        loanService.makeEmiPayment("customer1", 500);

        loanService.fetchLoanInfo("customer1", "customer1");

        loanService.fetchAllLoan("admin1");
    }
}