/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 11.02741-0
 */
public class BankClient implements Serializable {
 
    private String name;
    private String CPF;
    private String password;
    private List<BankAccount> accountList;

    public BankClient(String name, String CPF, String password, List<BankAccount> accountList) {
        this.name = name;
        this.CPF = CPF;
        this.password = password;
        this.accountList = accountList;
    }
    
    public BankClient(String name, String CPF, String password, BankAccount account) {
        this.name = name;
        this.CPF = CPF;
        this.password = password;
        
        this.accountList = new ArrayList<>();
        this.accountList.add(account);
    }
    
    public BankClient(String name, String CPF, String password, String accountNumber, String type, int balance ) {
        this.name = name;
        this.CPF = CPF;
        this.password = password;
        
        BankAccount account = new BankAccount(accountNumber, type, balance);
        this.accountList = new ArrayList<>();
        accountList.add(account);
    }
    
    public BankClient(String name, String CPF, String password) {
        this.name = name;
        this.CPF = CPF;
        this.password = password;
        this.accountList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<BankAccount> accountList) {
        this.accountList = accountList;
    }
    
    public void addAccount(String agency, String accountNumber, String type, int initialValue) {
        BankAccount account = new BankAccount(accountNumber, type, initialValue);
        accountList.add(account);
    }
    
    public boolean removeAccount(BankAccount account) {
        
        if(accountList.contains(account)){
            accountList.remove(account);
            return true;
        } 
        return false;
    }
    
}
