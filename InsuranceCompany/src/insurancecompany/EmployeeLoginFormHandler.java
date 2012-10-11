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
            Employee emp = storage.getEmployee(form.getLogin(), form.getPassword());
            
            if(emp == null)
            {
                form.setMessage("Authentication failed");
                return;
            }
            
            form.dispose();
            
            switch(emp.getDepartment())
            {
                case CarDamage:
                    EmployeeForm eForm = new EmployeeForm();
                    new EmployeeHandler(emp, eForm, storage);
                    eForm.setVisible(true);
                    break;
                case Finance:
                    break;
            }
        }
    }
    
    
    
}

