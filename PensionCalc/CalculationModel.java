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
public class CalculationModel {
    
    private Double totalBenefit=0.0;
    private Integer yearsToCalculate;
    
    public CalculationModel(){
    }
    
    //perform benefit calculation, return total to controller
    public Double benefitCalculation(Integer age, Integer retireAge, Double salary, Double accBalance){
        
        yearsToCalculate = retireAge - age;
        
        //calculate benefit for each year, add to lumpsum to get total benefit
        for(int i=0;i<yearsToCalculate;i++){
            //for each year:
            // salary * 4% and current account balance * 5%, add to lump sum
            totalBenefit+= ((salary * 0.04) + (accBalance * 0.05));
        }
        
        return totalBenefit;
    }
    
}
