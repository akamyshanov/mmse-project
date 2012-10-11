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
    
    public Payment(int id, int customerid, int claim, String b, long a){
        this.pid = id;
        this.customerId = customerid;
        this.claimId = claim;
        this.bank = b;
        this.accountNumber = a;        
    }
    
    public int getId(){
        return pid;
    }
    
    public int getCustomerId(){
        return customerId;
    }
    
    public String getBank(){
        return bank;
    }
    
    public double getAccount(){
        return accountNumber;
    }
    
    
}
