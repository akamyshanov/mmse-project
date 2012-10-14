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
    private static int formCount;
    public static String defaultAnswer;
    
    public AutomaticCustomerEmulator(){
        mailCount = 0;
        smsCount = 0;
        formCount = 0;
        defaultAnswer = "Aaccount details from robot";
    }
    
    public static String sendForm(){
        formCount++;
        return defaultAnswer;
    }
        
    public static void sendMail(String mail){
        mailCount++;        
    }
    
    public void sendSms(String sms){
        smsCount++;
    }
    
    public static int getMailCount(){
        return mailCount;
    }
    
    public static int getFormCount(){
        return formCount;
    }

}
