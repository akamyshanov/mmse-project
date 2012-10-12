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
    private String billingInfo;
    private Status status;
    
    public enum Status{
        Finished,
        Unfinished
    }
    
    public Payment(int id, int customerid, int claim, int amount, String bankAccount){
        this.pid = id;
        this.customerId = customerid;
        this.claimId = claim;
        this.amount = amount;
        this.billingInfo = bankAccount;
        this.status = Status.Unfinished;
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
    
    public String getBillingInfo(){
        return billingInfo;
    }
    
    public Payment.Status getStatus(){
        return status;
    }
    
    public void setStatus(Payment.Status st){
        status = st;
    }
    
    
}
