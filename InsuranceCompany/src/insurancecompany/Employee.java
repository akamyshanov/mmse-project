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
        Simple,
        Complex
    }
    private int id;
    private String name;
    private String Surname;
    private int departmentId;
    private Rank rank;   
    
}
