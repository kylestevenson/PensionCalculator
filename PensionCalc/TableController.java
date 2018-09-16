/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 *
 * @author Kyle
 */
public class TableController extends ChangeView implements Initializable, Data {
     
    @FXML
    private Text inputError;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField age;
    @FXML
    private TextField salary;
    @FXML
    private TextField accBalance;
    @FXML
    private TableView<ParticipantData> planTable;
    @FXML
    private TableColumn<ParticipantData, Integer> tableID;
    @FXML
    private TableColumn<ParticipantData, String> tableLastName;
    @FXML
    private TableColumn<ParticipantData, String> tableFirstName;
    @FXML
    private TableColumn<ParticipantData, Integer> tableAge;
    @FXML
    private TableColumn<ParticipantData, Double> tableSalary;
    @FXML
    private TableColumn<ParticipantData, Double> tableBalance;
    @FXML
    private Text selectError;
    
    private ConnectDB db;
    private ObservableList<ParticipantData> data;
    TableModel tableModel = new TableModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.db = new ConnectDB();
        
    }
    //changeView functionality to About
    @FXML
    private void changeToAbout(ActionEvent e){
        ChangeView.changeTo("About");
    }
    
    //Drop full table
    @FXML
    private void deleteTable(ActionEvent e){
        tableModel.destroyTable();
        //reload table after drop
        loadTableData();
    }
    
    //load table from Database on click
    @FXML
    private void loadTableData(ActionEvent e){
        //create table if it doesn't exist
        tableModel.createTable();
        //establish connection and get all data from table
        try{
            Connection connection = ConnectDB.getConnection();
            this.data = FXCollections.observableArrayList();
            Statement mystmt;
            mystmt = connection.createStatement();
            ResultSet rs = mystmt.executeQuery("SELECT * FROM participants;");
            while (rs.next()){
               this.data.add(new ParticipantData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6)));
           }
            mystmt.close();
            connection.close(); 
        }
        catch (SQLException ex){
            System.out.println("Error"+ ex);
        }
        //set up table rows
        this.tableID.setCellValueFactory(new PropertyValueFactory<ParticipantData, Integer>("ID"));
        this.tableLastName.setCellValueFactory(new PropertyValueFactory<ParticipantData, String>("lastName"));
        this.tableFirstName.setCellValueFactory(new PropertyValueFactory<ParticipantData, String>("firstName"));
        this.tableAge.setCellValueFactory(new PropertyValueFactory<ParticipantData, Integer>("age"));
        this.tableSalary.setCellValueFactory(new PropertyValueFactory<ParticipantData, Double>("salary"));
        this.tableBalance.setCellValueFactory(new PropertyValueFactory<ParticipantData, Double>("accBalance"));
        this.planTable.setItems(null);
        this.planTable.setItems(this.data); 
    }
    //load data, that can be called when person is added instead of onClick
    private void loadTableData(){
        //create table if it doesn't exist
        tableModel.createTable();
        try{
            Connection connection = ConnectDB.getConnection();
        
            this.data = FXCollections.observableArrayList();
            Statement mystmt;
            mystmt = connection.createStatement();
            ResultSet rs = mystmt.executeQuery("SELECT * FROM participants;");
            while (rs.next()){
               this.data.add(new ParticipantData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6)));
           }
            mystmt.close();
            connection.close(); 
          
        }
        catch (SQLException ex){
            System.out.println("Error"+ ex);
        }
        
        this.tableID.setCellValueFactory(new PropertyValueFactory<ParticipantData, Integer>("ID"));
        this.tableLastName.setCellValueFactory(new PropertyValueFactory<ParticipantData, String>("lastName"));
        this.tableFirstName.setCellValueFactory(new PropertyValueFactory<ParticipantData, String>("firstName"));
        this.tableAge.setCellValueFactory(new PropertyValueFactory<ParticipantData, Integer>("age"));
        this.tableSalary.setCellValueFactory(new PropertyValueFactory<ParticipantData, Double>("salary"));
        this.tableBalance.setCellValueFactory(new PropertyValueFactory<ParticipantData, Double>("accBalance"));
        this.planTable.setItems(null);
        this.planTable.setItems(this.data);
    }
    //add participant to the table
    @FXML
    private void addParticipant(ActionEvent e){
        //create table if it doesn't exist
        tableModel.createTable();
        //check that input is valid
        if (checkInputs()!= true){
            this.inputError.setText("Invalid Input");
            return;
        }
        inputError.setText("");
        try{
            Connection connection = ConnectDB.getConnection();
            PreparedStatement myStmt = connection.prepareStatement("INSERT INTO participants (LastName, FirstName, Age, Salary, AccountBalance) VALUES (?,?,?,?,?);");
            //get input values to create SQL statement - add values to db table
            myStmt.setString(1, this.lastName.getText());
            myStmt.setString(2, this.firstName.getText());
            myStmt.setInt(3, Integer.parseInt(this.age.getText()));
            myStmt.setDouble(4, Double.parseDouble(this.salary.getText()));
            myStmt.setDouble(5, Double.parseDouble(this.accBalance.getText()));
            
            myStmt.execute();
            connection.close();
            
            //load table data after add
            loadTableData();
            //clear fields after adding
            clearFields();
        }
        catch (SQLException ex){
            System.out.println("Error"+ ex);
        }
    }
    //clear text fields after inserting new participant. For button onclick and for use within other functions
    @FXML
    private void clearFields(ActionEvent e){
        this.inputError.setText("");
        this.lastName.setText("");
        this.firstName.setText("");
        this.age.setText("");
        this.salary.setText("");
        this.accBalance.setText("");
    }
    @Override
    public void clearFields(){
        this.inputError.setText("");
        this.lastName.setText("");
        this.firstName.setText("");
        this.age.setText("");
        this.salary.setText("");
        this.accBalance.setText("");
    }
    //check inputs to verify correct type
    @Override
    public boolean checkInputs(){
        try{
            Integer.parseInt(this.age.getText());
            Double.parseDouble(this.salary.getText());
            Double.parseDouble(this.accBalance.getText());
            return true;
        }
        catch (NumberFormatException ex){
            //System.out.println("Error: "+ex);
        }
        return false;
    }
    //Collect row data and switch scene to Calculator.  CALCULATE BENEFIT
    @FXML
    private void getDataforCalc(ActionEvent e){
        if(planTable.getSelectionModel().getSelectedItem() != null){
            this.selectError.setText("");
            ParticipantData selectedRow = planTable.getSelectionModel().getSelectedItem();
            Integer id = selectedRow.getID();
            String lName = selectedRow.getLastName();
            String fName = selectedRow.getFirstName();
            Integer p_age = selectedRow.getAge();
            Double sal = selectedRow.getSalary();
            Double accBal = selectedRow.getAccBalance();
            
            changeToCalc(id,lName,fName,p_age,sal,accBal);
        }
        else{
            //present an error if no row is selected
            this.selectError.setText("Select a Participant");
        }
        
    }
    //Changes scene to Calculator and adjusts values on page to previously selected row for calculation
    private void changeToCalc(Integer id,String lName,String fName,Integer p_age,Double sal,Double accBal){
        ChangeView.changeTo("Calculator");
        CalculatorController controller = (CalculatorController)getControllerByName("Calculator");
        if(controller != null){
            controller.idText.setText(Integer.toString(id));
            controller.nameText.setText(lName+", "+fName);
            controller.ageText.setText(Integer.toString(p_age));
            controller.salaryText.setText(Double.toString(sal));
            controller.accBalText.setText(Double.toString(accBal));
        }
    }
    
}
