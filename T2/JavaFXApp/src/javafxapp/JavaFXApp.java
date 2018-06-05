/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author 11.02741-0
 */
public class JavaFXApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLCatalogo.fxml"));
        Scene scene = new Scene(root);
        
        stage.getIcons().add(new Image(getClass().getResource("/resources/img/bankSystemLogo.png").toExternalForm()));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
