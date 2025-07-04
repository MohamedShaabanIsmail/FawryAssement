/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fawryassement;

import java.time.LocalDate;

/**
 *
 * @author Ahmed Shaaban
 */
public class FawryAssement {

   public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 5.0, 10);
        cheese.setExpirable(new ExpiryDate(LocalDate.of(2025, 8, 1)));
        cheese.setShippable(new ShippingInfo("Cheese", 0.5));

        Product mobileCard = new Product("Mobile Scratch Card", 1.0, 100);

        Product tv = new Product("TV", 200.0, 2);
        tv.setShippable(new ShippingInfo("TV", 12.0));

        Customer customer = new Customer("Ali", 300.0);

        customer.getCart().addProduct(cheese, 2);
        customer.getCart().addProduct(tv, 1);
        customer.getCart().addProduct(mobileCard, 5);

        customer.checkout();
    }
}
}
