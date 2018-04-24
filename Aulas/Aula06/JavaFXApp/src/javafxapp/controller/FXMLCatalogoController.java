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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafxapp.model.Contato;

/**
 *
 * @author 11.02741-0
 */
public class FXMLCatalogoController implements Initializable {
    
    
    private ObservableList<Contato> contatos = FXCollections.observableArrayList();
    
    @FXML
    private Label label, labelNome, labelSobrenome, labelCidade, 
            labelEstado, labelCep, labelDataNasc;
    
    @FXML
    private TableView<Contato> tabaleContato;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populaTabela();
    }    
    
    public void populaTabela() {
        contatos.add(new Contato("Henrique 1", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 2", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 3", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 4", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 5", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 6", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 7", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 8", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 9", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        contatos.add(new Contato("Henrique 10", "Rosa", "São Paulo", "SP", "08285140", "22/08/1990"));
        tabaleContato.setItems(contatos);
    }
    
}
