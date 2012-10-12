/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class StorageBrokerTest {
    
    StorageBroker instance = new StorageBroker();
    HashMap<Integer, String> customers = new HashMap<Integer, String>();
    HashMap<Integer, String> employees = new HashMap<Integer, String>();
    ArrayList<Integer> claims = new ArrayList<Integer>();
    Random random = new Random();
  
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String name = "Name";
        String surname = "Surname";
        String email = "email@email.com";
        String pwd = "password";
        String carModel = "audi";
        int carPrice = 200;

        int id = instance.addCustomer(name, surname, email, pwd, carModel, carPrice);


        Customer customer = instance.getCustomer(id, pwd);
        
        assertFalse(customer == null);
        assertTrue(customer.checkPassword(pwd));
        assertEquals(customer.getCustomerId(), id);
        assertEquals(customer.getEmail(), email);
        assertEquals(customer.getName(), name);
        assertEquals(customer.getSurname(), surname);
        Car car = customer.getCar();
        assertEquals(car.getModel(), carModel);
        assertEquals(car.getPrice(), carPrice);


        customers.put(id, pwd);
        
    }
    
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        String name = "EmpName";
        String surname = "EmpSurname";
        Employee.Department dept = Employee.Department.CarDamage;
        String password = "pswd";
        Employee.Rank rank = Employee.Rank.High;
        
        int id = instance.addEmployee(name, surname, dept, password, rank);
        
        Employee emp = instance.getEmployee(id, password);
        assertFalse(emp == null);
        
        assertEquals(emp.getId(), id);
        assertTrue(emp.checkPassword(password));
        assertEquals(emp.getName(), name);
        assertEquals(emp.getSurname(), surname);
        assertEquals(emp.getDepartment(), dept);
        assertEquals(emp.getRank(), rank);
        
        employees.put(id, password);
    }
    
    
    private void testClaim(Claim claim, int id, int customerId, int damageCost, String description)
    {
        assertTrue(claim != null);
        
        assertEquals(claim.getId(), id);
        assertEquals(claim.getStatus(), Claim.Status.UnRanked);
        assertEquals((int)claim.getCustomerId(), customerId);
        assertEquals((int)claim.getCarPrice(), (int)instance.getCustomer(customerId, customers.get(customerId)).getCar().getPrice());
        assertEquals((int)claim.getDamageCost(), damageCost);
        assertEquals(claim.getDescription(), description);
    }
    
    @Test
    public void testAddClaim() {
        System.out.println("addClaim");
        
        testAddCustomer();
        
        int customerId = ((Number)customers.keySet().toArray()[customers.size() == 1 ? 0 : (random.nextInt(customers.size() - 1))]).intValue();
        
        
        int damageCost = 100;
        String description = "DESCRIPTION";
        
        int id = instance.addClaim(customerId, customers.get(customerId), damageCost, description);
        
        assertTrue(id >= 0);
        
        ArrayList<Claim> claims = instance.getClaimsByCustomerId(customerId);
        assertEquals(claims.size(), 1);
        
        Claim claim = claims.get(0);
        
        testClaim(claim, id, customerId, damageCost, description);
        testClaim(instance.getClaim(id), id, customerId, damageCost, description);
        
        this.claims.add(id);
    }

    @Test
    public void testUpdateClaim() {
        testAddClaim();
        testAddEmployee();
        
        int employeeId = ((Number)employees.keySet().toArray()[employees.size() == 1 ? 0 : (random.nextInt(employees.size() - 1))]).intValue();
        Employee employee = instance.getEmployee(employeeId, employees.get(employeeId));
        
        ArrayList<Claim> claims = instance.getClaims(employee);
        
        Claim claim = claims.get(claims.size() == 1 ? 0 : (random.nextInt(claims.size() - 1)));
        
        Claim.Rank rank = claim.getRank() == Claim.Rank.Complex ? Claim.Rank.Simple : Claim.Rank.Complex;
        Claim.Status status = claim.getStatus() == Claim.Status.UnRanked ? Claim.Status.Ranked : Claim.Status.Declined;
        
        claim.setCategory(rank);
        claim.setStatus(status);
        
        instance.updateClaim(claim);
        
        Claim updatedClaim = instance.getClaim(claim.getId());
        
        assertFalse(updatedClaim == null);
        assertEquals(updatedClaim.getId(), claim.getId());
        assertEquals(updatedClaim.getCustomerId(), claim.getCustomerId());
        assertEquals(updatedClaim.getDamageCost(), claim.getDamageCost());
        assertEquals(updatedClaim.getDescription(), claim.getDescription());
        assertEquals(updatedClaim.getCarPrice(), claim.getCarPrice());
        assertEquals(updatedClaim.getStatus(), status);
        assertEquals(updatedClaim.getRank(), rank);

    }
    
    @Test
    public void addPayment() {
        testAddClaim();

        Claim claim = instance.getClaim(claims.get(claims.size() == 1 ? 0 : (random.nextInt(claims.size() - 1))));
        int id = instance.addPayment(claim.getCustomerId(), claim.getId(), claim.getDamageCost());
        
        ArrayList<Payment> payments = instance.getPayments();
        
        Payment payment = null;
        for(Payment p : payments) {
            if(p.getId() == id)
            {
                payment = p;
                break;
            }
        }
        
        assertFalse(payment == null);
        assertEquals(payment.getId(), id);
        assertEquals((int)payment.getCustomerId(), (int)claim.getCustomerId());
        assertEquals(payment.getClaimId(), claim.getId());
        assertEquals((int)payment.getAmount(), (int)claim.getDamageCost());
        
    }
            
    
    
}
