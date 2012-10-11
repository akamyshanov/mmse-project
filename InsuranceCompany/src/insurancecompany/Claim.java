/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class Claim {

    public int getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public Integer getDamageCost() {
        return damageCost;
    }

    public String getDescription() {
        return description;
    }

    public Rank getCategory() {
        return rank;
    }

    public void setCategory(Rank category) {
        this.rank = category;
    }
    
    public Status getStatus()
    {
        return this.status;
    }

    public void rank(Rank rank) {
        if(this.rank != Rank.Undefined)
            return;
        
        this.rank = rank;
        this.status = rank == Rank.Undefined ? Status.UnRanked : Status.Ranked;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public static ArrayList<String> getListOfRanks(){
        ArrayList<String> rankArray = new ArrayList<String>();
        for (Claim.Rank rank : Claim.Rank.values())
            rankArray.add(rank.toString());
        return rankArray;
    }
    
    public Claim.Status[] getStatusList(){
        return Status.values();
    }
    
    public enum Rank
    {
        Undefined,
        Simple,
        Complex
    }
    
    
    public enum Status
    {
        UnRanked,
        Ranked,
        Confirmed,
        Declined,
        Paid
    }

    private int id;
    private int customerId;
    private int carPrice;
    private int damageCost;
    private String description;
    private Rank rank;
    private Status status;

    public Claim(int id, int customerId, int carPrice, int damageCost, String description) {
        this.id = id;
        this.customerId = customerId;
        this.carPrice = carPrice;
        this.damageCost = damageCost;
        this.description = description;
        this.rank = Rank.Undefined;
        this.status = Status.UnRanked;
    }
}
