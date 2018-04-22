/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.screen;

import banksystemjavafx.BankSystemJavaFX;
import banksystemjavafx.model.BankClient;
import banksystemjavafx.model.BankEmployee;
import banksystemjavafx.model.BankManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Screen2Controller implements Initializable, ControlledScreen {

    
    ScreensController myScreenController;BankClient client;
    BankEmployee employee;
    BankManager manager;
    Set<BankClient> clients;
    Set<BankEmployee> employees;
    Set<BankManager> managers;
    
    @FXML
    private Button btnConfirm, btnAdd, btnSave, btnDelete;
    
    @FXML
    private TextField txtDetailsName, txtDetailsCPF;
    
    @FXML
    private PasswordField txtDetailsPassowrd;
    
    @FXML
    private Label lblSc2Saldo;
    
    @FXML
    private ComboBox cbDetailsUserType, cbDetailsAccountType;
    
    @FXML
    private TableView tbvAccountsTable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreenController = screenPage;
    }
    
    @FXML
    private void toScreen1(MouseEvent event) {
        myScreenController.setScreen(BankSystemJavaFX.screen1ID);
    }
    
}
