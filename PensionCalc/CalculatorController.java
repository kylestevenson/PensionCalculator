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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Kyle
 */
public class CalculatorController extends ChangeView implements Initializable, Data {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    Text idText;
    @FXML
    Text nameText;
    @FXML
    Text ageText;
    @FXML
    Text salaryText;
    @FXML
    Text accBalText;
    @FXML
    TextField retireAge;
    @FXML
    Text totalText;
    @FXML
    Text inputError;
    
    CalculationModel calculationModel = new CalculationModel();
    private Double lumpSum;
    
    @FXML
    private void calculateBenefit(ActionEvent e){
        //chcek input is valid
        if(checkInputs()!= true){
            this.inputError.setText("Invalid Input");
            return;
        }
        inputError.setText("");
        
        //get values from Text
        Integer age = Integer.parseInt(this.ageText.getText());
        Integer rAge = Integer.parseInt(this.retireAge.getText());
        Double salary = Double.parseDouble(this.salaryText.getText());
        Double accBalance = Double.parseDouble(this.accBalText.getText());
        
        lumpSum = calculationModel.benefitCalculation(age,rAge,salary,accBalance);
        
        this.totalText.setText("$"+Double.toString(lumpSum));
    }
    @Override
    public boolean checkInputs(){
        try{
            Integer.parseInt(this.retireAge.getText());
            return true;
        }
        catch (NumberFormatException ex){
            //System.out.println("Error: "+ex);
        }
        return false;
    }
    @Override
    public void clearFields(){
        retireAge.setText("");
        totalText.setText("");
    }
    
    @FXML
    private void changeToTable(ActionEvent e){
        clearFields();
        ChangeView.changeTo("Table");
    }
    @FXML
    private void changeToAbout(ActionEvent e){
        clearFields();
        ChangeView.changeTo("About");
    }
    
}
