package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {

        Product p1 = new SimpleProduct("Молоко", 89);
        Product p2 = new FixPriceProduct("Хлеб");
        Product p3 = new DiscountedProduct("Сыр", 329, (byte) 15);
        Product p4 = new SimpleProduct("Коврик", 1000);
        Product p5 = new SimpleProduct("Электрическая зубная щётка", 1999);

        ProductBasket productBasket = new ProductBasket();

        System.out.println("Пункт 1.");
        productBasket.addToBasket(p1);
        productBasket.addToBasket(p2);
        productBasket.addToBasket(p3);

        System.out.println("Пункт 3.");
        productBasket.printBasket();

        System.out.println("Пункт 4.");
        System.out.println(productBasket.totalCostBasket());

        System.out.println("Пункт 5.");
        System.out.println(productBasket.nameCheck("Хлеб"));

        System.out.println("Пункт 6.");
        System.out.println(productBasket.nameCheck("Банан"));

        System.out.println("Пункт 7.");
        productBasket.clearingTheBasket();

        System.out.println("Пункт 8.");
        productBasket.printBasket();

        System.out.println("Пункт 9.");
        System.out.println(productBasket.totalCostBasket());

        System.out.println("Пункт 10.");
        System.out.println(productBasket.nameCheck("Хлеб"));

        SearchEngine searchEngine = new SearchEngine(15);
        searchEngine.add(p1);
        searchEngine.add(p2);
        searchEngine.add(p3);
        searchEngine.add(p4);
        searchEngine.add(p5);

        Article a1 = new Article("Молоко полезно для костей", "Молоко считается крайне полезным для костей из за содержания в себе кальция");
        Article a2 = new Article("Как выбрать хлеб?", "Для правильного выбора хлеба...");
        Article a3 = new Article("Какие сорта сыра бывают?", "Начнём с того, что сыр появился...");
        searchEngine.add(a1);
        searchEngine.add(a2);
        searchEngine.add(a3);

        System.out.println("1");
        System.out.println(searchEngine.search("Молоко"));
        System.out.println("2");
        System.out.println(searchEngine.search("Яйца"));
        System.out.println("3");
        System.out.println(searchEngine.search(null));
        System.out.println("4");
        System.out.println(searchEngine.search(" "));
        System.out.println("5");
        System.out.println(searchEngine.search("кальц"));

        try {
            Product p7 = new SimpleProduct("Масло", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product p8 = new DiscountedProduct("Сметана", 119, (byte) 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product p9 = new FixPriceProduct("");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nДемонстрация нового метода поиска:\n");

        try {
            System.out.println(searchEngine.findingMostSuitable("Молоко"));
            System.out.println(searchEngine.findingMostSuitable("Батон"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        productBasket.addToBasket(p1);
        productBasket.addToBasket(p2);
        productBasket.addToBasket(p3);
        System.out.println("Содержимое корзины:");
        productBasket.printBasket();

        System.out.println("1. Удалить существующий продукт из корзины.\n" +
                "2. Вывести удалённые продукты на экран.");
        System.out.println(productBasket.removeProductByName("Молоко"));
        System.out.println(productBasket.removeProductByName("Хлеб"));

        System.out.println("3. Вывести содержимое корзины с помощью метода printBasket.");
        productBasket.printBasket();

        System.out.println("4. Удалить несуществующий продукт.\n" +
                "5. Проверить, что список удалённых продуктов пустой и вывести сообщение “Список пуст”.");
        if (productBasket.removeProductByName("Батон").isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("6. Вывести содержимое корзины на экран.");
        productBasket.printBasket();
    }
}