package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        Product p1 = new SimpleProduct("Молоко", 89);
        Product p2 = new FixPriceProduct("Хлеб");
        Product p3 = new DiscountedProduct("Сыр", 329, (byte) 15);
        Product p4 = new SimpleProduct("Коврик", 1000);
        Product p5 = new SimpleProduct("Электрическая зубная щётка", 1999);
        Product p6 = new SimpleProduct("Водка", 399);

        ProductBasket productBasket = new ProductBasket();
        ProductBasket productBasket2 = new ProductBasket();

        System.out.println("Пункт 1.");
        productBasket.addToBasket(p1);
        productBasket.addToBasket(p2);
        productBasket.addToBasket(p3);

        System.out.println("Пункт 2.");
        productBasket2.addToBasket(p1);
        productBasket2.addToBasket(p2);
        productBasket2.addToBasket(p3);
        productBasket2.addToBasket(p4);
        productBasket2.addToBasket(p5);
        productBasket2.addToBasket(p6);

        System.out.println("Пункт 3.");
        productBasket.printBasket();

        System.out.println("Пункт 4.");
        productBasket.totalCostBasket();

        System.out.println("Пункт 5.");
        productBasket.nameCheck("Хлеб");

        System.out.println("Пункт 6.");
        productBasket.nameCheck("Банан");

        System.out.println("Пункт 7.");
        productBasket.clearingTheBasket();

        System.out.println("Пункт 8.");
        productBasket.printBasket();

        System.out.println("Пункт 9.");
        productBasket.totalCostBasket();

        System.out.println("Пункт 10.");
        productBasket.nameCheck("Хлеб");
    }
}