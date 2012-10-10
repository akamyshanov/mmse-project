/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

/**
 *
 * @author Sanyasn
 */
public class Car {
    private int price;
    private String description;
    
    public Car(String about)
    {
        this.description = about;        
    }
    
    public int getPrice(){
        return price;
    }
    
}
