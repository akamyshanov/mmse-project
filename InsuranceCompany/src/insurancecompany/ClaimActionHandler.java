/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrew
 */
public class ClaimActionHandler {

    Employee employee;
    Claim claim;
    StorageBroker storage;
    ClaimActionForm form;
    ActionListener listener;

    public ClaimActionHandler(Employee employee, Claim claim, StorageBroker storage, ClaimActionForm form, ActionListener updateListener) {
        this.employee = employee;
        this.claim = claim;
        this.storage = storage;
        this.form = form;
        this.listener = updateListener;

        String act1, act2;

        switch (claim.getStatus()) {
            case UnRanked:
                act1 = "Rank HIGH";
                act2 = "Rank LOW";
                break;
            case Ranked:
                act1 = "Accept";
                act2 = "Decline";
                break;
            default:
                return;
        }
        form.setData(claim, act1, act2);
        form.addActionListeners(new Choice1Listener(), new Choice2Listener());

        form.updateTable(storage.getClaimsByCustomerId(claim.getCustomerId()));
    }

    private void updateClaim(boolean choice1) {
        switch (claim.getStatus()) {
            case UnRanked:
                claim.rank(choice1 ? Claim.Rank.Complex : Claim.Rank.Simple);
                JOptionPane.showMessageDialog(form, "The claim has been ranked " + (choice1 ? Claim.Rank.Complex : Claim.Rank.Simple));
                break;
            case Ranked:
                claim.setStatus(choice1 ? Claim.Status.Confirmed : Claim.Status.Declined);
                if(choice1) {
                    String billingInfo = AutomaticCustomerEmulator.sendForm();
                    storage.addPayment(claim.getCustomerId(), claim.getId(), claim.getDamageCost(), billingInfo);                    
                }
                else
                    AutomaticCustomerEmulator.sendMail("Your claim was denied");
                JOptionPane.showMessageDialog(form, "The claim has been " + (choice1 ? "confirmed" : "declined"));
                break;
            default:
                return;
        }

        storage.updateClaim(claim);
        if (listener != null) {
            listener.actionPerformed(new ActionEvent(this, 0, null));
        }
    }

    private class Choice1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateClaim(true);
            form.dispose();
        }
    }

    private class Choice2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateClaim(false);
            form.dispose();
        }
    }
}
