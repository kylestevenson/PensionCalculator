/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Kyle
 */
public class Krs6y9PensionCalculator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // UI if error changing scene
        VBox root = new VBox();
        root.setPrefSize(1200, 800);
        root.setAlignment(Pos.CENTER);
        Text message = new Text("Error Loading Scene");
        root.getChildren().add(message);
        
        //app title
        stage.setTitle("Pension Calculator Tool");
       
        Scene scene = new Scene(root);
        ChangeView.scene = scene;
        //start on table view
        ChangeView.changeTo("Table");
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
