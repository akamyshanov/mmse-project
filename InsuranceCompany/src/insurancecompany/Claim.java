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

    public void setId(int id) {
        this.id = id;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public enum Category
    {
        Undefined,
        Simple,
        Complex
    }

    private int id;
    private int customerId;
    private int carPrice;
    private int damageCost;
    private String description;
    private Category category;

    public Claim(int customerId, int damageCost, String description) {
        this.customerId = customerId;
        this.damageCost = damageCost;
        this.description = description;
    }

    
    
}
