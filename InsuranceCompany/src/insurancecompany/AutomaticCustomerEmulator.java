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
    private static int mailCount;
    private static int smsCount;
    
    public AutomaticCustomerEmulator(){
        mailCount = 0;
        smsCount = 0;
    }
    
    public static String sendForm(){
        return "this is filled out form";
    }
        
    public static void sendMail(String mail){
        mailCount++;        
    }
    
    public void sendSms(String sms){
        smsCount++;
    }

}
