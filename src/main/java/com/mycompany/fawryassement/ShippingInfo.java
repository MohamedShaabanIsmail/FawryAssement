package com.mycompany.fawryassement;

import com.mycompany.fawryassement.interfaces.Shippable;

class ShippingInfo implements Shippable {
    private final String name;
    private final double weight;

    public ShippingInfo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getWeight() { return weight; }
}