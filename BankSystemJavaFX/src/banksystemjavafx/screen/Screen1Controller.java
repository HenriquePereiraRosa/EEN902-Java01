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
import banksystemjavafx.model.RememberMe;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Screen1Controller implements Initializable, ControlledScreen {

    ScreensController myScreenController;
    BankClient client;
    BankEmployee employee;
    BankManager manager;
    Set<BankClient> clients;
    Set<BankEmployee> employees;
    Set<BankManager> managers;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private CheckBox ckbRememberMe;
    
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
        String name, CPF, pasword;
        
        manager = new BankManager("Henrique Rosa", "37214999803", "pass", "0001", 0, 1000);
        clients = new HashSet<>();
        
        //loadRememberMe();
    }    
    
    
    
    @FXML
    private void toScreen2(ActionEvent event) {
        if((validadeCPF() == true) && (validatePassword() == true) ){
            lblUnknownCPF.setVisible(false);
            lblUnknownPassword.setVisible(false);
            myScreenController.setScreen(BankSystemJavaFX.screen2ID);
            
        } else {
            lblUnknownCPF.setVisible(true);
            lblUnknownPassword.setVisible(true);
        }        
    }
    
    @FXML
    private void rememberMe(ActionEvent event) {
        
        if(txtSc1CPF.getText().isEmpty() && txtSc1Password.getText().isEmpty()) {
            lblUnknownCPF.setVisible(true);
            lblUnknownPassword.setVisible(true);
        } else { 
            lblUnknownCPF.setVisible(false);
            lblUnknownPassword.setVisible(false);
            saveRememberMe();            
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

    private void loadRememberMe() {
        
        try{
            URL url = getClass().getResource(BankSystemJavaFX.rememberMeFile);
            System.out.println("BankSystemJavaFX.rememberMeFile: " + BankSystemJavaFX.rememberMeFile);
            System.out.println("URL: " + url);
            File file = new File(url.getPath());
            ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)));

            RememberMe remember = (RememberMe)ois.readObject();

            txtSc1CPF.setText(remember.getUser());
            txtSc1Password.setText(remember.getPassword());
            ois.close();
                
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveRememberMe() {
        
        try{
            URL url = getClass().getResource(BankSystemJavaFX.rememberMeFile);
            File file = new File(BankSystemJavaFX.rememberMeFile);
            ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)));
            
            RememberMe remember = new RememberMe(txtSc1CPF.getText(), txtSc1Password.getText());
            oos.writeObject(remember);
            oos.close();
                
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
