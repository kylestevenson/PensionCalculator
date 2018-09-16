/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kyle
 */
public class ConnectDB {
    
    public ConnectDB(){
    }
    //establish connection to the database
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:PensionDB.sqlite");
        }
        catch (ClassNotFoundException e) {
        }
        return null;
    }
    
    
}
