/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;

/**
 *
 * @author Kyle
 */
public class TableModel {
    
    public TableModel(){
        
    }
    
    //create table participants if it doesn't already exist
    public void createTable(){
        try{
           Connection connection = ConnectDB.getConnection();
        
            Statement stmt = connection.createStatement();
           
            stmt.execute("CREATE TABLE IF NOT EXISTS participants (ID INTEGER PRIMARY KEY AUTOINCREMENT, LastName text, FirstName text, Age INTEGER, Salary DOUBLE, AccountBalance DOUBLE);");
            
            stmt.close();
            connection.close();
        }
        catch (SQLException ex){
            System.out.println("Error: "+ex);
        }
        
    }
    //drop table participants
    public void destroyTable(){
        try{
           Connection connection = ConnectDB.getConnection();
        
            Statement stmt = connection.createStatement();
           
            stmt.execute("DROP TABLE participants;");
            
            stmt.close();
            connection.close();
        }
        catch (SQLException ex){
            System.out.println("Error: "+ex);
        }
        
    }
    
}
