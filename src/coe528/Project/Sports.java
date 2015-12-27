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
public class Sports implements Categories {

    private String name;
    private double price;
    private int quantity;

    private static List<Sports> sports = new ArrayList<>();

    public Sports(String name, double price, int q) {
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
            File f = new File("sports.txt");
            //Scanner sc = new Scanner(f);

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String abc;
            while ((abc = br.readLine()) != null) {
                details = abc.split(":");
                String name = details[0];
                p = Double.parseDouble(details[1]);
                q = Integer.parseInt(details[2]);
                Sports sport = new Sports(name, p, q);
                sports.add(sport);
                i++;
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sports;
    }

    public void searchproducts(String input) {
        for (Sports s : sports) {
            if (s.getName().contentEquals(input) == true) {
                System.out.println(s.toString());
                break;
            }

        }

    }

    @Override
    public void addProduct(String name, double price, int quantity) {
        double p;
        int q;
        int flag = 0;
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).name.contentEquals(name)) {
                flag = 1;
            }
        }

        if (flag == 0) {
            FileWriter fr = null;

            Sports s = new Sports(name, price, quantity);
            sports.add(s);
            System.out.println("The product was successfully added");
            //PrintWriter writer = new PrintWriter("sports.txt");
            //writer.print("");
            //writer.close();
            // File f = new File("sports.txt");
            //fr = new FileWriter(f);
            //BufferedWriter br = new BufferedWriter(fr);
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sports.txt", true)))) {
                p = price;
                q = quantity;
                out.print(name + ":" + p + ":" + q);
            } catch (IOException e) {
            }

        } else {
            System.out.println("Name already exists");
        }

    }

    @Override
    public void removeProduct(String input) {
        int flag = 0;
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                sports.remove(i);
                System.out.println("was removed successfully");
                try {
                    PrintWriter writer = new PrintWriter("sports.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("sports.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (int j = 0; j < sports.size(); j++) {
                        br.write(sports.get(j).getName() + ":" + sports.get(j).getPrice() + ":" + sports.get(j).getQuantity());
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

    public double returnPrice(String input) {
        for (int i = 0; i <= sports.size(); i++) {
            if (sports.get(i).getName().equalsIgnoreCase(input) == true) {

                return (sports.get(i).getPrice());

            }
        }
        return 0;

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

    public String getName() {
        return name;
    }

    public double getPrice() {

        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void modifyprice(String input, double price) {

        int flag = 0;
        for (int i = 0; i <= sports.size(); i++) {
            if (sports.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                sports.get(i).setPrice(price);
                try {
                    PrintWriter writer = new PrintWriter("sports.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("sports.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (int j = 0; j < sports.size(); j++) {
                        br.write(sports.get(j).getName() + ":" + sports.get(j).getPrice() + ":" + sports.get(j).getQuantity());
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
        for (int i = 0; i <= sports.size(); i++) {
            if (sports.get(i).getName().equalsIgnoreCase(input) == true) {
                flag = 1;
                sports.get(i).setQuantity(quantity);
                try {
                    PrintWriter writer = new PrintWriter("sports.txt");
                    writer.print("");
                    writer.close();
                    File f = new File("sports.txt");
                    FileWriter fr = new FileWriter(f);
                    BufferedWriter br = new BufferedWriter(fr);
                    for (int j = 0; j < sports.size(); j++) {
                        br.write(sports.get(j).getName() + ":" + sports.get(j).getPrice() + ":" + sports.get(j).getQuantity());
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
    public Sports getcartproduct(String proname) {
        Sports spo;
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).name.equals(proname) && sports.get(i).quantity != 0) {
                spo = sports.get(i);
                // Clothing.clothings.remove(i);
                Sports.sports.get(i).quantity--;
                return spo;
            }

        }
        return null;
    }

    public static void updatefile() {
        for (int i = 0; i < sports.size(); i++) {
            try {
                PrintWriter writer = new PrintWriter("sports.txt");
                writer.print("");
                writer.close();
                File f = new File("sports.txt");
                FileWriter fr = new FileWriter(f, false);
                BufferedWriter br = new BufferedWriter(fr);
                for (int j = 0; j < sports.size(); j++) {
                    br.write(sports.get(j).getName() + ":" + sports.get(j).getPrice() + ":" + sports.get(j).getQuantity());
                    br.newLine();
                }
                br.close();
                // br.flush();
            } catch (Exception e) {

            }
        }
    }

    public Sports deleteop(String proname) {
        Sports spo;
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).name.equals(proname)) {
                spo = sports.get(i);
                // Clothing.clothings.remove(i);
                Sports.sports.get(i).quantity++;
                return spo;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return this.name + " " + this.price; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewproducts() {
        for (Sports e : sports) {
            System.out.println(e.name + " " + e.price + " " + e.quantity);
        }

    }
}
