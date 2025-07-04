package com.mycompany.fawryassement;

import java.util.List;

import com.mycompany.fawryassement.interfaces.Shippable;

class ShippingService {
    public static void process(List<Shippable> items) {
        System.out.println("\nShipping the following items:");
        for (Shippable item : items) {
            System.out.println("- " + item.getName() + " | Weight: " + item.getWeight() + "kg");
        }
    }
}
