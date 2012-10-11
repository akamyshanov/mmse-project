/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Sanyasn
 */
public class FinancialFormHandler {
    private FinacialForm form;
    private StorageBroker storage;
    
    public FinancialFormHandler(Employee emp, FinacialForm form, StorageBroker db){
        this.form = form;
        this.storage = db;
        updatePayments();
    }
    
    private void updatePayments() {
        ArrayList<Payment> payments = storage.getPayments();
        form.updateTable(payments);
    }
    
    private class payListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do something
        }
    }
    
}
