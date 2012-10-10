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
    private int carId;
    private int price;
    private String description;
    
    public Car(int id, int price, String about)
    {
        this.carId = id;
        this.price = price;
        this.description = about;        
    }
    
    public int getPrice(){
        return price;
    }
    
}
