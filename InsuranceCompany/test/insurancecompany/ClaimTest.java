/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import insurancecompany.Claim.Rank;
import insurancecompany.Claim.Status;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanyasn
 */
public class ClaimTest {
    
    StorageBroker storage;
    Claim claim;
    public ClaimTest(){
            storage = new StorageBroker();
            claim = new Claim(0, 0, 200, 10, "oh my god!");
    }

    @Test
    public void testGetId() {
        System.out.println("getId test: id is set to 0");
        assertEquals(0, claim.getId());
    }


    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId test: id is set to 0");
        assertTrue(0 == claim.getCustomerId());
    }


    @Test
    public void testGetCarPrice() {
        System.out.println("getCarPrice test: price is 200");
        assertTrue(200 == claim.getCarPrice());
    }

    @Test
    public void testGetDamageCost() {
        System.out.println("getDamageCost test");
        assertTrue(10 == claim.getDamageCost());
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription test");
        assertEquals("oh my god!", claim.getDescription());
    }

    @Test
    public void testGetRank() {
        System.out.println("getRank test: rank is unranked");
        assertEquals(Claim.Rank.Undefined, claim.getRank());
    }

    @Test
    public void testGetStatus() {
        assertEquals(Claim.Status.UnRanked, claim.getStatus());
    }

    @Test
    public void testSetCategory() {
        System.out.println("setCategory/Rank test");
        
        claim.setCategory(Claim.Rank.Complex);
        assertEquals(Claim.Rank.Complex, claim.getRank());
    }

    @Test
    public void testRank() {
        claim.setCategory(Rank.Undefined);
        claim.rank(Claim.Rank.Complex);
        assertEquals(Claim.Rank.Complex, claim.getRank());
        
        claim.setCategory(Rank.Simple);
        claim.rank(Claim.Rank.Complex);
        assertNotSame(Claim.Rank.Complex, claim.getRank());
    }

    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        claim.setStatus(Status.Paid);
        assertEquals(Status.Paid, claim.getStatus());
    }
}
