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
    private String model;
    
    public Car(int price, String about)
    {
        this.price = price;
        this.model = about;        
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getModel()
    {
        return model;
    }
    
}
