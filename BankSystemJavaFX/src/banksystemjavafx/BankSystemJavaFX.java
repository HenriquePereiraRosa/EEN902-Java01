/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx;

import banksystemjavafx.screen.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class BankSystemJavaFX extends Application {
        
    public static String screen1ID = "main";
    public static String screen1File = "/resources/screen/login/Screen1.fxml";
    public static String screen2ID = "balance";
    public static String screen2File = "/resources/screen/balance/Screen2.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(BankSystemJavaFX.screen1ID, BankSystemJavaFX.screen1File);
        mainContainer.loadScreen(BankSystemJavaFX.screen2ID, BankSystemJavaFX.screen2File);
        
        mainContainer.setScreen(screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(getClass().getResource("/resources/img/logo.png").toExternalForm()));
        stage.setTitle("BankSystem");
        stage.setScene(scene);
        stage.show();  
        
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
        launch(args);
//        Application.launch(BankSystemJavaFX.class, (java.lang.String[])null);
    }
    
}
