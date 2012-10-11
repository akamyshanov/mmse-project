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
    private Car car;
    private String password;

    
    public Customer(int id, String name, String surname, String email, String pwd, Car car)
    {
        this.customerId = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = pwd;
        this.car = car;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
    
    public Car getCar(){
        return car;
    }

    public boolean checkPassword(String pwd)
    {
        return password.equals(pwd);
    }
}
