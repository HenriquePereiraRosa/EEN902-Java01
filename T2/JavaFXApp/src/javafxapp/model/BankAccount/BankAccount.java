/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model.BankAccount;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 11.02741-0
 */
public class BankAccount {
    
    private final SimpleStringProperty accountNumber;
    private final SimpleIntegerProperty accountType;
    private final ListProperty<Double> extract;

    
    public BankAccount(String accountNumber, Integer type, Double balance) {
        this.accountNumber = new SimpleStringProperty(accountNumber);
        this.accountType = new SimpleIntegerProperty(type);
        List<Double> list = new ArrayList<>();
        list.add(balance);
        ObservableList<Double> observableList = FXCollections.observableArrayList(list);
        this.extract = new SimpleListProperty<>(observableList);
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = new SimpleStringProperty(accountNumber);
        this.accountType = new SimpleIntegerProperty(0);
        List<Double> list = new ArrayList<>();
        list.add(0.0);
        ObservableList<Double> observableList = FXCollections.observableArrayList(list);
        this.extract = new SimpleListProperty<>(observableList);
    }
    
    public String getAccountNumber() {
        return accountNumber.get();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }

    public Integer getAccountType() {
        return accountType.get();
    }
    
    public void setAccounttype(Integer type) {
        this.accountType.set(type);
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
    
    public String toString() {
        
        String accountType = "";
        switch(this.getAccountType()) {
            case 0:
                accountType = "Corrente";
                break;
            case 1:
                accountType = "Poupança";
                break;
            case 2:
                accountType = "DI";
                break;
            case 3:
                accountType = "Tesouro";
                break;
        }
        return accountType;
    }
        
}
