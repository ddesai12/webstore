/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akash
 */
public class accountpayment extends Payment {

    @Override
    public void MakePayment(int lineno) {
        
        ArrayList<String> accounts=new ArrayList<>();
        
        String line="";
        int number=1;
        double oldamount,newamount=0,price;
       // System.out.println("User infromantion is present at :"+ lineno);
        
            BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("accounts.txt")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(accountpayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while((line=br.readLine())!=null)
            {
                accounts.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(accountpayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        line=(String) accounts.get(lineno-1);
        oldamount=Double.parseDouble(line);
        System.out.println(oldamount+"");
        price=super.get_total();
        if(price>oldamount)
            System.out.print("You Are Broke");
        if(price==0.0)
            System.out.println("You havent bought anything");
        else if(price<oldamount)
        {
            newamount=oldamount-price;
            System.out.println("Your new Balance is: "+ newamount+ "\n");
        }
               
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(accountpayment.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        accounts.set(lineno-1, newamount+"");
             
             
                   int flag = 0;
            try {
                PrintWriter writer = new PrintWriter("accounts.txt");
                writer.print("");
                writer.close();
              
                File f = new File("accounts.txt");
                FileWriter fr = new FileWriter(f, false);
                BufferedWriter bw;
                bw = new BufferedWriter(fr);
                
                for (String s: accounts) 
                {
                    //System.out.println(s);
                    bw.write(s);
                    bw.newLine();
                }
                bw.close();
            }
            catch (IOException ex) {
                Logger.getLogger(accountpayment.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    
}
