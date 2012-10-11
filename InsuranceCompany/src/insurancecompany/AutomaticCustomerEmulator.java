/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

/**
 *
 * @author Sanyasn
 */
public class AutomaticCustomerEmulator {
    private int mailCount;
    private int smsCount;
    
    public AutomaticCustomerEmulator(){
        mailCount = 0;
        smsCount = 0;
    }
    
    public String sendForm(){
        return "this is filled out form";
    }
        
    public void sendMail(String mail){
        mailCount++;        
    }
    
    public void sendSms(String sms){
        smsCount++;
    }

}
