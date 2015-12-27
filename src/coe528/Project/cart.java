/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Akash
 */
public class cart {

    // Required attributes 
    public static ArrayList cart = new ArrayList<>();

    private Categories c;
    private Scanner s;

    //implementation of singleton pattern begins
    private static cart one_cart;

    private cart() {
        System.out.println("\nYour Shopping Cart is created");
    }

    public void add_to_cart(Categories c) {
        s = new Scanner(System.in);
        String proname;
        
        c.viewproducts();
        System.out.println("\nEnter name of desired product");
        proname = s.nextLine();
        Object o = c.getcartproduct(proname);
        if (o != null) {
            cart.add(o);
        } else {
            System.out.println("OUT OF STOCK");
        }
        if (cart != null && o != null) {
            System.out.println("\n\nYour cart looks like this");
            view_cart();
        }

    }
    
    public void addtocartfromsearch(Categories c, String pro){
        Object o = c.getcartproduct(pro);
        if (o != null) {
            cart.add(o);
        } else {
            System.out.println("OUT OF STOCK");
        }
        if (cart != null && o != null) {
            System.out.println("\n\nYour cart looks like this");
            view_cart();
        }

    }

    public void view_cart() {
        if (cart != null) {
            try {
                cart.stream().forEach((o) -> {
                    System.out.println(o.toString());
                });
            } catch (NullPointerException n) {
                System.out.println("NOT IN STOCK\n");
            }
        } else {
            System.out.println("\nYour Cart is Empty, Try again");
        }
    }

    public void delete_from_cart(Categories c) {
        int flag = 1;
        String proname;
        int del;
        String delete;
        s = new Scanner(System.in);
        System.out.println("Your current cart looks like this:\n");
        view_cart();
        System.out.println("\nEnter Product Name to delete");
        delete = s.nextLine();
        Object o = c.getcartproduct(delete);
        if (o == null) {
            System.out.println("INVALID");
        } else {

            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).equals(o) == true) {
                    cart.remove(i);
                    flag = 0;
                    break;

                }
            }
        }
        
        if (flag == 0){
            c.deleteop(delete);
        }

        if (cart != null && o != null) {
            System.out.println("\n\nYour Updated cart looks like this");
            System.out.println("");
            view_cart();
        }
    }

    public static cart getInstance() {
        if (one_cart == null) {
            one_cart = new cart();
        }
        return one_cart;
    }

    public static double getTotal() {
        String[] split;
        double p;
        double total = 0.0;
        if (cart != null) {
            for (Object c : cart) {
                String splitted = c.toString();
                //System.out.print(splitted);
                split = splitted.split(Pattern.quote(" "));
                p = Double.parseDouble(split[1]);
                total = total + p;
            }
        }
        return total;
    }
}
