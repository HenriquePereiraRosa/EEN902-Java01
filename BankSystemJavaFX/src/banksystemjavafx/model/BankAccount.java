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
    
    private String accountNumber;
    private String type;
    private List<Integer> extract;

    public BankAccount(String accountNumber, String type, int balance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.extract = new ArrayList<>(balance);
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.extract = new ArrayList<>();
    }

    public BankAccount(String accountNumber, String type, List<Integer> extract) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.extract = extract;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public int getBalance() {
        Integer balance = 0;
        for(Integer item : extract)
            balance += item;        
        return balance;
    }

    public void transfer(int value) {
        this.extract.add(value);
    }

    public List<Integer> getExtract() {
        return extract;
    }

    public void setExtract(List<Integer> extract) {
        this.extract = extract;
    }
    
}
