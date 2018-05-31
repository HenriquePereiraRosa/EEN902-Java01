/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model.BankUser;

import java.util.ArrayList;
import javafxapp.model.BankAccount.BankAccount;
import java.util.List;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 11.02741-0
 */
public class BankUser {
 
    private final StringProperty name;
    private final StringProperty cpf;
    private final IntegerProperty hierarchy;
    private final StringProperty password;
    private final ListProperty<BankAccount> accounts;
    
    
    public BankUser(BankUser another) {
        this.name = new SimpleStringProperty(another.getName());
        this.cpf = new SimpleStringProperty(another.getCpf());
        this.password = new SimpleStringProperty(another.getPassword());
        this.hierarchy = new SimpleIntegerProperty(another.getHierarchy());
        this.accounts = new SimpleListProperty<>();
        this.accounts.addAll(another.getAccountList());
    }
    
    public BankUser(String name, String cpf, Integer hierarchy, String password, List<BankAccount> accountList) {
        this.name = new SimpleStringProperty(name);
        this.cpf = new SimpleStringProperty(cpf);
        this.hierarchy = new SimpleIntegerProperty(hierarchy);
        this.password = new SimpleStringProperty(password);
        
        ObservableList<BankAccount> observableList = FXCollections.observableArrayList(accountList);
        this.accounts = new SimpleListProperty<>(observableList);
    }
    
    public BankUser(String name, String cpf, Integer hierarchy, String password, BankAccount account) {
        this.name = new SimpleStringProperty(name);
        this.cpf = new SimpleStringProperty(cpf);
        this.hierarchy = new SimpleIntegerProperty(hierarchy);
        this.password = new SimpleStringProperty(password);
        
        List<BankAccount> list = new ArrayList<>();
        list.add(account);
        ObservableList<BankAccount> observableList = FXCollections.observableArrayList(list);
        this.accounts = new SimpleListProperty<>(observableList);
    }
    
    public BankUser(String name, String cpf, Integer hierarchy, String password, String accountNumber, Integer type, Double balance ) {
        this.name = new SimpleStringProperty(name);
        this.cpf = new SimpleStringProperty(cpf);
        this.hierarchy = new SimpleIntegerProperty(hierarchy);
        this.password = new SimpleStringProperty(password);
        
        BankAccount account = new BankAccount(accountNumber, type, balance);
        List<BankAccount> list = new ArrayList<>();
        list.add(account);
        ObservableList<BankAccount> observableList = FXCollections.observableArrayList(list);
        this.accounts = new SimpleListProperty<>(observableList);
    }
    
    public BankUser(String name, String cpf, Integer hierarchy, String password) {
        this.name = new SimpleStringProperty(name);
        this.cpf = new SimpleStringProperty(cpf);
        this.hierarchy = new SimpleIntegerProperty(hierarchy);
        this.password = new SimpleStringProperty(password);
        this.accounts = new SimpleListProperty<>();
    }
    
    public StringProperty nameProperty() {
        return this.name;
    }
    
    public StringProperty cpfProperty() {
        return this.cpf;
    }
    
    public StringBinding accountNumberProperty() {
        return this.accounts.asString();
    }
    
    public IntegerProperty hierarchyProperty() {
        return this.hierarchy;
    }
    
    public String getName() {
        return name.get();
    }
    
    public void setName(String name) {
        this.name.set(name);
    }

    public String getCpf() {
        return cpf.get();
    }
    
    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public Integer getHierarchy() {
        return hierarchy.get();
    }
    
    public String getHierarchyAsString() {
        String string = "";
        switch(this.hierarchy.get()) {
            case 0:
                string = "Cliente";
                break;
              
            case 1:
                string = "Employee";
                break;
              
            case 2:
                string = "Manager";
                break;
        }
        return string;
    }

    public void setHierarchy(Integer hierarchy) {
        this.hierarchy.set(hierarchy);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public List<BankAccount> getAccountList() {
        return accounts.subList(0, accounts.size());
    }

    public void setAccountList(List<BankAccount> accountList) {
        this.accounts.clear();
        this.accounts.addAll(accountList);
    }
    
    public void addAccount(String agency, String accountNumber, Integer type, Double initialValue) {
        BankAccount account = new BankAccount(accountNumber, type, initialValue);
        accounts.add(account);
    }
    
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
    
    public boolean removeAccount(BankAccount account) {
        
        if(accounts.contains(account)){
            accounts.remove(account);
            return true;
        } 
        return false;
    }
    public boolean removeAccount(String accountNumber) {
        
        if(accounts.contains(accountNumber)){
            accounts.remove(accountNumber);
            return true;
        } 
        return false;
    }
    
    public boolean deposit(String accountNumber, Double value){
        BankAccount account = searchAccount(accountNumber);
        if(account != null) {
            account.deposit(value);
            return true;
        } else
            return false;
    }
    
    public BankAccount searchAccount(String accountNumber) {
        accountNumber.replace(" ", "");
        for (BankAccount account : accounts) {
            if(accountNumber.equals(account.getAccountNumber())) {
                return account;
            }
        } 
        return null;
    }
    
    
    @Override
    public String toString() {
        String string = this.getName() + '\n' + this.getCpf() + '\n' 
                + this.getPassword() +'\n' + this.getHierarchyAsString() + '\n' +
                this.getAccountListToString();
        
        return string;
    }

    
    private String getAccountListToString() {
        List<BankAccount> list = this.getAccountList();
        String string = "";
        for(BankAccount account : list){
            string = "CONTA: " + account.getAccountNumber() +
                    "TIPO: " + account.toString() + '\n';
        }
        return string;
    }
}
