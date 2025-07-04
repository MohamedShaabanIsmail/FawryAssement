package com.mycompany.fawryassement;

import com.mycompany.fawryassement.interfaces.Expirable;
import com.mycompany.fawryassement.interfaces.Shippable;

class Product {
    private final String name;
    private final double price;
    private int quantity;
    private Expirable expirable;
    private Shippable shippable;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setExpirable(Expirable expirable) {
        this.expirable = expirable;
    }

    public void setShippable(Shippable shippable) {
        this.shippable = shippable;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void decreaseQuantity(int amount) { this.quantity -= amount; }

    public boolean isExpired() {
        return expirable != null && expirable.isExpired();
    }

    public boolean isShippable() {
        return shippable != null;
    }

    public Shippable getShippable() {
        return shippable;
    }
}
