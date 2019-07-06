package com.kapx.java.streams;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class StreamWithComplexTypeDemo {

    public static void main(String[] args) {
        countMultipleItems();
    }

    private static void searchItemByName() {
        final Predicate<Item> itemByNamePredicate = getItemByNamePredicate("iPhone 6s");
        final List<Order> orders = buildOrders();
        final Item item = orders.stream()
                .map(Order::getItems)
                .flatMap(Collection::stream)
                .filter(itemByNamePredicate)
                .findFirst().orElseThrow(() -> new RuntimeException("Item Not Found..."));
        System.out.println(item);
    }

    private static void searchMostExpensiveItem() {
        final Predicate<Item> mostExpensiveItemPredicate = getMostExpensiveItemPredicate();
        final List<Order> orders = buildOrders();
        final Item mostExpensiveItem = orders.stream()
                .map(Order::getItems)
                .flatMap(Collection::stream)
                .filter(mostExpensiveItemPredicate)
                .findFirst().get();
        System.out.println(mostExpensiveItem);
    }

    private static Predicate<Item> getItemByNamePredicate(final String itemName) {
        return item -> item.getName().equals(itemName);
    }

    private static Predicate<Item> getMostExpensiveItemPredicate() {
        return item -> item.getPrice() > 2500;
    }

    private static void calculateMultipleOrderValues_example1() {
        final List<Order> orders = buildOrders();
        final double orderValue = orders.stream()
                .map(Order::getItems)
                .flatMap(Collection::stream)
                .map(item -> item.getPrice())
                .reduce(0.0, Double::sum);
        System.out.println(roundUpTwoDecimals(orderValue));
    }

    private static void calculateMultipleOrderValues_example2() {
        final List<Order> orders = buildOrders();
        final double orderValue = orders.stream()
                .map(Order::getItems)
                .flatMap(item -> item.stream())
                .map(item -> item.getPrice())
                .reduce(0.0, Double::sum);
        System.out.println(roundUpTwoDecimals(orderValue));
    }

    private static void calculateSingleOrderValue() {
        final Order order = buildOrder();
        final double orderValue = order.getItems()
                .stream()
                .map(item -> item.getPrice())
                .reduce(0.0, Double::sum);
        System.out.println(roundUpTwoDecimals(orderValue));
    }

    private static void countSingleItems() {
        final Order order = buildOrder();
        final long itemCount = order.getItems()
                .stream()
                .count();
        System.out.println(itemCount);
    }

    private static void countMultipleItems() {
        final List<Order> orders = buildOrders();
        final long itemCount = orders.stream()
                .map(Order::getItems)
                .flatMap(Collection::stream)
                .count();
        System.out.println(itemCount);
    }

    private static Order buildOrder() {
        final List<Item> items = new ArrayList<>(5);
        items.add(new Item.ItemBuilder()
                .withId(1L)
                .withName("MacBook Pro 15")
                .withPrice(2569.99)
                .build());
        items.add(new Item.ItemBuilder()
                .withId(2L)
                .withName("MacBook Pro 13")
                .withPrice(1899.75)
                .build());
        items.add(new Item.ItemBuilder()
                .withId(3L)
                .withName("iPhone 6s")
                .withPrice(799.99)
                .build());
        items.add(new Item.ItemBuilder()
                .withId(4L)
                .withName("Sony PlayStation 4")
                .withPrice(899.45)
                .build());
        items.add(new Item.ItemBuilder()
                .withId(5L)
                .withName("Samsung Galaxy S7")
                .withPrice(699.99)
                .build());

        return new Order.OrderBuilder()
                .withId(1L)
                .withItems(items).build();
    }

    private static List<Order> buildOrders() {
        final List<Order> orders = new ArrayList<>(2);

        final List<Item> items1 = new ArrayList<>(3);
        items1.add(new Item.ItemBuilder()
                .withId(1L)
                .withName("MacBook Pro 15")
                .withPrice(2569.99)
                .build());

        items1.add(new Item.ItemBuilder()
                .withId(2L)
                .withName("MacBook Pro 13")
                .withPrice(1899.75)
                .build());

        items1.add(new Item.ItemBuilder()
                .withId(3L)
                .withName("iPhone 6s")
                .withPrice(799.99)
                .build());
        orders.add(new Order.OrderBuilder()
                        .withId(1L)
                        .withItems(items1).build());

        final List<Item> items2 = new ArrayList<>(3);
        items2.add(new Item.ItemBuilder()
                .withId(4L)
                .withName("Sony PlayStation 4")
                .withPrice(899.45)
                .build());
        items2.add(new Item.ItemBuilder()
                .withId(5L)
                .withName("Samsung Galaxy S7")
                .withPrice(699.99)
                .build());
        items2.add(new Item.ItemBuilder()
                .withId(6L)
                .withName("Boss Cine System")
                .withPrice(1299.99)
                .build());
        orders.add(new Order.OrderBuilder()
                        .withId(1L)
                        .withItems(items2).build());
        return orders;
    }

    private static double roundUpTwoDecimals(final double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
