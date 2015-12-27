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
 */
public class Electronics implements Categories {

    public String product, name;
    public double price;
    public int quantity;

    private static List<Electronics> electronics = new ArrayList<>();

    public Electronics(String name, double price, int q) {
        this.name = name;
        this.price = price;
        this.quantity = q;

    }

    @Override
    public List products() {
        //adds the file items to the array list called electronics
        int i = 0;

        double p;
        int q;
        String[] details;
        try {
            File f = new File("electronics.txt");
            //Scanner sc = new Scanner(f);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String abc;
            while ((abc = br.readLine()) != null) {
                details = abc.split(":");
                String name = details[0];
                p = Double.parseDouble(details[1]);
                q = Integer.parseInt(details[2]);
                Electronics electronic = new Electronics(name, p, q);
                electronics.add(electronic);

            }
            br.close();
            fr.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("ERROR");
        }
        return electronics;
    }

    public void searchproducts(String input) {
        //System.out.println("\nThe available products are:");
        for (Electronics electronic : electronics) {
            if (electronic.getName().contentEquals(input) == true) {
                System.out.println(electronic.toString());
                break;
            }

        }

    }

    @Override
    public void addProduct(String name, double price, int quantity) {
        int flag = 0;
        double p;
        int q;
        for (Electronics electronic : electronics) {
            if (electronic.name.contentEquals(name)) {
                flag = 1;
            }
        }

        if (flag == 0) {
            FileWriter fr = null;
            Electronics elec = new Electronics(name, price, quantity);
            electronics.add(elec);
            //product added to the arraylist
            System.out.println("The product was successfully added");
            //PrintWriter writer = new PrintWriter("electronics.txt");
            //writer.print("");
            //writer.close();
            // File f = new File("electronics.txt");
            //fr = new FileWriter(f);
            //BufferedWriter br = new BufferedWriter(fr);
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("electronics.txt", true)))) {
                p = price;
                q = quantity;
                out.print(name + ":" + p + ":" + q);
            } catch (IOException e) {
            }

        } else {
            System.out.println(" Product Name already exists");
        }
    }

    @Override
    public void removeProduct(String input) {
        int flag = 0;
        for (int i = 0; i < electronics.size(); i++) {
            if (electronics.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                electronics.remove(i);
                System.out.println("was removed successfully");
                try {
                    PrintWriter writer = new PrintWriter("electronics.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("electronics.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (Electronics electronic : electronics) {
                        br.write(electronic.getName() + ":" + electronic.getPrice() + ":" + electronic.getQuantity());
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

    private void setProduct(String product) {
        this.product = product;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public String getName() {
        return name;
    }

    //use this method for getting the price 
    public double returnPrice(String input) {
        for (int i = 0; i <= electronics.size(); i++) {
            if (electronics.get(i).getName().equalsIgnoreCase(input) == true) {

                return (electronics.get(i).getPrice());

            }
        }
        return 0;

    }

    public double getPrice() {

        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Electronics> getElectronics() {
        return electronics;
    }

    public void setElectronics(List<Electronics> electronics) {
        Electronics.electronics = electronics;
    }

    @Override
    public void modifyprice(String input, double price) {

        int flag = 0;
        for (int i = 0; i <= electronics.size(); i++) {
            if (electronics.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                electronics.get(i).setPrice(price);
                try {
                    PrintWriter writer = new PrintWriter("electronics.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("electronics.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (Electronics electronic : electronics) {
                        br.write(electronic.getName() + ":" + electronic.getPrice() + ":" + electronic.getQuantity());
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
        for (int i = 0; i <= electronics.size(); i++) {
            if (electronics.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                electronics.get(i).setQuantity(quantity);
                try {
                    PrintWriter writer = new PrintWriter("electronics.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("electronics.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (Electronics electronic : electronics) {
                        br.write(electronic.getName() + ":" + electronic.getPrice() + ":" + electronic.getQuantity());
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
    public Electronics getcartproduct(String proname) {
        Electronics e;
        for (int i = 0; i < electronics.size(); i++) {
            if (electronics.get(i).getName().equals(proname) == true && electronics.get(i).quantity != 0) {
                e = electronics.get(i);
                Electronics.electronics.get(i).quantity--;
                return e;
            }
        }
        return null;
    }

    public Electronics deleteop(String proname) {
        Electronics e;
        for (int i = 0; i < electronics.size(); i++) {
            if (electronics.get(i).getName().equals(proname) == true) {
                e = electronics.get(i);
                Electronics.electronics.get(i).quantity++;
                return e;
            }
        }
        return null;
    }

    public static void updatefile() {
        int flag = 0;
        for (int i = 0; i < electronics.size(); i++) {
            try {
                PrintWriter writer = new PrintWriter("electronics.txt");
                writer.print("");
                writer.close();
                File f = new File("electronics.txt");

                FileWriter fr = new FileWriter(f, false);
                BufferedWriter br = new BufferedWriter(fr);
                for (Electronics electronic : electronics) {
                    br.write(electronic.getName() + ":" + electronic.getPrice() + ":" + electronic.getQuantity());
                    br.newLine();
                }
                br.close();
            } catch (Exception e) {

            }

            break;
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.price; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewproducts() {
        for (Electronics e : electronics) {
            System.out.println(e.name + " " + e.price + " " + e.quantity);
        }

    }
}
