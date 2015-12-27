/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Project;

import java.util.List;

/**
 *
 * @author Seanan
 */
public interface Categories {

    public void viewproducts();

    public List products() ;

    public void addProduct(String name, double p, int q) ;

    public void removeProduct(String input) ;

    public void modifyprice(String input, double price);

    public void modifyquantity(String input, int quantity) ;

    Object getcartproduct(String proname);
    
     Object deleteop(String proname);
     
     public void searchproducts(String input);
   
}
