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
import javafxapp.model.BankAccount.BankAccount;
import javafxapp.model.BankUser.BankUser;

/**
 *
 * @author 11.02741-0
 */
public class FXMLCatalogoController implements Initializable {
    
    private final ObservableList<BankUser> clients = FXCollections.observableArrayList();
        
    @FXML
    private Label labelNome;

    @FXML
    private Label labelSobrenome;

    @FXML
    private Label labelCidade;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelCep;

    @FXML
    private Label labelDataNasc;
    @FXML
    private TableView<BankUser> tableBankUser;
    
    @FXML
    private TableColumn<BankUser, String> columnName;
    
    @FXML
    private TableColumn<BankUser, String> columnCpf;
    
    @FXML
    private TableColumn<BankUser, String> columnAccountNumber;
    
    @FXML
    private TableColumn<BankUser, String> columnHierarchy;
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnCpf.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
        columnAccountNumber.setCellValueFactory(cellData -> cellData.getValue().accountNumberProperty());
        columnHierarchy.setCellValueFactory(cellData -> cellData.getValue().hierarchyProperty().asString());
        tableBankUser.setItems(getItems());
        tableBankUser.setEditable(true);
        
        labelNome.setText(tableBankUser.getColumns().get(0).getCellData(0).toString());
        labelSobrenome.setText(tableBankUser.getColumns().get(1).getCellData(0).toString());
        labelCidade.setText(tableBankUser.getColumns().get(2).getCellData(0).toString());
        labelEstado.setText(tableBankUser.getColumns().get(3).getCellData(0).toString());
    }    
    
    public ObservableList<BankUser> getItems() {
        clients.add(new BankUser("Henrique 1", "123.456.789-01", 0, "password", new BankAccount("0001", 0, 0.0)));
        clients.add(new BankUser("Henrique 2", "123.456.789-02", 1, "password", "0002", 0, 1800.0));
        clients.add(new BankUser("Henrique 3", "123.456.789-03", 2, "password", "0003", 0, 10000.0));
        clients.add(new BankUser("Henrique 4", "123.456.789-04", 0, "password", "0004", 0, 1000.0));
        clients.add(new BankUser("Henrique 5", "123.456.789-05", 1, "password", "0005", 0, 100.0));
        clients.add(new BankUser("Henrique 6", "123.456.789-06", 2, "password", "0006", 0, 500000.0));
        clients.add(new BankUser("Henrique 7", "123.456.789-08", 0, "password", "0007", 0, 800.0));
        clients.add(new BankUser("Henrique 8", "123.456.789-08", 1, "password", "0008", 0, 8000.0));
        clients.add(new BankUser("Henrique 9", "123.456.789-09", 2, "password", "0009", 0, 900.0));
        clients.add(new BankUser("Henrique 10", "123.456.789-10", 0, "password", "0010", 0, 600.0));
        clients.add(new BankUser("Henrique 11", "123.456.789-11", 1, "password", "0011", 0, 2367.0));
        clients.add(new BankUser("Henrique 12", "123.456.789-12", 1, "password", "0012", 2, 2367.0));
        
//        clients.sort();
        
        return clients;
    }
    
}
