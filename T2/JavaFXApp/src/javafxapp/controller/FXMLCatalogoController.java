/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafxapp.model.BankUser;

/**
 *
 * @author 11.02741-0
 */
public class FXMLCatalogoController implements Initializable {
    
    private ObservableList<BankUser> clientes = FXCollections.observableArrayList();
        
    @FXML
    private Label labelNome, labelSobrenome, labelCidade, 
            labelEstado, labelCep, labelDataNasc;
    
    @FXML
    private TableView<BankUser> tableBankUser;
    
    @FXML
    private TableColumn<BankUser, String> columnNome;
    
    @FXML
    private TableColumn<BankUser, String> columnCPF;
    
    @FXML
    private TableColumn<BankUser, String> columnAccountNumber;
    
    @FXML
    private TableColumn<BankUser, String> columnHierarchy;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        columnCPF.setCellValueFactory(cellData -> cellData.getValue().sobrenomeProperty());
        tableBankUser.setItems(getItems());
        tableBankUser.setEditable(true);
    }    
    
    public ObservableList<BankUser> getItems() {
        clientes.add(new BankUser("Henrique 1", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        clientes.add(new BankUser("Henrique 2", "Rosa", "Rio Janeiro", "RJ", "08285140", "22/08/1991"));
        clientes.add(new BankUser("Henrique 3", "Rosa", "Belo Horizont", "MG", "08285140", "22/08/1992"));
        clientes.add(new BankUser("Henrique 4", "Rosa", "São Caetano do Sul", "SP", "08285140", "22/08/1993"));
        clientes.add(new BankUser("Henrique 5", "Rosa", "Diadema", "SP", "08285140", "22/08/1994"));
        clientes.add(new BankUser("Henrique 6", "Rosa", "Osasco", "SP", "08285140", "22/08/1994"));
        clientes.add(new BankUser("Henrique 7", "Rosa", "Guarulhos", "SP", "08285140", "22/08/1995"));
        clientes.add(new BankUser("Henrique 8", "Rosa", "São Paulo", "SP", "08285140", "22/08/1996"));
        clientes.add(new BankUser("Henrique 9", "Rosa", "São Paulo", "SP", "08285140", "22/08/1997"));
        clientes.add(new BankUser("Henrique 10", "Rosa", "São Paulo", "SP", "08285140", "22/08/1998"));
        
        clientes.sort(cmprtr);
        
        return clientes;
    }
    
}
