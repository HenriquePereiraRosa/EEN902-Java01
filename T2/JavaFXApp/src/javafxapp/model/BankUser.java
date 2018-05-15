/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model;

import javafxapp.model.BankAccount.BankAccount;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 11.02741-0
 */
public class BankUser implements Serializable {
 
    private StringProperty name;
    private StringProperty CPF;
    private IntegerProperty hierarchy;
    private StringProperty password;
    private ListProperty<BankAccount> accounts;
    
    
    public BankUser(BankUser another) {
        this.name = new SimpleStringProperty(another.getName());
        this.CPF = new SimpleStringProperty(another.getCPF());
        this.password = new SimpleStringProperty(another.getPassword());
        this.hierarchy = new SimpleIntegerProperty(another.getHierarchy());
        this.accounts = new SimpleListProperty<>();
        this.accounts.addAll(another.getAccountList());
    }
    
    public BankUser(String name, String CPF, String password, List<BankAccount> accountList) {
        this.name = new SimpleStringProperty(name);
        this.CPF = new SimpleStringProperty(CPF);
        this.password = new SimpleStringProperty(password);
        this.accounts = new SimpleListProperty<>();
        this.accounts.addAll(accountList);
    }
    
    public BankUser(String name, String CPF, int hierarchy, String password, BankAccount account) {
        this.name = new SimpleStringProperty(name);
        this.CPF = new SimpleStringProperty(CPF);
        this.hierarchy = new SimpleIntegerProperty(hierarchy);
        this.password = new SimpleStringProperty(password);
        this.accounts = new SimpleListProperty<>();
        this.accounts.add(account);
    }
    
    public BankUser(String name, String CPF, int hierarchy, String password, String accountNumber, Double balance ) {
        this.name = new SimpleStringProperty(name);
        this.CPF = new SimpleStringProperty(CPF);
        this.hierarchy = new SimpleIntegerProperty(hierarchy);
        this.password = new SimpleStringProperty(password);
        
        BankAccount account = new BankAccount(accountNumber, balance);
        this.accounts = new SimpleListProperty<>();
        accounts.add(account);
    }
    
    public BankUser(String name, String CPF, int hierarchy, String password) {
        this.name = new SimpleStringProperty(name);
        this.CPF = new SimpleStringProperty(CPF);
        this.hierarchy = new SimpleIntegerProperty(hierarchy);
        this.password = new SimpleStringProperty(password);
        this.accounts = new SimpleListProperty<>();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCPF() {
        return CPF.get();
    }

    public void setCPF(String CPF) {
        this.CPF.set(CPF);
    }

    public int getHierarchy() {
        return hierarchy.get();
    }
    
    public String getHierarchyToString() {
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

    public void setHierarchy(int hierarchy) {
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
    
    public void addAccount(String agency, String accountNumber, AccountTypeEnum type, int initialValue) {
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
    
    public boolean deposit(String accountNumber, int value){
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
    
    private String getAccountListToString() {
        List<BankAccount> list = this.getAccountList();
        String string = "";
        for(BankAccount account : list){
            string = "CONTA: " + account.getAccountNumber() + '\n';
            switch(account.getType()) {
                case CORRENTE:
                    string += "TIPO: Corrente \n";
                    break;
                    
                case POUPANCA:
                    string += "TIPO: Poupança \n";
                    break;
                    
                case DI:
                    string += "TIPO: DI \n";
                    break;
                    
                case TESOURO:
                    string += "TIPO: Tesouro \n";
                    break;
            }
        }
        
        return string;
    }
    
    @Override
    public String toString() {
        String string = this.getName() + '\n' + this.getCPF() + '\n' 
                + this.getPassword() +'\n' + this.getHierarchyToString() + '\n' +
                this.getAccountListToString();
        
        return string;
    }

    
}
