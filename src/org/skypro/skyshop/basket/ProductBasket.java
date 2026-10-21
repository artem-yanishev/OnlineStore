package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket = new Product[5];
    private int counter;
    private int totalCost;

    public void addToBasket(Product product) {
        if (product != null && counter < 5) {
            for (int i = 0; i < basket.length; i++) {
                if (basket[i] == null) {
                    basket[i] = product;
                    break;
                }
            }
            counter++;
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
        if (counter != 0) {
            for (int i = 0; i < counter; i++) {
                System.out.println(basket[i]);
            }
            System.out.println("Итого: " + totalCost);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean nameCheck(String name) {
        boolean flag = false;
        if (counter != 0) {
            for (int i = 0; i < counter; i++) {
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
        counter = 0;
        totalCost = 0;
        System.out.println("Корзина очищена");
    }
}