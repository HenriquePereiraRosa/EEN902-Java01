/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model;

import banksystem.model.Enum.AccountTypeEnum;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 11.02741-0
 */
public class BankUser implements Serializable {
 
    private String name;
    private String CPF;
    private int hierarchy;
    private String password;
    private List<BankAccount> accounts;

    public BankUser() {
        this.name = null;
        this.CPF = null;
        this.password = null;
    }
    
    public BankUser(BankUser another) {
        this.name = another.getName();
        this.CPF = another.getCPF();
        this.password = another.getPassword();
        this.hierarchy = another.getHierarchy();
        this.accounts = another.getAccountList();
    }
    
    public BankUser(String name, String CPF, String password, List<BankAccount> accountList) {
        this.name = name;
        this.CPF = CPF;
        this.password = password;
        this.accounts = accountList;
    }
    
    public BankUser(String name, String CPF, int hierarchy, String password, BankAccount account) {
        this.name = name;
        this.CPF = CPF;
        this.hierarchy = hierarchy;
        this.password = password;
        this.accounts = new ArrayList<>();
        this.accounts.add(account);
    }
    
    public BankUser(String name, String CPF, int hierarchy, String password, String accountNumber, AccountTypeEnum type, int balance ) {
        this.name = name;
        this.CPF = CPF;
        this.hierarchy = hierarchy;
        this.password = password;
        
        BankAccount account = new BankAccount(accountNumber, type, balance);
        this.accounts = new ArrayList<>();
        accounts.add(account);
    }
    
    public BankUser(String name, String CPF, int hierarchy, String password) {
        this.name = name;
        this.CPF = CPF;
        this.hierarchy = hierarchy;
        this.password = password;
        this.accounts = new ArrayList<>();
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

    public int getHierarchy() {
        return hierarchy;
    }
    
    public String getHierarchyToString() {
        String string = "";
        switch(this.hierarchy) {
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
        this.hierarchy = hierarchy;
    }

    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BankAccount> getAccountList() {
        return accounts;
    }

    public void setAccountList(List<BankAccount> accountList) {
        this.accounts = accountList;
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
