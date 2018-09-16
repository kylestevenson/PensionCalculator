/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

/**
 *
 * @author Kyle
 */
//implement on any page taking user data
public interface Data {
    //verify input values are valid, for any page accepting user data
    public boolean checkInputs();
    //able to clear textFields, for any page accepting user data
    public void clearFields();
}
