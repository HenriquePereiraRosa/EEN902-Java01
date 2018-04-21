/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.screen;

import banksystemjavafx.BankSystemJavaFX;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        if("teste".equals(txtSc1CPF.getText())) return true;
        return false;
    }

    private boolean validatePassword() {
        if("teste".equals(txtSc1Password.getText())) return true;
        return false;
    }
    
}
