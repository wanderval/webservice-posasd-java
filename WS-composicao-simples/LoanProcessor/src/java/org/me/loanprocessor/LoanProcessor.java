/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.loanprocessor;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author monkey_001
 */
@WebService(serviceName = "LoanProcessor")
@Stateless()
public class LoanProcessor {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "processApplicOperation")
    public String processApplicOperation(@WebParam(name = "socialSecurityNumber") String socialSecurityNumber, @WebParam(name = "applicantName") String applicantName, @WebParam(name = "applicantAddress") String applicantAddress, @WebParam(name = "applicantEmailAddress") String applicantEmailAddress, @WebParam(name = "applicantAge") Integer applicantAge, @WebParam(name = "applicantGender") String applicantGender, @WebParam(name = "annualSalary") Double annualSalary, @WebParam(name = "amountRequested") Double amountRequested){
        int MINIMUM_AGE_LIMIT = 18;
        int MAXIMUM_AGE_LIMIT = 65;
        double MINIMUM_SALARY = 20000;
        int AVERAGE_LIFE_EXPECTANCY = 70;
        String result = "Loan Application APPROVED.";

        // Check age of applicant
        // If less than min age limit, rejected
        //result = result+applicantAge;
        //System.out.println(applicantName);
        
        
        
        /*Integer applicantAge2 = null;
        
        try{
            applicantAge2 = Integer.parseInt(applicantAge.trim());
            //result = result + applicantAge2.toString();
        }catch(Exception e){
            System.out.println(e.getMessage());
            //result = result +e;
        }*/
        
        
        
        if (applicantAge < MINIMUM_AGE_LIMIT) {
                result = "Loan Application REJECTED - Reason: Under-aged " + 
                applicantAge + ". Age needs to be over " +
                MINIMUM_AGE_LIMIT + " years to qualify.";
                return result;
        }

        // Check age of applicant
        // If more than max age limit, rejected
        if (applicantAge > MAXIMUM_AGE_LIMIT) {
                result = "Loan Application REJECTED - Reason: Over-aged " +
                applicantAge + ". Age needs to be under " +
                MAXIMUM_AGE_LIMIT + " years to qualify.";
                return result;
        }

        // Check annual salary
        // If less than min salary, rejected
        if (annualSalary < MINIMUM_SALARY) {
                result = "Loan Application REJECTED - Reason: Annual Salary $" +
                annualSalary + " too low. Annual Salary needs to be over $" + 
                MINIMUM_SALARY + " to qualify.";
                return result;
        }

        // Calculate the years to pay off loan based on applicantAge
        int yearsToRepay = AVERAGE_LIFE_EXPECTANCY - applicantAge;
        // Calculate the max amount of loan based on years to pay off loan
        double limit = annualSalary * yearsToRepay * 0.5;
        
        // Check amount requested, if higher than limit, rejected
        if (amountRequested > limit) {
                result = "Loan Application REJECTED - Reason: " + 
                "You are asking for too much $" + amountRequested +
                ". Annual Salary $" + annualSalary + ", Age " +
                applicantAge + " years. Your limit is $" + limit;
                return result;
        }
        return result;
    }
}
