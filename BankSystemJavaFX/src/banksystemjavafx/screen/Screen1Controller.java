/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.screen;

import banksystemjavafx.BankSystemJavaFX;
import banksystemjavafx.model.BankManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Screen1Controller implements Initializable, ControlledScreen {

    ScreensController myScreenController;
    BankSystemJavaFX bank = new BankSystemJavaFX();
    BankManager manager;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private TextField txtSc1CPF;
    
    @FXML
    private PasswordField txtSc1Password;
    
    @FXML
    private Label lblUnknownCPF, lblUnknownPassword;
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreenController = screenPage;
    }

    
    public BankManager getManager() {
        return manager;
    }

    public void setManager(BankManager manager) {
        this.manager = manager;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    public TextField getTxtSc1CPF() {
        return txtSc1CPF;
    }

    public void setTxtSc1CPF(TextField txtSc1CPF) {
        this.txtSc1CPF = txtSc1CPF;
    }

    public PasswordField getTxtSc1Password() {
        return txtSc1Password;
    }

    public void setTxtSc1Password(PasswordField txtSc1Password) {
        this.txtSc1Password = txtSc1Password;
    }

    public Label getLblUnknownCPF() {
        return lblUnknownCPF;
    }

    public void setLblUnknownCPF(Label lblUnknownCPF) {
        this.lblUnknownCPF = lblUnknownCPF;
    }

    public Label getLblUnknownPassword() {
        return lblUnknownPassword;
    }

    public void setLblUnknownPassword(Label lblUnknownPassword) {
        this.lblUnknownPassword = lblUnknownPassword;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = new BankManager("Henrique Rosa", "37214999803", "pass", "0001", "01", 1000);
    }    
    
    
    @FXML
    private void toScreen2(MouseEvent event) {
        if((validadeCPF() == true) && (validatePassword() == true) ){
            lblUnknownCPF.setVisible(false);
            lblUnknownPassword.setVisible(false);
            myScreenController.setScreen(BankSystemJavaFX.screen2ID);
            
        } else {
            lblUnknownCPF.setVisible(true);
            lblUnknownPassword.setVisible(true);
        }
        
    }

    private boolean validadeCPF() {
        
        if(manager.getCPF().equals(txtSc1CPF.getText())) return true;
        return false;
    }

    private boolean validatePassword() {
        if(manager.getPassword().equals(txtSc1Password.getText())) return true;
        return false;
    }
    
}
