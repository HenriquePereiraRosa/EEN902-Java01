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
import javafxapp.model.Contato;

/**
 *
 * @author 11.02741-0
 */
public class FXMLCatalogoController implements Initializable {
    
    private ObservableList<Contato> clientes = FXCollections.observableArrayList();
        
    @FXML
    private Label labelNome, labelSobrenome, labelCidade, 
            labelEstado, labelCep, labelDataNasc;
    
    @FXML
    private TableView<Contato> tableContato;
    
    @FXML
    private TableColumn<Contato, String> columnNome;
    
    @FXML
    private TableColumn<Contato, String> columnCPF;
    
    @FXML
    private TableColumn<Contato, String> columnAccountNumber;
    
    @FXML
    private TableColumn<Contato, String> columnHierarchy;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        columnSobrenome.setCellValueFactory(cellData -> cellData.getValue().sobrenomeProperty());
        tableContato.setItems(getItems());
        tableContato.setEditable(true);
    }    
    
    public ObservableList<Contato> getItems() {
        clientes.add(new Contato("Henrique 1", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        clientes.add(new Contato("Henrique 2", "Rosa", "Rio Janeiro", "RJ", "08285140", "22/08/1991"));
        clientes.add(new Contato("Henrique 3", "Rosa", "Belo Horizont", "MG", "08285140", "22/08/1992"));
        clientes.add(new Contato("Henrique 4", "Rosa", "São Caetano do Sul", "SP", "08285140", "22/08/1993"));
        clientes.add(new Contato("Henrique 5", "Rosa", "Diadema", "SP", "08285140", "22/08/1994"));
        clientes.add(new Contato("Henrique 6", "Rosa", "Osasco", "SP", "08285140", "22/08/1994"));
        clientes.add(new Contato("Henrique 7", "Rosa", "Guarulhos", "SP", "08285140", "22/08/1995"));
        clientes.add(new Contato("Henrique 8", "Rosa", "São Paulo", "SP", "08285140", "22/08/1996"));
        clientes.add(new Contato("Henrique 9", "Rosa", "São Paulo", "SP", "08285140", "22/08/1997"));
        clientes.add(new Contato("Henrique 10", "Rosa", "São Paulo", "SP", "08285140", "22/08/1998"));
        
        clientes.sort(cmprtr);
        
        return clientes;
    }
    
}
