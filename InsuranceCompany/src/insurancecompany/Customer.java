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
    private HashMap<Integer, Car> cars;
    private String hashedPwd;

    
    public Customer(int id, String name, String surname, String email, Car car, String pwd)
    {
        this.customerId = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        cars.put(cars.size(), car);
        this.hashedPwd = pwd;
    }
    
    public int getId(){
        return customerId;
    }
    
    public HashMap<Integer, Car> getCarList(){
        return cars;
    }
    
    public int getCarPrice(int carId){
        
        return cars.get(carId).getPrice();
    }
    
    public void addCar(Car car){
        cars.put(cars.size(), car);        
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
