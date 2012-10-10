/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

/**
 *
 * @author Sanyasn
 */
public class InsuranceCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        StorageBroker database = new StorageBroker();

        
        MainForm form = new MainForm();
        MainHandler handler = new MainHandler(form, new StorageBroker());
        form.setVisible(true);
    }
}
