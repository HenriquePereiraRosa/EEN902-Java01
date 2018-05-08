/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model.BankAccount;

import banksystem.model.Enum.AccountTypeEnum;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 11.02741-0
 */
public class BankAccount {
    
    private final SimpleStringProperty accountNumber;
    private final ObjectProperty<AccountTypeEnum> type;
    private final ListProperty<Integer> extract;

    
    public BankAccount(String accountNumber, AccountTypeEnum type, int balance) {
        this.accountNumber = new SimpleStringProperty(accountNumber);
        this.type = new ObjectProperty<AccountTypeEnum>(type);
        this.extract = new ListProperty<>(balance);
    }

    public BankAccount(String accountNumber, AccountTypeEnum type) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.extract = new ArrayList<>(0);
    }
    
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.setType(AccountTypeEnum.CORRENTE);
        this.extract = new ArrayList<>(0);
    }

    public BankAccount(String accountNumber, AccountTypeEnum type, List<Integer> extract) {
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

    public AccountTypeEnum getType() {
        return type;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
    }

    
    public int getBalance() {
        Integer balance = 0;
        for(Integer item : extract)
            balance += item;        
        return balance;
    }

    public void deposit(int value) {
        this.extract.add(value);
    }

    public List<Integer> getExtract() {
        return extract;
    }

    public void setExtract(List<Integer> extract) {
        this.extract = extract;
    }
        
}
