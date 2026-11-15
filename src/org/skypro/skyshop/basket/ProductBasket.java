package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket = new HashMap<>();
    private int totalCost;

    public void addToBasket(Product product) {
        if (product != null) {
            basket.computeIfAbsent(product.getName(), key -> new ArrayList<>()).add(product);
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
            for (List<Product> products : basket.values()) {
                for (Product product : products) {
                    if (product.isSpecial()) {
                        counterSpecial++;
                    }
                    System.out.println(product);
                }
            }
            System.out.println("Итого: " + totalCost);
            System.out.println("Специальных товаров: " + counterSpecial);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean nameCheck(String name) {
        return basket.containsKey(name);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> deletedProducts = new ArrayList<>();
        if (name != null && !name.isBlank() && basket.get(name) != null) {
            for (Product product : basket.get(name)) {
                deletedProducts.add(product);
                totalCost -= product.getPrice();
            }
            basket.remove(name);
        }
        return deletedProducts;
    }

    public void clearingTheBasket() {
        basket.clear();
        totalCost = 0;
        System.out.println("Корзина очищена");
    }
}