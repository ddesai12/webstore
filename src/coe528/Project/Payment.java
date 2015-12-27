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
public abstract class Payment {

    private double total;
    String username;

    void ApplyDiscount() {
        this.total = this.total - (0.1 * this.total);
    }

    public void set_total() {
        total = cart.getTotal();
    }

    public double get_total()
    {
        return total;
    }
    
    public void print_receipt() {
        cart.getInstance().view_cart();
    }

    public abstract void MakePayment(int lineno) ;

    @Override
    public String toString() {
        return ("Your TOTAL is :" + " " + this.total);
    }

}
