package com.mycompany.fawryassement;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.fawryassement.interfaces.Shippable;

class Customer {
    private final String name;
    private double balance;
    private final Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Cart getCart() { return cart; }

    public double getBalance() { return balance; }

    public void checkout() {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0;
        double shippingFees = 0;
        List<Shippable> itemsToShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;

            if (p.isExpired()) {
                throw new IllegalStateException("Product " + p.getName() + " is expired.");
            }

            if (item.quantity > p.getQuantity()) {
                throw new IllegalStateException("Not enough stock for " + p.getName());
            }

            subtotal += item.getTotalPrice();

            if (p.isShippable()) {
                itemsToShip.add(p.getShippable());
                shippingFees += 10.0;
            }
        }

        double total = subtotal + shippingFees;

        if (balance < total) {
            throw new IllegalStateException("Insufficient balance.");
        }

        balance -= total;
        for (CartItem item : cart.getItems()) {
            item.product.decreaseQuantity(item.quantity);
        }

        System.out.println("--- Checkout Summary ---");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Shipping: $" + shippingFees);
        System.out.println("Total Paid: $" + total);
        System.out.println("Remaining Balance: $" + balance);

        if (!itemsToShip.isEmpty()) {
            ShippingService.process(itemsToShip);
        }
    }
}