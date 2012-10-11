/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EmployeeLoginFormHandler {
    private EmployeeLoginForm form;
    private StorageBroker storage;
    
    public EmployeeLoginFormHandler(EmployeeLoginForm form, StorageBroker db){
        this.form = form;
        this.storage = db;
        this.form.setActionListener(new SubmitListener());
    }
    
    
    private class SubmitListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(storage.authenticateEmployee(form.getLogin(), form.getPassword()))
            {
                form.dispose();
                EmployeeForm eForm = new EmployeeForm();
                new EmployeeHandler(eForm, storage);
                eForm.setVisible(true);
            }
            else
            {
                form.setMessage("Authentication failed");
            }
        }
    }
    
    
    
}

