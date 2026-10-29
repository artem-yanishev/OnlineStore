package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

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

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(p1);
        searchEngine.add(p2);
        searchEngine.add(p3);
        searchEngine.add(p4);
        searchEngine.add(p5);
        searchEngine.add(p6);

        Article a1 = new Article("Молоко полезно для костей", "Молоко считается крайне полезным для костей из за содержания в себе кальция");
        Article a2 = new Article("Как выбрать хлеб?", "Для правильного выбора хлеба...");
        Article a3 = new Article("Какие сорта сыра бывают?", "Начнём с того, что сыр появился...");
        searchEngine.add(a1);
        searchEngine.add(a2);
        searchEngine.add(a3);

        System.out.println("1");
        System.out.println(Arrays.toString(searchEngine.search("Молоко")));
        System.out.println("2");
        System.out.println(Arrays.toString(searchEngine.search("Яйца")));
        System.out.println("3");
        System.out.println(Arrays.toString(searchEngine.search("")));
        System.out.println("4");
        System.out.println(Arrays.toString(searchEngine.search(" ")));
    }
}