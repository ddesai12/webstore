/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

/**
 *
 * @author Akash
 */
public class registered_customer {

    private facade f;
    private boolean done;

    public registered_customer() {
        f = new facade();
        //f.create_categories();
        done = false;

    }

    public void registered_customer_operations(int lineno) {
        while (done == false) {
            done = f.customer_operations();
        }
        f.registered_customer_pay(lineno);
    }

}
