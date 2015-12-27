/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Akash
 */
public class login {

    static Scanner s;
    static File f1, f2;
    static FileReader fr;
    static BufferedReader br;
    static String username, password, line;
    manager m;
    static boolean u, p, check, done;
    static int number;

    public login() {
        username = "";
        password = "";
        f1 = new File("username.txt");
        f2 = new File("password.txt");
        u = false;
        p = false;
        done = false;
    }

    public void musername() {
        s = new Scanner(System.in);
        System.out.println("\nEnter username");
        username = s.nextLine();
        if ("admin".equals(username)) {
            System.out.println("Username,found. Please enter password");
            u = true;
        }

        if (u == false) {
            System.out.println("Wrong Username, try again...");
            this.musername();
        }
    }

    public void mpassword() {
        if (u == true) {
            s = new Scanner(System.in);
            System.out.println("\nEnter password");
            password = s.nextLine();
            if ("admin".equals(password)) {
                p = true;
            }
        }

        if (p == false) {
            System.out.println("Wrong Password, try again...");
            this.mpassword();
        }

    }

    public void enter_username() throws FileNotFoundException, IOException {
        int flag = 0;
        int linenumber = 0;
        s = new Scanner(System.in);
        System.out.println("\nEnter username");
        username = s.nextLine();
        fr = new FileReader(f1);
        br = new BufferedReader(fr);
        if ("admin".equalsIgnoreCase(username)) {
            System.out.println("Sorry, you cant login as a manager");
            flag = 1;
            this.enter_username();
        } else if (flag == 0) {
            
            while ((line = br.readLine()) != null) {
                linenumber++;
                if (line.equals(username)) {
                    System.out.println("\nUsername found, now checking password...");
                    u = true;
                    number = linenumber;
                }
                System.out.println("");
            }
            br.close();
        }
        if (u == false) {
            System.out.println("Incorrect Username");
            this.enter_username();
        }

    
    }

    public void enter_password() throws FileNotFoundException, IOException {
        if (u == true) {
            s = new Scanner(System.in);
            System.out.println("Enter password");
            password = s.next();
            fr = new FileReader(f2);
            br = new BufferedReader(fr);         
            int linenum = 0;
            while ((line = br.readLine()) != null) {
                linenum++;
                if (line.equals(password) && linenum == number) {
                    System.out.println("\nPassword checked, now logging in...");
                    p = true;
                    break;
                }
                System.out.println("");
            }
            
            if (p == false) {

                System.out.println("Incorrect Password");
                this.enter_password();
            }
            
        }
    }

    public boolean role() {
        if ("admin".equals(username) && "admin".equals(password)) {
            System.out.println("\nLogged in as manager");
            m = new manager();
            m.manageroperations();

        } else if (u == true && p == true) {
            System.out.println("\nLogged in as Registered Customer");
            registered_customer rc = new registered_customer();
            //facade created
            
            
            rc.registered_customer_operations(number);
        } else {
            System.out.println("\n\nTRY AGAIN");
        }
        return true;
    }

}
