/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class AboutController extends ChangeView implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    //Changes back to Table
    @FXML
    private void changeToTable(ActionEvent e){
        ChangeView.changeTo("Table");
    }
    
}
