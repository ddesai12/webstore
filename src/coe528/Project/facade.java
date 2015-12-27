/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import static java.lang.System.exit;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Akash
 */
public class facade {

    private final Categories a, b, c;
    public Scanner s;
    private Payment p;

    public facade() {

        a = new Electronics("a", 22, 11);
        b = new Clothing("a", 22, 11);
        c = new Sports("a", 22, 11);
        // this.create_categories();
    }

    //customer related functions
    public void create_categories() {
        a.products();
        b.products();
        c.products();
    }

    public void manageroperations() {
        int choice, q;
        String name;
        double price;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number before what would you like to do:\n1.Add Product\n2.Remove Product\n3.Modify Quantity\n4.Modify Price\n5.Exit");
        choice = s.nextInt();
        while (choice > 0) {
            switch (choice) {
                case 1:
                    System.out.println("In which category: :\n1.Electronics\n2.Sports\n3.Clothing");
                    choice = s.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the product name");
                            name = s.next();

                            System.out.println("Enter the price of the product");
                            price = s.nextDouble();
                            System.out.println("Enter the quantity");
                            q = s.nextInt();
                            a.addProduct(name, price, q);
                            break;

                        case 2:
                            System.out.println("Enter the product name");
                            name = s.next();
                            System.out.println("Enter the price of the product");
                            price = s.nextDouble();
                            System.out.println("Enter the quantity");
                            q = s.nextInt();
                            c.addProduct(name, price, q);
                            break;

                        case 3:
                            System.out.println("Enter the product name");
                            name = s.next();
                            System.out.println("Enter the price of the product");
                            price = s.nextDouble();
                            System.out.println("Enter the quantity");
                            q = s.nextInt();
                            b.addProduct(name, price, q);
                            break;
                        default:
                            System.out.println("\nWrong choice entered");

                    }

                    break;
                case 2:
                    System.out.println("In which category: :\n1.Electronics\n2.Sports\n3.Clothing");
                    choice = s.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the name of the product to delete");
                            name = s.next();
                            a.removeProduct(name);
                            break;
                        default:
                            System.out.println("\nWrong choice entered");
                    }
                    break;
                case 3:
                    System.out.println("In which category: :\n1.Electronics\n2.Sports\n3.Clothing");
                    choice = s.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the name of the product to change its quantity");
                            name = s.next();
                            System.out.println("Enter the new quantity");
                            q = s.nextInt();
                            a.modifyquantity(name, q);
                            break;
                        default:
                            System.out.println("\nWrong choice entered");
                    }
                    break;
                case 4:
                    System.out.println("In which category: :\n1.Electronics\n2.Sports\n3.Clothing");
                    choice = s.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the name of the product to change its price");
                            name = s.next();
                            System.out.println("Enter the new price");
                            price = s.nextInt();
                            a.modifyprice(name, price);
                            break;
                        default:
                            System.out.println("\nWrong choice entered");
                    }
                    break;
                default:
                    exit(0);

            }
            System.out.println("What would you like to do  :\n1.Add Product\n2.Remove Product\n3.Modify Quantity\n4.Modify Price\n5.Logout");
            choice = s.nextInt();
        }
    }

    public void search_products() {
        int choice;
        s = new Scanner(System.in);
        System.out.println("Enter Category :\n1.Electronics\n2.Clothing\n3.Sports");
        choice = s.nextInt();

        switch (choice) {
            case 1:
                a.viewproducts();
                break;
            case 2:
                b.viewproducts();
                break;
            case 3:
                c.viewproducts();
                break;
            default:
                System.out.println("\nWrong choice entered");
        }

    }

    public boolean customer_operations() {
        s = new Scanner(System.in);
        cart customercart = cart.getInstance();
        System.out.println("Please enter the number beside option you would like to pick\n");
        System.out.println("1.View Your Cart\n2.Add a Product to your cart\n3.Delete From your cart\n4.Make Payment\n5.Display Products");
        try {
            switch (s.nextInt()) {
                case 1:
                    try {
                        if (cart.cart.get(0) == null) {
                            System.out.println();
                        } else {
                            customercart.view_cart();
                        }
                        break;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Your cart is EMPTY");
                    }
                    break;
                case 2:
                    System.out.println("\nChoose category:\n1.Electronic\n2.Clothing\n3.Sports");
                    switch (s.nextInt()) {
                        case 1:
                            System.out.println("Here is the list of Electronic Products");

                            System.out.println(" ");
                            customercart.add_to_cart(a);
                            break;
                        case 2:
                            System.out.println("Here is the list of Clothing Products");

                            System.out.println(" ");
                            customercart.add_to_cart(b);
                            break;
                        case 3:
                            System.out.println("Here is the list of Sports Products");

                            System.out.println(" ");
                            customercart.add_to_cart(c);
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    try{
                    if(cart.cart.get(0)== null)
                        System.out.println("Why are you deleting from an empty cart?");
                    else {
                        System.out.println("\nChoose category:\n1.Electronic\n2.Clothing\n3.Sports");
                        
                        switch (s.nextInt()) {
                            case 1:
                                customercart.delete_from_cart(a);
                                break;
                            case 2:
                                customercart.delete_from_cart(b);
                                break;
                            case 3:
                                customercart.delete_from_cart(c);
                                break;
                            default:
                                break;
                        }
                    }
                    }
                   catch(IndexOutOfBoundsException e)
                   {
                       System.out.println("Why are you deleting from an empty cart?");
                   }
                    break;
                case 4:
                    return true;

                case 5:
                    int choice;
                    s = new Scanner(System.in);
                    System.out.println("Enter Category :\n1.Electronics\n2.Clothing\n3.Sports");
                    choice = s.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("");
                            a.viewproducts();
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println("");
                            b.viewproducts();
                            System.out.println("");
                            break;
                        case 3:
                            System.out.println("");
                            c.viewproducts();
                            System.out.println("");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("\nWrong choice entered");
            }
            return false;
        } catch (InputMismatchException e) {
            exit(0);
        }
        return false;
    }

    public void customer_pay() {

        s = new Scanner(System.in);
        System.out.println("Enter Payment method-\n1.Creditcard\n2.Paypal\n");
        if (s.nextInt() == 1) {
            p = new creditcard();
        } else {
            p = new paypal();
        }
        p.set_total();
        p.MakePayment(0);
        //p.print_receipt();
        System.out.println(p.toString());
        //p.toString();
        Electronics.updatefile();
        Sports.updatefile();
        Clothing.updatefile();
        exit(0);
    }

    public void registered_customer_pay(int lineno) {
        s = new Scanner(System.in);
        System.out.println("Enter Payment method-\n1.Creditcard\n2.Paypal\n3.Your Account");
        switch (s.nextInt())
            {
            case 1:
                p = new creditcard();break;
            case 2:
                p = new paypal();break;
            case 3:
                p=new accountpayment();break;
            }
        p.set_total();
        p.ApplyDiscount();
        p.MakePayment(lineno);
        System.out.println(p.toString());
        //p.print_receipt();     
        Electronics.updatefile();
        Clothing.updatefile();
        Sports.updatefile();
        exit(0);
    }

}
