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
public class MainHandler {
    private MainForm form;
    private StorageBroker storage;
    public MainHandler(MainForm form, StorageBroker storage)
    {
        this.form = form;
        this.storage = storage;
        form.addButtonActionListeners(new CustomerRegFormListener(), new SendClaimFormListener(), new EmployeeFormListener());
    }
    
    private class CustomerRegFormListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            CustomerRegForm form = new CustomerRegForm();
            form.setVisible(true);
            
            System.out.println("CustomerRegFormListener");
            //do something with storage           
        }
    }
    
    private class SendClaimFormListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            SendClaimForm form = new SendClaimForm();
            form.setVisible(true);
            
            System.out.println("SendClaimFormListener");
            
            //do something with storage           
        }
    }
    
    private class EmployeeFormListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            EmployeeForm form = new EmployeeForm();
            form.setVisible(true);

            
            System.out.println("EmployeeFormListener");
            //do something with storage           
        }
    }
    
}
