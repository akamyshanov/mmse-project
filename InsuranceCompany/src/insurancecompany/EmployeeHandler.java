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
 * @author Andrew
 */
public class EmployeeHandler {
    
        EmployeeForm form;
        StorageBroker storage;
        
    public EmployeeHandler(Employee employee, EmployeeForm form, StorageBroker storage) {
        this.form = form;
        this.storage = storage;

        form.claimsReceived(storage.getClaims(employee));
        
    }
    
}
