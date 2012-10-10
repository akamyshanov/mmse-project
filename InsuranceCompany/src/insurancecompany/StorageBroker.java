/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.util.ArrayList;

/**
 *
 * @author Sanyasn
 */
public class StorageBroker {
    private ArrayList<Claim> claimList;
    private ArrayList<Employee> employeeList;
    private ArrayList<Customer> customerList;
    
    public StorageBroker(){
        claimList = new ArrayList<Claim>();
        employeeList = new ArrayList<Employee>();
        
        
    }
    
    public void addClaim(Claim claim)
    {
        claimList.add(claim);
    }
    
    public ArrayList<Claim> getClaims()
    {
        return claimList;
    }
    
    
    
    
}
