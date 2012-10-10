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
    public enum Category
    {
        Undefined,
        Simple,
        Complex
    }

    private int customerId;
    private String description;
    private Category category;
    
    public Claim(int customerId, String description) {
        this.customerId = customerId;
        this.description = description;
        this.category = Category.Undefined;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCategory(Category _category) {
        category = _category;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
    
}