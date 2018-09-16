/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krs6y9pensioncalculator;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Kyle
 */

//data model for tableView data
public class ParticipantData {
    private final IntegerProperty ID;
    private StringProperty lastName;
    private StringProperty firstName;
    private IntegerProperty age;
    private DoubleProperty salary;
    private DoubleProperty accBalance;
    
    public ParticipantData(Integer ID, String lastName, String firstName, Integer age, Double salary, Double accBalance){
        this.ID = new SimpleIntegerProperty(ID);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.age = new SimpleIntegerProperty(age);
        this.salary = new SimpleDoubleProperty(salary);
        this.accBalance = new SimpleDoubleProperty(accBalance);
    }
    //relevant getters and setters:
    public Integer getID(){
        return ID.get();
    }
    public String getLastName(){
        return lastName.get();
    }
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }
    public String getFirstName(){
        return firstName.get();
    }
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    public Integer getAge(){
        return age.get();
    }
    public void setAge(Integer age){
        this.age.set(age);
    }
    public Double getSalary(){
        return salary.get();
    }
    public void setSalary(Double salary){
        this.salary.set(salary);
    }
    public Double getAccBalance(){
        return accBalance.get();
    }
    public void setAccBalance(Double accBalance){
        this.accBalance.set(accBalance);
    }
    public IntegerProperty idProperty(){
        return this.ID;
    }
    public StringProperty lastNameProperty(){
        return this.lastName;
    }
    public StringProperty firstNameProperty(){
        return this.firstName;
    }
    public IntegerProperty ageProperty(){
        return this.age;
    }
    public DoubleProperty salaryProperty(){
        return this.salary;
    }
    public DoubleProperty accBalanceProperty(){
        return this.accBalance;
    }
}
