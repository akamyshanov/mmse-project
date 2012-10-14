/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import insurancecompany.Payment.Status;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author sanyasn
 */
public class PaymentTest {
    Payment payment;
    
    public PaymentTest() {
        payment = new Payment(0, 1, 2, 100, "Nordea 1");
    }

    @Test
    public void testGetId() {
        System.out.println("getId test: set to 0");
        assertEquals(0, payment.getId());
    }

    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId test: set to 1");
        assertEquals(1, payment.getCustomerId());
    }


    @Test
    public void testGetClaimId() {
        System.out.println("getClaimId test: set to 2");
        assertEquals(2, payment.getClaimId());
    }

    @Test
    public void testGetAmount() {
        System.out.println("getAmount test: set to 100");
        assertEquals(100, payment.getAmount());
    }

    @Test
    public void testGetBillingInfo() {
        System.out.println("getBillingInfo test ");
        assertEquals("Nordea 1", payment.getBillingInfo());
    }

    @Test
    public void testGetStatus() {
        System.out.println("getStatus test: set to Unfinished ");
        assertEquals(Status.Unfinished, payment.getStatus());
    }


    @Test
    public void testSetStatus() {
        System.out.println("setStatus test");
        payment.setStatus(Status.Finished);
        assertEquals(Status.Finished, payment.getStatus());
    }
}
