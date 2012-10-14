/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanyasn
 */
public class CustomerTest {
    Customer customer;
    
    public CustomerTest() {
        customer = new Customer(0, "myname", "mysurn", "mail", "pwd", new Car(100, "BMW"));
    }
    
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId test");
        assertEquals(0, customer.getCustomerId());
    }

    @Test
    public void testGetName() {
        System.out.println("getName test");
        assertEquals("myname", customer.getName());
    }

    @Test
    public void testGetSurname() {
        System.out.println("getSurname test");
        assertEquals("mysurn", customer.getSurname());
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail test");
        assertEquals("mail", customer.getEmail());
    }

    @Test
    public void testGetCar() {
        System.out.println("getCar test");
        assertNotNull(customer.getCar());
    }

    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword test: pwd set to pwd ");
        assertFalse(customer.checkPassword("rdftgre"));
        assertTrue(customer.checkPassword("pwd"));
    }
}
