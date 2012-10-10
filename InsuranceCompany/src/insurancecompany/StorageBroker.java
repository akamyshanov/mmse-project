/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sanyasn
 */
public class StorageBroker {
    private ArrayList<Claim> claimList;
    private HashMap<Integer, Employee> employeeList;
    private HashMap<Integer, Customer> customerList;
    
    public StorageBroker(){
        claimList = new ArrayList<Claim>();
        employeeList = new HashMap<Integer, Employee>();
        customerList = new HashMap<Integer, Customer>();
    }
    
    public void addClaim(Claim claim){
        claimList.add(claim);
    }
    
    public void addCustomer(Customer person)
    {
        customerList.put(person.getId(), person);
    }
    
    public ArrayList<Claim> getClaims(){
        return claimList;
    }
    
    public Employee getEmployee(int id)
    {
        return employeeList.get(id);
    }
    
    

    
    
    
    
}
