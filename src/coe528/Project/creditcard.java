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
public class creditcard extends Payment {

    private Scanner s;

    @Override
    public void MakePayment(int lineno) {
        s = new Scanner(System.in);
        try {
            System.out.println("Enter card number");
            BigInteger cardno = s.nextBigInteger();
            System.out.println("Enter security code");
            int CVV = s.nextInt();
            System.out.println("Credit card checked" + " " + cardno + ":" + CVV + ", Payment aquired");
            System.out.println("Thank you for shopping with us");
        } catch (Exception e) {
            System.out.println("Please check your credit card information.");
            this.MakePayment(lineno);
        }
    }
}
