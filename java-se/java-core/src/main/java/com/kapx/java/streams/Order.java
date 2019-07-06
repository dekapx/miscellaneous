package com.kapx.java.streams;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private List<Item> items;

    public Order(final OrderBuilder orderBuilder) {
        this.id = orderBuilder.id;
        this.items = new ArrayList<>(orderBuilder.items);
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public static class OrderBuilder {
        private Long id;
        private List<Item> items;

        public OrderBuilder withId(final Long id) {
            this.id = id;
            return this;
        }

        public OrderBuilder withItems(final List<Item> items) {
            this.items = items;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
