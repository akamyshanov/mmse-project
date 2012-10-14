/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanyasn
 */
public class ClaimActionHandlerTest {
    
    //this private class is required for the test
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //updateClaims();
        }
    }  
       

    @Test
    public void testUpdateClaim() {
        StorageBroker storage = new StorageBroker();
        Employee employee = storage.getEmployee(0, "12345");
        if(employee == null)
            System.out.println("There is no employee");
        ArrayList<Claim> claims = storage.getClaims(employee);
        System.out.println("there are "+ claims.size()+ " claims");
        Claim claim = claims.get(0);
        ClaimActionForm form = new ClaimActionForm();

        
        
        ClaimActionHandler myHandler = new ClaimActionHandler(employee, claim, storage, form, new UpdateListener());

        //making the private method visible using reflection
        Method privateUpdateMethod = null;
        try {
            privateUpdateMethod = ClaimActionHandler.class.getDeclaredMethod("updateClaim", boolean.class);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //test case 1
        claim.setStatus(Claim.Status.UnRanked);
        privateUpdateMethod.setAccessible(true);
        try {
            privateUpdateMethod.invoke(myHandler, true);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(claim.getRank(), Claim.Rank.Complex);
        
        //test case 2
        claim.setStatus(Claim.Status.Ranked);
        int numbPaym = storage.getPayments().size();
        try {
            privateUpdateMethod.invoke(myHandler, true);
        } catch (Exception ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        assertEquals(claim.getStatus(), Claim.Status.Confirmed);
        int newNumbPaym = storage.getPayments().size();
        assertTrue(newNumbPaym == numbPaym+1);
        assertEquals(storage.getPayments().get(newNumbPaym - 1).getBillingInfo(), AutomaticCustomerEmulator.defaultAnswer);
        
        
        //test case 3        
        claim.setStatus(Claim.Status.UnRanked);
        claim.setCategory(Claim.Rank.Undefined);
        try {
            privateUpdateMethod.invoke(myHandler, false);
        } catch (Exception ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        assertEquals(claim.getRank(), Claim.Rank.Simple);
        
         //test case 4
        claim.setStatus(Claim.Status.Ranked);
        numbPaym = storage.getPayments().size();
        int mailCount = AutomaticCustomerEmulator.getMailCount();
        try {
            privateUpdateMethod.invoke(myHandler, false);
        } catch (Exception ex) {
            Logger.getLogger(ClaimActionHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        assertEquals(claim.getStatus(), Claim.Status.Declined);
        newNumbPaym = storage.getPayments().size();
        assertFalse(newNumbPaym == numbPaym+1);        
        assertTrue(AutomaticCustomerEmulator.getMailCount() == mailCount+1);
        
        
    }
}
