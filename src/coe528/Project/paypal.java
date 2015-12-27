/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Akash
 */
public class paypal extends Payment {

    private Scanner s;

    @Override
    public void MakePayment(int lineno) {
        s = new Scanner(System.in);
        System.out.println("Enter your PayPal EmailAddress ");
        String cardno = s.nextLine();
        System.out.println("Enter the password");
        BigInteger CVV = s.nextBigInteger();
        System.out.println("PayaPal Login Verified" + " " + cardno + ":" + "Payment secured");
        System.out.println("Thanks for Shopping with us");
    }

}
