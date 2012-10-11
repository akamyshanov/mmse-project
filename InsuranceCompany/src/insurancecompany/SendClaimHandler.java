
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
public class SendClaimHandler {
    private SendClaimForm form;
    private StorageBroker storage;
    
    public SendClaimHandler(SendClaimForm form, StorageBroker db){
        this.form = form;
        this.storage = db;
        this.form.sendActionListener(new SubmitListener());
    }
    
    
    private class SubmitListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Boolean added = storage.addClaim(form.getCustomerId(), form.getPassword(), form.getDamageCost(), form.getDescription());
            form.answerReceived(added);          
        }
    }
    
    
    
}

