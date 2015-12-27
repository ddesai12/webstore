/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seanan
 */
public class Clothing implements Categories {

    private String product, name;
    private double price;
    private int quantity;

    private static List<Clothing> clothings = new ArrayList<>();

    public Clothing(String name, double price, int q) {
        this.name = name;
        this.price = price;
        this.quantity = q;

    }

    @Override
    public List products() {

        int i = 0;

        double p;
        int q;
        String[] details;
        try {
            File f = new File("clothing.txt");
            //Scanner sc = new Scanner(f);

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String abc;
            while ((abc = br.readLine()) != null) {
                details = abc.split(":");
                String name = details[0];
                p = Double.parseDouble(details[1]);
                q = Integer.parseInt(details[2]);
                Clothing c = new Clothing(name, p, q);
                clothings.add(c);
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            // System.out.println("EEEEEEEEEE");
            //e.printStackTrace();
        }
        return clothings;
    }

    public void searchproducts(String input) {
        for (Clothing c : clothings) {
            if (c.getName().contentEquals(input) == true) {
                System.out.println(c.toString());
                break;
            }

        }

    }

    @Override
    public void addProduct(String name, double price, int quantity) {
        int flag = 0;
        double p;
        int q;
        for (int i = 0; i < clothings.size(); i++) {
            if (clothings.get(i).name.contentEquals(name)) {
                flag = 1;
            }
        }

        if (flag == 0) {
            FileWriter fr = null;

            Clothing c = new Clothing(name, price, quantity);
            clothings.add(c);
            System.out.println("The product was successfully added");
            //PrintWriter writer = new PrintWriter("clothings.txt");
            //writer.print("");
            //writer.close();
            // File f = new File("clothings.txt");
            //fr = new FileWriter(f);
            //BufferedWriter br = new BufferedWriter(fr);
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clothing.txt", true)))) {
                p = price;
                q = quantity;
                out.print(name + ":" + p + ":" + q);
            } catch (IOException e) {
            }

        } else {
            System.out.println("Name already exists");
        }
    }

    public Clothing deleteop(String proname) {
        Clothing spo;
        for (int i = 0; i < clothings.size(); i++) {
            if (clothings.get(i).name.equals(proname)) {
                spo = clothings.get(i);
                // Clothing.clothings.remove(i);
                // System.out.print("-------------->"+Clothing.clothings.get(i).quantity);
                Clothing.clothings.get(i).quantity++;
                //System.out.print("-------------->"+Clothing.clothings.get(i).quantity);                
                return spo;
            }

        }
        return null;
    }

    @Override
    public void removeProduct(String input) {
        int flag = 0;
        for (int i = 0; i < clothings.size(); i++) {
            if (clothings.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                clothings.remove(i);
                System.out.println("was removed successfully");
                try {
                    PrintWriter writer = new PrintWriter("clothings.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("clothings.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (int j = 0; j < clothings.size(); j++) {
                        br.write(clothings.get(j).getName() + ":" + clothings.get(j).getPrice() + ":" + clothings.get(j).getQuantity());
                        br.newLine();
                    }
                    br.close();
                } catch (Exception e) {

                }
                break;
            }
        }
        if (flag == 0) {
            System.out.println("No such product exist");
        }

    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {

        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double returnPrice(String input) {
        for (int i = 0; i <= clothings.size(); i++) {
            if (clothings.get(i).getName().equalsIgnoreCase(input) == true) {

                return (clothings.get(i).getPrice());

            }
        }
        return 0;

    }

    @Override
    public void modifyprice(String input, double price) {

        int flag = 0;
        for (int i = 0; i <= clothings.size(); i++) {
            if (clothings.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                clothings.get(i).setPrice(price);
                try {
                    PrintWriter writer = new PrintWriter("clothings.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("clothings.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (int j = 0; j < clothings.size(); j++) {
                        br.write(clothings.get(j).getName() + ":" + clothings.get(j).getPrice() + ":" + clothings.get(j).getQuantity());
                        br.newLine();
                    }
                    br.close();
                } catch (Exception e) {

                }
                break;
            }
        }

        if (flag == 0) {
            System.out.println("No such product exist");
        }
    }

    @Override
    public void modifyquantity(String input, int quantity) {
        int flag = 0;
        for (int i = 0; i <= clothings.size(); i++) {
            if (clothings.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                clothings.get(i).setQuantity(quantity);
                try {
                    PrintWriter writer = new PrintWriter("clothings.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("clothings.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (int j = 0; j < clothings.size(); j++) {
                        br.write(clothings.get(j).getName() + ":" + clothings.get(j).getPrice() + ":" + clothings.get(j).getQuantity());
                        br.newLine();
                    }
                    br.close();
                } catch (Exception e) {

                }
                break;
            }
        }

        if (flag == 0) {
            System.out.println("No such product exist");
        }
    }

    @Override
    public Clothing getcartproduct(String proname) {
        Clothing spo;
        for (int i = 0; i < clothings.size(); i++) {
            if (clothings.get(i).name.equals(proname)&& clothings.get(i).quantity != 0) {
                
                spo = clothings.get(i);
                // Clothing.clothings.remove(i);
                // System.out.print("-------------->"+Clothing.clothings.get(i).quantity);
                Clothing.clothings.get(i).quantity--;
                //System.out.print("-------------->"+Clothing.clothings.get(i).quantity);                
                return spo;
            }

        }
        return null;
    }

    public static void updatefile() {
        for (int i = 0; i < clothings.size(); i++) {
            try {
                PrintWriter writer = new PrintWriter("clothings.txt");
                writer.print("");
                writer.close();
                File f = new File("clothings.txt");
                FileWriter fr = new FileWriter(f, false);
                BufferedWriter br = new BufferedWriter(fr);
                for (int j = 0; j < clothings.size(); j++) {
                    br.write(clothings.get(j).getName() + ":" + clothings.get(j).getPrice() + ":" + clothings.get(j).getQuantity());
                    br.newLine();
                }
                br.close();
                // br.flush();
            } catch (Exception e) {

            }

        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.price; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewproducts() {
        for (Clothing e : clothings) {
            System.out.println(e.name + " " + e.price + " " + e.quantity);
        }

    }
}
