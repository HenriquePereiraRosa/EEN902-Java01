/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemjavafx.screen;

/**
 *
 * @author user
 */
public interface ControlledScreen {
    
    // Allow the injection of the Parent ScreenPane
    public void setScreenParent(ScreensController screenPage);    
}
