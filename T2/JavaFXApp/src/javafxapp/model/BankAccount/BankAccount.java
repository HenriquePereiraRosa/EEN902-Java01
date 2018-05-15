/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model.BankAccount;

import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 11.02741-0
 */
public class BankAccount {
    
    private final SimpleStringProperty accountNumber;
    private final ListProperty<Double> extract;

    
    public BankAccount(String accountNumber, Double balance) {
        this.accountNumber = new SimpleStringProperty(accountNumber);
        this.extract = new SimpleListProperty<>();
        this.extract.add(balance);
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = new SimpleStringProperty(accountNumber);
        this.extract = new SimpleListProperty<>();
        this.extract.add(0.0);
    }
    
    public String getAccountNumber() {
        return accountNumber.get();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }

    public Double getBalance() {
        Double balance = 0.0;
        List<Double> extractTemp = getExtract();
        for(Double item : extractTemp)
            balance += item;
        return balance;
    }

    public void deposit(Double value) {
        this.extract.add(value);
    }

    public List<Double> getExtract() {
        return extract.get();
    }

    public void setExtract(List<Double> extract) {
        List<Double> extractTemp = extract;
        this.extract.clear();
        this.extract.addAll(extractTemp);
    }
        
}
