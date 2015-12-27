/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Akash
 */

public class Ecommerce {

    /**
     * @param args the command line arguments
     */
    static login l1 = null, l2 = null;
    static customer c;

    static File f;
    static FileWriter fw;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //login information present    
        String option = "0";
        String exitcommand;
        Scanner s = new Scanner(System.in);
                       
        System.out.println("Welcome to the Online Store");
        System.out.println("****************************************************************************");
        System.out.println("Enter the number beside your option below: and enter exit anytime to exit the store :(");
        System.out.println("");
        System.out.println("1.Login as customer\n2.Login as manager\n3.Guest Checkout\n4.Register\n ");
        option = s.next();
        boolean first=true;
        facade f=new facade();
        f.create_categories();
        c = new customer();
        l2 = new login();
        l1 = new login();
        while (!(option.equalsIgnoreCase("exit"))) {
            switch (option) {
                case "1":                      
                    l2.enter_username();
                    l2.enter_password();
                    l2.role();                                        
                    break;
                case "2":                    
                    l1.musername();
                    l1.mpassword();
                    l1.role();
                    break;
                case "3":                                                  
                    c.customer_operations();
                    break;
                case "4":
                    s=new Scanner(System.in);
                    String username,password;
                    System.out.println("Enter a username :\t");
                    username=s.nextLine();
                    System.out.println("Enter password: \t");
                    password=s.nextLine();
               
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("username.txt", true)))) {
                    out.println(username);
                    out.flush();
                    } catch (IOException e) {
                    System.out.print("Unable to open file");
                    }
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("password.txt", true)))) {
                    out.println(password);
                    out.flush();
                    } catch (IOException e) {
                    System.out.print("Unable to open file");
                    }
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("accounts.txt", true)))) {
                    out.println(1000+"");
                    out.flush();
                    } catch (IOException e) {
                    System.out.print("Unable to open file");
                    }                    
                    option="3";
                    break;
                default:
                    System.out.println("Enter a legitimate option");System.out.println("Enter the number beside your option below: and enter exit anytime to exit the store :(");
                    System.out.println("");
                    System.out.println("1.Login as customer\n2.Login as manager\n3.Guest Checkout\n4.Register\n ");
                      option = s.next();break;  
            }
        }                
    }
}


      
