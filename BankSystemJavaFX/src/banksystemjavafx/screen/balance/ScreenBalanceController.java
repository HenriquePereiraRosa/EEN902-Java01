/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.screen.balance;

import banksystemjavafx.BankSystemJavaFX;
import banksystemjavafx.screen.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ScreenBalanceController implements Initializable {

    
    ScreensController myScreenController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void toScreen1(ActionEvent event) {
        myScreenController.setScreen(BankSystemJavaFX.screen1ID);
    }
    
}
