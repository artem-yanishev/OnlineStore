package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket = new Product[5];
    private int counterProducts;
    private int totalCost;

    public void addToBasket(Product product) {
        if (product != null && counterProducts < 5) {
            for (int i = 0; i < basket.length; i++) {
                if (basket[i] == null) {
                    basket[i] = product;
                    break;
                }
            }
            counterProducts++;
            totalCost += product.getPrice();
            System.out.println("Товар - " + product + ", добавлен в корзину");
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalCostBasket() {
        return totalCost;
    }

    public void printBasket() {
        int counterSpecial = 0;
        if (counterProducts != 0) {
            for (int i = 0; i < counterProducts; i++) {
                if (basket[i].isSpecial()) {
                    counterSpecial++;
                }
                System.out.println(basket[i]);
            }
            System.out.println("Итого: " + totalCost);
            System.out.println("Специальных товаров: " + counterSpecial);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean nameCheck(String name) {
        boolean flag = false;
        if (counterProducts != 0) {
            for (int i = 0; i < counterProducts; i++) {
                if (basket[i].getName().equals(name)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void clearingTheBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
        counterProducts = 0;
        totalCost = 0;
        System.out.println("Корзина очищена");
    }
}