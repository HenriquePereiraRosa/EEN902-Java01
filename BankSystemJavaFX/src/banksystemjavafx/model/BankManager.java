/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.model;

import java.util.List;

/**
 *
 * @author user
 */
public class BankManager extends BankEmployee {
    
    public BankManager(String name, String CPF, String password, List<BankAccount> accountList) {
        super(name, CPF, password, accountList);
    }    
    
    public BankManager(String name, String CPF, String password, BankAccount account) {
        super(name, CPF, password, account);
    } 
    
    public BankManager(String name, String CPF, String password, String accountNumber, int type, int balance) {
        super(name, CPF, password, accountNumber, type, balance);
    }
            
    private void addClient(BankEmployee employee) {
        clientes.add(employee);
    }
    
    private void removeClient(BankEmployee employee) {
        clientes.remove(employee);
    }
    
    private void addClients(List<BankEmployee> employees) {
        for(BankEmployee employee : employees)
        clientes.add(employee);
    }
    
    private void removeClients(List<BankEmployee> employees) {
        for(BankEmployee employee: employees)
        clientes.remove(employee);
    }
    
    
}
