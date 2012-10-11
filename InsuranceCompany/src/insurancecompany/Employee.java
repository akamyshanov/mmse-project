/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import sun.security.util.Password;

/**
 *
 * @author Sanyasn
 */
public class Employee {
    public enum Rank
    {
        Low,
        High
    }
    private int id;
    private String name;
    private String surname;
    private int departmentId;
    private String password;
    private Rank rank;  
    
    public Employee(int id, String name, String sur, int department, String pwd, Rank rank)
    {
        this.id = id;
        this.name = name;
        this.surname = sur;
        this.departmentId = department;
        this.password = pwd;
        this.rank = rank;         
    }
    
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public Rank getRank() {
        return rank;
    }
    
    
    
    public boolean checkPassword(String pwd)
    {
        return password.equals(pwd);
    }
   
}


