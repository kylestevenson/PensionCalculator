/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public abstract class ChangeView {
    public static Scene scene;
    public static final HashMap<String, ChangeView> controllers = new HashMap<>();
    
    private Parent root;  
    
    public static ChangeView add(String name) {
        ChangeView controller; 
        
        controller = controllers.get(name); 
        
        if(controller == null){
            try {
                
                FXMLLoader loader = new FXMLLoader(ChangeView.class.getResource(name + ".fxml"));
                 
                Parent root = loader.load();
                
                controller = loader.getController(); 
                
                controller.setRoot(root); 
                
                controllers.put(name, controller); 
                
            } catch (IOException ex) {
                Logger.getLogger(ChangeView.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            } catch (Exception ex){
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            }
        }
        return controller; 
    }
    
    public static void changeTo(String name) {
        ChangeView controller = controllers.get(name); 
        
        if(controller == null){
            controller = add(name); 
        }
        
        if(controller != null){
            if(scene != null){
                scene.setRoot(controller.getRoot());
            }
        }
    }
    
    public void setRoot(Parent root) {
        this.root = root;
    }
    
    public Parent getRoot() {
        return root;
    }
    
    public static ChangeView getControllerByName(String name) {
        return controllers.get(name);
    }
}
