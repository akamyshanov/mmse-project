
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sanyasn
 */
public class SendClaimFormHandler {
    private SendClaimForm view;
    private StorageBroker storage;
    
    public SendClaimFormHandler(SendClaimForm form, StorageBroker db){
        this.view = form;
        this.storage = db;
        
        view.addButtonActionListener(new SubmitListener());
    }
    
    
    private class SubmitListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            int customerId = view.getCustomerId();
            int cost = view.getDamageCost();
            
            //do something with storage           
        }
    }
    
    
    
}

