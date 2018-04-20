/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author user
 */
public class BankSystemJavaFX extends Application {
        
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("screen/Login.fxml"));        
        Scene scene = new Scene(root);
        
        //stage.getIcons().add(new Image(getClass().getResource("/resources/savage.png").toExternalForm()));
        stage.setScene(scene);
        stage.setTitle("BankSystem");
        stage.show();
        
        stage.setOnCloseRequest((WindowEvent event) -> {
            try {
                stop();
//                stage.notify();
//                stage.close();
                Platform.exit();
                System.exit(0);
            } catch (Exception ex) {
                Logger.getLogger(BankSystemJavaFX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
    }
    
    
    @Override
    public void stop( ) throws Exception {
        // ToDo: fechar conexão serial
        System.out.println("App.stop(): called!");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        Application.launch(BankSystemJavaFX.class, (java.lang.String[])null);
    }
    
}
