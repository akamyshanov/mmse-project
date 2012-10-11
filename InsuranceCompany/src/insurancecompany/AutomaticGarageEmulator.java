/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

/**
 *
 * @author Sanyasn
 */
public class AutomaticGarageEmulator {
    private String companyName;
    private int callCount;
    
    public AutomaticGarageEmulator() {
        companyName = "SuperRepair";
        callCount = 0;
    }
        
    public void call(String message){
        callCount++;        
    }    
}
