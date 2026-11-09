package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> basket = new LinkedList<>();
    private int totalCost;

    public void addToBasket(Product product) {
        if (product != null) {
            basket.add(product);
            totalCost += product.getPrice();
            System.out.println("Товар - " + product + ", добавлен в корзину");
        }
    }

    public int totalCostBasket() {
        return totalCost;
    }

    public void printBasket() {
        int counterSpecial = 0;
        if (!basket.isEmpty()) {
            for (int i = 0; i < basket.size(); i++) {
                if (basket.get(i).isSpecial()) {
                    counterSpecial++;
                }
                System.out.println(basket.get(i));
            }
            System.out.println("Итого: " + totalCost);
            System.out.println("Специальных товаров: " + counterSpecial);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean nameCheck(String name) {
        boolean flag = false;
        if (!basket.isEmpty()) {
            for (int i = 0; i < basket.size(); i++) {
                if (basket.get(i).getName().equals(name)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public List<Product> removeProductByName(String name) {
        List<Product> deletedProducts = new ArrayList<>();
        if (name != null && !name.isBlank()) {
            Iterator<Product> iterator = basket.iterator();
            while (iterator.hasNext()) {
                Product element = iterator.next();
                if (element.getName().equals(name)) {
                    deletedProducts.add(element);
                    totalCost -= element.getPrice();
                    iterator.remove();
                }
            }
        }
        return deletedProducts;
    }

    public void clearingTheBasket() {
        basket.clear();
        totalCost = 0;
        System.out.println("Корзина очищена");
    }
}