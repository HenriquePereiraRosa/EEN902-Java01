/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author 11.02741-0
 */
public class BankEmployee extends BankClient {
    
    List<BankClient> clientes;
    
    public BankEmployee(String name, String CPF, String password, List<BankAccount> accountList) {
        super(name, CPF, password, accountList);
    }
    
    public BankEmployee(String name, String CPF, String password, BankAccount account) {
        super(name, CPF, password, account);
    }
    
    public BankEmployee(String name, String CPF, String password, String accountNumber, String type, int balance) {
        super(name, CPF, password, accountNumber, type, balance);
    }
    
    public BankEmployee(String name, String CPF, String password, List<BankAccount> accountList, List<BankClient> clientes) {
        super(name, CPF, password, accountList);
        this.clientes = clientes;
    }
    
    public BankEmployee(String name, String CPF, String password, List<BankAccount> accountList, BankClient cliente) {
        super(name, CPF, password, accountList);
        this.clientes = new ArrayList<BankClient>((Collection<? extends BankClient>) cliente);
    }
    
    
    private void addClient(BankClient cliente) {
        clientes.add(cliente);
    }
    
    private void removeClient(BankClient cliente) {
        clientes.remove(cliente);
    }
    
}
