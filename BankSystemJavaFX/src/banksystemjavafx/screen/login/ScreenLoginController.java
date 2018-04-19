/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.screen.login;

import banksystemjavafx.BankSystemJavaFX;
import banksystemjavafx.screen.ControlledScreen;
import banksystemjavafx.screen.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ScreenLoginController implements Initializable, ControlledScreen {

    ScreensController myScreenController;
    
    @FXML
    private Button btnLogin;
    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreenController = screenPage;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void chancheBackgroungColor(ActionEvent event) {
        btnLogin.setBackground(Background.EMPTY);
    }
    
    @FXML
    private void toScreen2(ActionEvent event) {
        myScreenController.setScreen(BankSystemJavaFX.screen2ID);
    }

    
}
