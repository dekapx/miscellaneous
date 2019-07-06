package com.kapx.java.streams;

import com.kapx.java.common.model.Item;
import com.kapx.java.common.model.ItemType;
import com.kapx.java.common.model.Order;

import static com.kapx.java.common.model.ItemType.BOOK;
import static com.kapx.java.common.model.ItemType.DVD;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemsStreamOperations {
    public static void main(String[] args) {
//        getItemNames();
//        getOrderItemNames();
        getBooksNames();
    }

    private static void getBooksNames() {
        final List<Order> orders = getOrders();
        final List<String> itemNames =  orders.stream()
                .map(o -> o.getItems())
                .flatMap(List::stream)
                .filter(i -> i.getItemType() == ItemType.BOOK)
                .map(i -> i.getName())
                .collect(Collectors.toList());
        print(itemNames);
    }


    private static void getOrderItemNames() {
        final List<Order> orders = getOrders();
        final List<String> itemNames = orders.stream()
                .map(o -> o.getItems())
                .flatMap(List::stream)
                .map(i -> i.getName())
                .collect(Collectors.toList());
        print(itemNames);
    }

    private static void getItemNames() {
        final List<Item> items = getItems();
        final List<String> itemNames = items.stream()
                .map(i -> i.getName())
                .collect(Collectors.toList());
        print(itemNames);
    }

    private static List<Order> getOrders() {
        return List.of(Order.builder().id(1L).items(getItems()).build());
    }

    private static void print(final List<String> elements) {
        elements.forEach(System.out::println);
    }

    private static List<Item> getItems() {
        return List.of(
                Item.builder().id(1L).name("Docker in Action").itemType(BOOK).price(45.99).build(),
                Item.builder().id(1L).name("Spring in Action").itemType(BOOK).price(59.99).build(),
                Item.builder().id(1L).name("Effective Java, 3rd Edition").itemType(BOOK).price(55.99).build(),
                Item.builder().id(1L).name("Docker in Motion").itemType(DVD).price(100.59).build(),
                Item.builder().id(1L).name("AWS Lambda in Action Video Edition").itemType(DVD).price(299.99).build(),
                Item.builder().id(1L).name("Getting Started with Kubernetes-Live Lessons").itemType(DVD).price(249.99).build()
        );
    }
}