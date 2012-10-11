/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrew
 */
public class EmployeeHandler {

    EmployeeForm form;
    StorageBroker storage;
    Employee employee;
    HashMap<Integer, Claim> claims = new HashMap<Integer, Claim>();

    public EmployeeHandler(Employee employee, EmployeeForm form, StorageBroker storage) {
        this.employee = employee;
        this.form = form;
        this.storage = storage;


        updateClaims();

        form.addActionListener(new ClaimListener());

    }

    private void updateClaims() {
        claims.clear();
        for (Claim c : storage.getClaims(employee)) {
            claims.put(c.getId(), c);
        }
        form.claimsReceived(this.claims.values());
    }

    private class ClaimListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Claim claim = claims.get(e.getID());
            if (claim == null) {
                return;
            }

            ClaimActionForm form = new ClaimActionForm();
            new ClaimActionHandler(employee, claim, storage, form, new UpdateListener());
            form.setVisible(true);
        }
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateClaims();
        }
    }
}
