package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private byte discount;

    public DiscountedProduct(String name, int basePrice, byte discount) {
        super(name);
        if (basePrice > 0) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100 включительно");
        }
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
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
