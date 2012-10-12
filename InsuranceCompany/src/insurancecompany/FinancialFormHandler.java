/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sanyasn
 */
public class FinancialFormHandler {
    private FinacialForm form;
    private StorageBroker storage;
    private ArrayList<Payment> showedPayments;
    
    public FinancialFormHandler(Employee emp, FinacialForm form, StorageBroker db){
        this.form = form;
        this.storage = db;
        this.showedPayments = new ArrayList<Payment>();
        form.addActionListeners(new PayListener());
        updatePayments();
    }
    
    private void updatePayments() {
        showedPayments.clear();
        showedPayments.addAll(storage.getPayments());
        form.updateTable(showedPayments);
    }
    
    private class PayListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Payment p : showedPayments)
                p.setStatus(Payment.Status.Finished);
            updatePayments();
        }
    }
    
}
