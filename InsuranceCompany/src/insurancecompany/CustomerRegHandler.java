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
public class CustomerRegHandler {
    CustomerRegForm form;
    StorageBroker storage;

    public CustomerRegHandler(CustomerRegForm form, StorageBroker storage) {
        this.form = form;
        this.storage = storage;
        form.addRegListener(new CustomerRegListener());
        
    }
    
    private class CustomerRegListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            form.idReceived(storage.addCustomer(
                    form.getCustomerName(),
                    form.getCustomerSurname(),
                    form.getEmail(),
                    form.getPassword(),
                    form.getCarModel(),
                    form.getCarPrice()));    
        }
    }
    
}
