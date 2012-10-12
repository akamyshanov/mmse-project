/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

/**
 *
 * @author Sanyasn
 */
public class Payment {
    private int pid;
    private int customerId;
    private int claimId;
    private int amount;
    
    public enum Status{
        Finished,
        Unfinished
    }
    
    public Payment(int id, int customerid, int claim, int amount){
        this.pid = id;
        this.customerId = customerid;
        this.claimId = claim;
        this.amount = amount;
    }
    
    public int getId(){
        return pid;
    }
    
    public int getCustomerId(){
        return customerId;
    }
    
    public int getClaimId(){
        return claimId;
    }
    
    public int getAmount(){
        return amount;
    }
    
    
}
