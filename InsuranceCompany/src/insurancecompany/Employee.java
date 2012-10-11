/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

/**
 *
 * @author Sanyasn
 */
public class Employee {
    public enum Rank
    {
        Undefined,
        Low,
        High
    }
    public enum Department
    {
        CarDamage,
        Finance
    }
    
    private int id;
    private String name;
    private String surname;
    private Department department;
    private String password;
    private Rank rank;  
    
    public Employee(int id, String name, String sur, Department department, String pwd, Rank rank)
    {
        this.id = id;
        this.name = name;
        this.surname = sur;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public Rank getRank() {
        return rank;
    }
    
    
    
    public boolean checkPassword(String pwd)
    {
        return password.equals(pwd);
    }
   
}


