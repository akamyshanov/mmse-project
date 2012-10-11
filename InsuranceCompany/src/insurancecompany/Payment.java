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
    private String bank;
    private long accountNumber;
    private double amount;
    private Status status;
    
    public enum Status{
        Finished,
        Unfinished
    }
    
    public Payment(int id, int customerid, int claim, String b, long a, double amount){
        this.pid = id;
        this.customerId = customerid;
        this.claimId = claim;
        this.bank = b;
        this.accountNumber = a;
        this.amount = amount;
        status = Status.Unfinished;
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
    
    public double getAmount(){
        return amount;
    }
    
    public Payment.Status getStatus(){
        return status;
    }
    
    public String getBank(){
        return bank;
    }
    
    public double getAccount(){
        return accountNumber;
    }
    
    
}
