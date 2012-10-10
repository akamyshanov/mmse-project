/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 *
 * @author Sanyasn
 */
public class Customer {
    private int customerId;
    private String name;
    private String surname;
    private String email;
    private int carPrice;
    private HashMap<Integer, Car> cars;
    private String hashedPwd;
    private String carDescription;
    
    public Customer(int id, String name, String surname, String email, int price, String carDescript, String pwd)
    {
        this.customerId = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.carPrice = price;
        this.carDescription = carDescript;
        this.hashedPwd = pwd;
    }
    
    public int getId(){
        return customerId;
    }
    
    public int getCarPrice(){
        return carPrice;
    }
    
    public int getCarPrice(int carId){
        
        return cars.get(carId).getPrice();
    }
    
    public void addCar(Car car){
        cars.put(car.getCarId(), car);        
    }
    
    public boolean checkPassword(String pwd)
    {
        if(hashedPwd.equals(getHash(pwd)))
            return true;
        return false;
    }
    
    
    
    private String getHash(String password) {
        //MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        //hasher.reset();
        //hasher.update(password);
        //return hasher.digest(password.getBytes("UTF-8"));
        return password;
    }
    
    
}
