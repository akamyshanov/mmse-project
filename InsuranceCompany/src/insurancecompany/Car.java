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
    
    public Car(int id, String about)
    {
        this.carId = carId;
        this.description = about;        
    }
    
    public int getCarId(){
        return carId;
    }
    public int getPrice(){
        return price;
    }
    
}
