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
        Low,
        High
    }
    private int id;
    private String name;
    private String surname;
    private int departmentId;
    private String hashedPwd;
    private Rank rank;  
    
    public Employee(int id, String name, String sur, int department, String pwd, Rank rank)
    {
        this.id = id;
        this.name = name;
        this.surname = sur;
        this.departmentId = department;
        this.hashedPwd = pwd;
        this.rank = rank;         
    }
    
    public int getId(){
        return id;
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


