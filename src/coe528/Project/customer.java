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
public class customer {

    private facade f;
    static boolean done;

    public customer() {
        f = new facade();
        done = false;
    }

    public void customer_operations() {
        done = f.customer_operations();
        if (done == true) {
            f.customer_pay();
        }
    }

}
