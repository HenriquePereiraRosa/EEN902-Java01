/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.screen;

import banksystemjavafx.model.BankManager;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author user
 */
public class ScreensController extends StackPane {
    
    private HashMap<String, Node> screens = new HashMap<>(); 
    
    BankManager manager;

    public ScreensController() {
        super();
    }

    // Add the screen to the Collection
    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }
    
    // Returns de Node with the apropriate name
    public Node getScreen(String name) {
        return screens.get(name);
    }
    
    /* Loads the FXML file, add the screen to the screens Hashmap
       and injects the screenPane to the Controller  */
    public boolean loadScreen(String name, String resource) {
        try {
            System.out.println(resource);
            System.out.println(getClass().getResource(resource));
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent root = (Parent)loader.load();
            ControlledScreen myScreenController = (ControlledScreen)loader.getController();
            
            myScreenController.setScreenParent(this);
            addScreen(name, root);
            return true;
        } catch(Exception ex) {
            Logger.getLogger(ScreensController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /* Tries to display the screen with  a predefined name.
        1) Make sure that the screen has been already loaded.
        2) If there is more than  one screen  he new screen will be added after, 
           and then the current screen will be removed.
       If there isn't  any screen  being displayed, the new screen is just added 
       to the root.        
    */
    public boolean setScreen(final String name) {
        if(screens.get(name) != null) {         //Screen loaded
            final DoubleProperty opacity = opacityProperty();
            
            if(!getChildren().isEmpty()) {      // id there is more than one screen
                Timeline fadeOut = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(400), new EventHandler<ActionEvent>() {
                        
                        @Override
                        public void handle(ActionEvent ae){ 
                            getChildren().remove(0);                    // Remove the displayed screen
                            getChildren().add(0, screens.get(name));    // Add a new one
                            Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.1)),
                                new KeyFrame(new Duration(400), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        }
                    }, new KeyValue(opacity, 0.1)));
                fadeOut.play();
            } else { // No one else has been displayed, then just show
                setOpacity(0.1);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.1)),
                    new KeyFrame(new Duration(400), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("The Screen hasn't been loaded!");
            return false;
        }
    }
    
    
    // Remove screen from the collection
    public boolean unloadScreen(String name) {
        if(screens.remove(name) == null) return false;
        return true;            
        }
    }
    