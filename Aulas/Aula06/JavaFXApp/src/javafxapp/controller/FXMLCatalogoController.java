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
import javafx.scene.control.cell.PropertyValueFactory;
import javafxapp.model.Contato;

/**
 *
 * @author 11.02741-0
 */
public class FXMLCatalogoController implements Initializable {
    
    private ObservableList<Contato> contatos = FXCollections.observableArrayList();
        
    @FXML
    private Label labelNome, labelSobrenome, labelCidade, 
            labelEstado, labelCep, labelDataNasc;
    
    @FXML
    private TableView<Contato> tableContato = new TableView<>();
    
    @FXML
    private TableColumn<Contato, String> columnNome = new TableColumn<>("Nome");
    private TableColumn<Contato, String> columnSobrenome = new TableColumn<>("Sobrenome");
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableContato.setEditable(true);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
        tableContato.setItems(getItems());
        tableContato.getColumns().addAll(columnNome, columnSobrenome);
    }    
    
    public ObservableList<Contato> getItems() {
        contatos.add(new Contato("Henrique 1", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 2", "Rosa", "Rio Janeiro", "RJ", "08285140", "22/08/1991"));
        contatos.add(new Contato("Henrique 3", "Rosa", "Belo Horizont", "MG", "08285140", "22/08/1992"));
        contatos.add(new Contato("Henrique 4", "Rosa", "São Caetano do Sul", "SP", "08285140", "22/08/1993"));
        contatos.add(new Contato("Henrique 5", "Rosa", "Diadema", "SP", "08285140", "22/08/1994"));
        contatos.add(new Contato("Henrique 6", "Rosa", "Osasco", "SP", "08285140", "22/08/1994"));
        contatos.add(new Contato("Henrique 7", "Rosa", "Guarulhos", "SP", "08285140", "22/08/1995"));
        contatos.add(new Contato("Henrique 8", "Rosa", "São Paulo", "SP", "08285140", "22/08/1996"));
        contatos.add(new Contato("Henrique 9", "Rosa", "São Paulo", "SP", "08285140", "22/08/1997"));
        contatos.add(new Contato("Henrique 10", "Rosa", "São Paulo", "SP", "08285140", "22/08/1998"));
        return contatos;
    }
    
}
