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
        populateLists();
    }
    
    public void addClaim(Claim claim){
        claimList.add(claim);
    }
    
    public void addCustomer( String name, String surname, String email, Car car, String pwd)
    {
        
        customerList.put(customerList.size(), new Customer(customerList.size(), name, surname, email, car, pwd));
    }
    
    public ArrayList<Claim> getClaims(){
        return claimList;
    }
    
    public Employee getEmployee(int id)
    {
        return employeeList.get(id);
    }
    
    private void populateLists(){
       //id = employeeList.size();
       employeeList.put(employeeList.size(), new Employee(employeeList.size(), "Peter", "Sjodin", 1, "12345", Employee.Rank.High));
       employeeList.put(employeeList.size(), new Employee(employeeList.size(), "Markus", "Hidell", 1, "12345", Employee.Rank.Low));
       employeeList.put(employeeList.size(), new Employee(employeeList.size(), "Mihhail", "Matskin", 1, "12345", Employee.Rank.High));
       
       customerList.put(customerList.size(), new Customer(customerList.size(), "First", "Customer", "123@kth.se", car, "12345"));
       
       
    }
    
    

    
    
    
    
}
