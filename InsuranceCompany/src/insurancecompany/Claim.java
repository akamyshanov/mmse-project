/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

/**
 *
 * @author Andrew
 */
public class Claim {

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public int getDamageCost() {
        return damageCost;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    
    public enum Category
    {
        Undefined,
        Simple,
        Complex
    }
    
    public enum Status
    {
        Unregistered,
        Registerd,
        Confirmed,
        Declined
    }

    private int id;
    private int customerId;
    private int carPrice;
    private int damageCost;
    private String description;
    private Category category;
    private Status status;

    public Claim(int id, int customerId, int carPrice, int damageCost, String description) {
        this.id = id;
        this.customerId = customerId;
        this.carPrice = carPrice;
        this.damageCost = damageCost;
        this.description = description;
        this.category = Category.Undefined;
        this.status = Status.Unregistered;
    }
}
