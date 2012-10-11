/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrew
 */
public class EmployeeHandler {
    
        EmployeeForm form;
        StorageBroker storage;
        
    public EmployeeHandler(EmployeeForm form, StorageBroker storage) {
        this.form = form;
        this.storage = storage;
        form.addGetClaimsListener(new GetClaimsListener());
        
    }
    
    private class GetClaimsListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            form.claimsReceived(storage.getClaims(form.getId(), form.getPassword()));        
        }
    }
}
