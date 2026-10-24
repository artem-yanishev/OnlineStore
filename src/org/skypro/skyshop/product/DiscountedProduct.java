package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private byte discount;

    public DiscountedProduct(String name, int basePrice, byte discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + basePrice + " (" + discount + "%)";
    }
}
