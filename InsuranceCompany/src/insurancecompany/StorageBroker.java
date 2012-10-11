
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

    public StorageBroker() {
        claimList = new ArrayList<Claim>();
        employeeList = new HashMap<Integer, Employee>();
        customerList = new HashMap<Integer, Customer>();
        populateLists();
    }

    private Customer getCustomer(int id, String password) {
        Customer customer = customerList.get(id);
        if (customer == null) {
            return null;
        }

        if (!customer.checkPassword(password)) {
            return null;
        }

        return customer;
    }

    public String getStatus()
    {
        String status = "\n=== Customers ===\n";
        for(Customer c : customerList.values())
        {
            status += String.format(
                    "%d: %s %s | %s | %s (%d)\n",
                    c.getCustomerId(),
                    c.getName(),
                    c.getSurname(),
                    c.getEmail(),
                    c.getCar().getModel(),
                    c.getCar().getPrice());
        }
        
        status += "\n=== Employees ===\n";
        
        for(Employee e : employeeList.values())
        {
            status += String.format(
                    "%d: %s %s | %d | %s\n",
                    e.getId(),
                    e.getName(),
                    e.getSurname(),
                    e.getDepartmentId(),
                    e.getRank());
        }
        
        status += "\n=== Claims ===\n";
        for(Claim c : claimList)
        {
            status += String.format(
                    "%d | %d | %d | %d | %s | %s | %s\n",
                    c.getId(),
                    c.getCustomerId(),
                    c.getCarPrice(),
                    c.getDamageCost(),
                    c.getDescription(),
                    c.getCategory(),
                    c.getStatus());
        }
        
        
        return status;
    }
    
    public Boolean addClaim(int customerId, String password, int damageCost, String description) {
        Customer customer = getCustomer(customerId, password);
        if (customer == null) {
            return false;
        }
        claimList.add(new Claim(claimList.size(), customer.getCustomerId(), customer.getCar().getPrice(), damageCost, description));
        
        System.out.println(getStatus());
        
        return true;
    }

    public int addCustomer(String name, String surname, String email, String pwd, String carModel, int carPrice) {
        int id = customerList.size();
        customerList.put(id, new Customer(customerList.size(), name, surname, email, pwd, new Car(carPrice, carModel)));
        
        System.out.println(getStatus());
        return id;
    }

    public ArrayList<Claim> getClaims(int id, String password) {
        ArrayList<Claim> claimList = new ArrayList<Claim>();
        for(Claim c : this.claimList)
        {
            claimList.add(c);
        }
        return claimList;
    }

    public Employee getEmployee(int id) {
        return employeeList.get(id);
    }

    private void populateLists() {
        //id = employeeList.size();
        employeeList.put(employeeList.size(), new Employee(employeeList.size(), "Peter", "Sjodin", 1, "12345", Employee.Rank.High));
        employeeList.put(employeeList.size(), new Employee(employeeList.size(), "Markus", "Hidell", 1, "12345", Employee.Rank.Low));
        employeeList.put(employeeList.size(), new Employee(employeeList.size(), "Mihhail", "Matskin", 1, "12345", Employee.Rank.High));
        
        addCustomer("First", "Customer", "123@kth.se", "12345", "Lada Kalina", 200);
        addCustomer("Second", "Customer", "123@kth.se", "12345", "Lada Kalina", 200);
        addCustomer("Third", "Customer", "123@kth.se", "12345", "Lada Kalina", 200);
        addCustomer("Fourth", "Customer", "123@kth.se", "12345", "Lada Kalina", 200);
        
        claimList.add(new Claim(claimList.size(), 0, 100, 10, "oh my god!"));
        claimList.add(new Claim(claimList.size(), 0, 100, 10, "priehali"));

        System.out.println(getStatus());

    }
}