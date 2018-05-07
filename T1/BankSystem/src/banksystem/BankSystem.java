/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import banksystem.model.BankAccount;
import banksystem.model.BankUser;
import banksystem.model.Enum.AccountTypeEnum;
import static banksystem.model.Enum.States.Home;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class BankSystem {
    
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        bank.launch();
    }
    
    private void launch() {
        
        int option = 0;
        int state = 0, previousState = 0;
        List<BankUser> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        BankUser user = new BankUser("Henrique", "admin", 2, "admin", new BankAccount("0001"));
        users.add(user);
            
        BankUser userLoged = new BankUser();
        BankUser userAux = new BankUser();
                
        while(true) {
        
            String name = "", CPF = "", password = "", accountNumber = "";
            int value = 0, accountTypeAux = 0,  hierarchy = 0;
            AccountTypeEnum accountTypeEnumAux = AccountTypeEnum.CORRENTE;
            
            switch (state) {
                case 0:
                    System.out.println("==========================================");
                    System.out.println("WELCOME TO THE JUNGLE BANK");
                    System.out.println("==========================================");
                    System.out.println("");
                    System.out.println("Atenção as opções abaixo:");
                    System.out.println("  1) Login");
                    System.out.println(" 99) Sair");
                    state = scanner.nextInt();
                    previousState = state;
                    break;
                
                case 1:
                    System.out.println("==========================================");
                    System.out.println("Digite o CPF:");
                    CPF = scanner.next();
                    System.out.println("Digite a senha:");
                    password = scanner.next();
                    userAux = validadeUser(CPF, password, users);
                    
                    if(userAux != null) {
                        userLoged = new BankUser(userAux);
                        switch (userAux.getHierarchy()) {
                            case 0: // Client
                                state = 2;
                                previousState = state;
                                break;
                                
                            case 1: // Employee
                                state = 3;
                                previousState = state;
                                break;
                                
                            case 2: // Management
                                state = 4;
                                previousState = state;
                                break;                     
                        }
                    } else {
                        System.out.println("Usuário desconhecido ou valores ");
                        System.out.println("de Usuário e Senha incorretos!");
                        System.out.println("");
                        state = 0;
                    }
                    break;
                
                case 2:
                    System.out.println("==========================================");
                    System.out.println("Bem Vindo Cliente " + userLoged.getName());
                    System.out.println("");
                    System.out.println("Atenção as opções abaixo:");
                    System.out.println("  5) Extrado e Saldo");
                    System.out.println("  6) Saldo");
                    System.out.println("  7) Depósito");
                    System.out.println("  8) Transferência");
                    System.out.println(" 89) Logout");
                    System.out.println(" 99) Fechar programa");
                    state = scanner.nextInt();
                    break;
                
                case 3:
                    System.out.println("==========================================");
                    System.out.println("Bem Vindo Funcionário " + userLoged.getName());
                    System.out.println("");
                    System.out.println("Atenção as opções abaixo:");
                    System.out.println("  5) Extrado e Saldo");
                    System.out.println("  6) Saldo");
                    System.out.println("  7) Depósito");
                    System.out.println("  8) Transferência");
                    System.out.println("  9) Criar, alterar ou remover um usuário");
                    System.out.println(" 10) Visualizar lista de clientes e funcionários");
                    System.out.println(" 11) Buscar um usuário pelo nome");
                    System.out.println(" 89) Logout");
                    System.out.println(" 99) Fechar programa");
                    state = scanner.nextInt();
                    break;
                
                case 4:
                    System.out.println("==========================================");
                    System.out.println("Bem Vindo Gerente " + userLoged.getName());
                    System.out.println("");
                    System.out.println("Atenção as opções abaixo:");
                    System.out.println("  5) Extrado e Saldo");
                    System.out.println("  6) Saldo");
                    System.out.println("  7) Depósito");
                    System.out.println("  8) Transferência");
                    System.out.println("  9) Criar, alterar ou remover um usuário");
                    System.out.println(" 10) Visualizar lista de clientes e funcionários");
                    System.out.println(" 11) Buscar um usuário pelo nome");
                    System.out.println(" 89) Logout");
                    System.out.println(" 99) Fechar programa");
                    state = scanner.nextInt();
                    break;
                
                case 5:
                    System.out.println("==========================================");
                    System.out.println("Extrato e Saldo da(s) conta(s): ");
                    System.out.println("");
                    getStatement(userLoged);
                    state = previousState;
                    break;
                
                case 6:
                    System.out.println("==========================================");
                    System.out.println("Saldo da(s) Conta(s)");
                    System.out.println("");
                    getBalance(userLoged);
                    state = previousState;
                    break;
                
                case 7:
                    System.out.println("==========================================");
                    System.out.println("Depósito");
                    System.out.println("");
                    System.out.println("Atenção as instruções!");
                    System.out.println("Digite o CPF Destinatário sem pontos:");
                    CPF = scanner.next().replace(" ", "");
                    System.out.println("Digite o Número da Conta:");
                    accountNumber = scanner.next().replace(" ", "");
                    System.out.println("Digite o valor:");
                    value = scanner.nextInt();
                    if(doTranfer(CPF, accountNumber, value, users)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else 
                        System.out.println("Falha ao realizar o depósito!");
                    state = previousState;
                    break;
                
                case 8:
                    System.out.println("==========================================");
                    System.out.println("Transferência entre Contas");
                    System.out.println("");
                    System.out.println("Atenção as instruções!");
                    System.out.println("Digite o CPF Destinatário sem pontos:");
                    CPF = scanner.next().replace(" ", "");
                    System.out.println("Digite o Número da Conta:");
                    accountNumber = scanner.next().replace(" ", "");
                    System.out.println("Digite o valor:");
                    value = scanner.nextInt();
                    if(doTranfer(CPF, accountNumber, value, users)) {
                        System.out.println("Tranferência realizada com sucesso!");
                    } else 
                        System.out.println("Falha ao realizar a Tranferência!");
                    state = previousState;
                    break;
                
                case 9:
                    System.out.println("==========================================");
                    System.out.println("Criar, Alterar ou Remover um cliente");
                    System.out.println("");
                    System.out.println("Digite o CPF");
                    CPF = scanner.next();
                    userAux.setCPF(CPF);
                    System.out.println("Atenção as opções abaixo:");
                    System.out.println("Digite:");
                    System.out.println("    12) Criar cadastro de usuário");
                    System.out.println("    13) Alterar cadastro de usuário");
                    System.out.println("    14) Remover cadastro de usuário");
                    state = scanner.nextInt();
                    break;
                
                case 10:
                    System.out.println("==========================================");
                    System.out.println("Visualizar lista de clientes e funcionários");
                    System.out.println("");
                    showClients(users);
                    System.out.println("-------------------------------------------");
                    state = previousState;
                    break;
                
                case 11:
                    System.out.println("==========================================");
                    System.out.println("Buscar um usuário pelo nome");
                    System.out.println("");
                    System.out.println("Digite o nome:");
                    name = scanner.next();
                    searchByName(name, users);
                    state = previousState;
                    break;
                
                case 12:
                    System.out.println("==========================================");
                    System.out.println("Criar cadastro de cliente");
                    System.out.println("");
                    System.out.println("Atenção as Instruções!");
                    System.out.println("Digite o nome:");
                    name = scanner.next();
                    System.out.println("Digite o CPF");
                    CPF = scanner.next();
                    System.out.println("Digite a Hierarquia");
                    hierarchy = scanner.nextInt();
                    System.out.println("Digite a senha");
                    password = scanner.next();
                    userAux = new BankUser(name, CPF, hierarchy, password);
                    users.add(userAux);
                    searchByName(userAux.getName(), users);
                    System.out.println("Usuário incluído com sucesso!");
                    state = previousState;
                    break;
                
                case 13:
                    System.out.println("==========================================");
                    System.out.println("Alterar cadastro de cliente");
                    System.out.println("");
                    System.out.println("Opções");
                    System.out.println("15) Adicionar Conta.");
                    System.out.println("16) Remover Conta.");
                    System.out.println("17) Alterar dados cadastrais.");
                    state = scanner.nextInt();
                    break;
                
                case 14:
                    System.out.println("==========================================");
                    System.out.println("Remover cadastro de cliente");
                    System.out.println("Digite o CPF");
                    CPF = scanner.next();
                    userAux = searchByCPF(CPF, users);
                    userAux.setCPF(CPF);
                    searchByName(userAux.getName(), users);
                    users = remove(CPF, users);
                    System.out.println("Usuário removido com sucesso!");
                    state = previousState;
                    break;
                
                case 15:
                    System.out.println("==========================================");
                    System.out.println("Adicionar conta");
                    System.out.println("");
                    System.out.println("Atenção as Instruções!");
                    System.out.println("Digite o número da conta:");
                    accountNumber = scanner.next();
                    System.out.println("Digite o tipo da conta:");
                    accountTypeAux = scanner.nextInt();
                    
                    switch(accountTypeAux) {
                        case 0:
                            accountTypeEnumAux = AccountTypeEnum.CORRENTE;
                            break;

                        case 1:
                            accountTypeEnumAux = AccountTypeEnum.POUPANCA;
                            break;

                        case 2:
                            accountTypeEnumAux = AccountTypeEnum.DI;
                            break;

                        case 3:
                            accountTypeEnumAux = AccountTypeEnum.TESOURO;
                            break;
                    }
                    
                    BankAccount account = new BankAccount(accountNumber, accountTypeEnumAux);
                    
                    userAux.addAccount(account);
                    
                    System.out.println("-----------------------------------------");
                    System.out.println(userAux.toString());
                    System.out.println("-----------------------------------------");
                    System.out.println("Usuário alterado com sucesso!");
                    state = previousState;
                    break;
                
                case 16:
                    System.out.println("==========================================");
                    System.out.println("Remover conta");
                    System.out.println("");
                    System.out.println("Digite o número da conta:");
                    accountNumber = scanner.next();
                    if(user.removeAccount(accountNumber)) {
                        System.out.println("-----------------------------------------");
                        System.out.println(userAux.toString());
                        System.out.println("-----------------------------------------");
                        System.out.println("Usuário alterado com sucesso!");
                    } else {
                        System.out.println("Falha: 1Tente novamente");
                    }
                    state = previousState;
                    break;
                
                case 17:
                    System.out.println("==========================================");
                    System.out.println("Alterar cadastro de cliente");
                    System.out.println("");
                    System.out.println("Atenção as Instruções!");
                    System.out.println("Digite o nome:");
                    name = scanner.next();
                    searchByName(name, users);
                    System.out.println("Digite o CPF");
                    CPF = scanner.next();
                    System.out.println("Digite a Hierarquia");
                    hierarchy = scanner.nextInt();
                    System.out.println("Digite a senha");
                    password = scanner.next();
                    userAux = searchByCPF(CPF, users);
                    userAux.setCPF(CPF);
                    userAux.setHierarchy(hierarchy);
                    userAux.setName(name);
                    userAux.setPassword(password);
                    
                    System.out.println("-----------------------------------------");
                    System.out.println(userAux.toString());
                    System.out.println("-----------------------------------------");
                    System.out.println("Usuário alterado com sucesso!");
                    state = previousState;
                    break;
                
                case 89:
                    CPF = null;
                    password = null;
                    userAux = null;
                    userLoged = null;
                    state = 0;
                    previousState = 0;
                    break;
                
                case 99:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        }
    }
    
    private BankUser validadeUser(String CPF, String password, List<BankUser> users) {
        
        BankUser userToReturn = null;
        
        CPF = CPF.replace(" ", ""); 
        CPF = CPF.replace(".", "");
        for (BankUser user : users) {
            if (CPF.equals(user.getCPF()) && password.equals(user.getPassword())) {
                userToReturn = user;
            }
        }
        return userToReturn;
    }

    private void getStatement(BankUser userLoged) {
         
        if(userLoged.getAccountList().isEmpty()) {
            System.out.println("Nenhuma conta Registrada");
        } else {
            for( BankAccount account : userLoged.getAccountList()){
                String accountType = "";
                switch(account.getType()){
                    case CORRENTE:
                        accountType = "Corrente";
                        break;
                    case POUPANCA:
                        accountType = "Poupanca";
                        break;
                    case DI:
                        accountType = "DI";
                        break;
                    case TESOURO:
                        accountType = "Tesouro";
                        break;  
                }
                System.out.println("Extrato -  Conta " + accountType + " Número: " + account.getAccountNumber());
                for(Integer value :account.getExtract())
                    System.out.println("- $" + value);
                System.out.println("-------------------");
                System.out.println("SALDO = $" + account.getBalance());
            }
        }
    }

    private void getBalance(BankUser userLoged) {
         if(userLoged.getAccountList().isEmpty()) {
            System.out.println("Nenhuma conta Registrada");
        } else {
            for( BankAccount account : userLoged.getAccountList()){
                String accountType = "";
                switch(account.getType()){
                    case CORRENTE:
                        accountType = "Corrente";
                        break;
                    case POUPANCA:
                        accountType = "Poupanca";
                        break;
                    case DI:
                        accountType = "DI";
                        break;
                    case TESOURO:
                        accountType = "Tesouro";
                        break;  
                }
                System.out.println("Saldo -  Conta " + accountType + " Número: " + account.getAccountNumber());
                System.out.println("$" + account.getBalance());
                System.out.println("-------------------");
            }
        }
    }

    private boolean doTranfer(String CPF, String accountNumber, int value, List<BankUser> users) {
        BankUser user = searchByCPF(CPF, users);
        
        if(user != null){
            user.deposit(accountNumber, value);
            return true;
        }
        return false;
    }

    private BankUser searchByCPF(String CPF, List<BankUser> users) {
        CPF = CPF.replace(" ", ""); 
        CPF = CPF.replace(".", "");
        for (BankUser user : users) {
            if (CPF.equals(user.getCPF()))
                return user;
        }
        return null;
    }

    private void showClients(List<BankUser> users) {
        System.out.println("CLIENTE             CPF        CONTA        TIPO");
        
        for(BankUser user : users){
            for(BankAccount account : user.getAccountList()){
                System.out.println(String.format("%s", user.getName()) +
                                    String.format("%1$20s", user.getCPF()) + 
                                    String.format("%1$8s", account.getAccountNumber()) + 
                                    String.format("%1$15s", account.getType().toString()));
            }
        }
    }

    private BankUser searchByName(String name, List<BankUser> users) {
        for (BankUser user : users) {
            if(user.getName().contains(name)) {
                System.out.println("CLIENTE        CPF        CONTA        TIPO");
                for(BankAccount account : user.getAccountList()) {
                    System.out.println(String.format("%s", user.getName()) +
                                        String.format("%1$15s", user.getCPF()) + 
                                        String.format("%1$15s", account.getType().toString()));
                }
                return user;
            }
        }
        return null;
    }

    private List<BankUser> remove(String CPF, List<BankUser> users) {
        BankUser user  = searchByCPF(CPF, users);
        users.remove(user);
        return users;
    }
    
} //End Class
