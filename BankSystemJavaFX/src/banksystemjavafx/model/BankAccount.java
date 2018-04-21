/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 11.02741-0
 */
public class BankAccount {
    
    private String agency;
    private String accountNumber;
    private int balance;
    private List<Integer> extract;

    public BankAccount(String agency, String accountNumber, int balance, List<Integer> extract) {
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.extract = extract;
    }

    public BankAccount(String agency, String accountNumber, int balance) {
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(String agency, String accountNumber, List<Integer> extract) {
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.extract = extract;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Integer> getExtract() {
        return extract;
    }

    public void setExtract(List<Integer> extract) {
        this.extract = extract;
    }
    
    
    
    
    
    
    
    
}
