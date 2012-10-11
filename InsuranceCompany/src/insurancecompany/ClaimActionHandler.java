/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class ClaimActionHandler {
    
    Employee employee;
    Claim claim;
    StorageBroker storage;
    ClaimActionForm form;
    Claim.Status currentStatus;

    ActionListener listener;
    
    public ClaimActionHandler(Employee employee, Claim claim, StorageBroker storage, ClaimActionForm form, ActionListener updateListener) {
        this.employee = employee;
        this.claim = claim;
        this.storage = storage;
        this.form = form;
        this.listener = updateListener;
        this.currentStatus = claim.getStatus();
           
        form.setData(claim);       
        form.setRanksList(claim.getCategory(), Claim.Rank.values());  
        form.addActionListeners(new ComboListener(), new ConfirmListener(), new DeclineListener(), new SaveListener());
        if(employee.getRank()!= Employee.Rank.High)
            form.setDecisionState(false);
        form.updateTable(storage.getClaimsByCustomerId(claim.getCustomerId()));
    }
    /*
    private void updateClaim(boolean choice1)
    {
        switch(claim.getStatus())
        {
            case UnRanked:
                claim.rank(choice1 ? Claim.Rank.Complex : Claim.Rank.Simple);
                break;
            case Ranked:
                claim.setStatus(choice1 ? Claim.Status.Confirmed : Claim.Status.Declined);
                break;
            default:
                return;
        }
        
        storage.updateClaim(claim);
        if(listener != null)
        {
            listener.actionPerformed(new ActionEvent(this, 0, null));
        }
        
    }
     * 

    
    
    private class Choice1Listener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateClaim(true);
            form.dispose();
        }
    }
    
    private class Choice2Listener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateClaim(false);
            form.dispose();
        }
               
    }
     *      */

    
    private class ConfirmListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentStatus = Claim.Status.Confirmed;
            form.setStatus(Claim.Status.Confirmed.toString());
        }
    }
    
    private class DeclineListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentStatus = Claim.Status.Declined;
            form.setStatus(Claim.Status.Declined.toString());
        }
    }
    
    private class ComboListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(form.getRank()!=Claim.Rank.Undefined)
                form.setStatus(Claim.Status.Ranked.toString());
            else
                form.setStatus(Claim.Status.UnRanked.toString());
        }
    }
    
    private class SaveListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            claim.rank(form.getRank());
            claim.setStatus(currentStatus);
            
            storage.updateClaim(claim);
            if(listener != null)
            {
                listener.actionPerformed(new ActionEvent(this, 0, null));
            }
            form.updateTable(storage.getClaimsByCustomerId(claim.getCustomerId()));
            form.showNotification();
            if(currentStatus == Claim.Status.Confirmed)
                 AutomaticCustomerEmulator.sendForm();
            storage.addPayment(claim.getCustomerId(), claim.getId());
                
            
        }
    }
    
    
    
}
