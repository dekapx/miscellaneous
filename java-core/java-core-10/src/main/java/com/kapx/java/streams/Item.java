package com.kapx.java.streams;

public class Item {
    private Long id;
    private String name;
    private double price;

    public Item(final ItemBuilder itemBuilder) {
        this.id = itemBuilder.id;
        this.name = itemBuilder.name;
        this.price = itemBuilder.price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static class ItemBuilder {
        private Long id;
        private String name;
        private double price;

        public ItemBuilder withId(final Long id) {
            this.id = id;
            return this;
        }

        public ItemBuilder withName(final String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withPrice(final double price) {
            this.price = price;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    @Override
    public String toString() {
        return getId() + ". " + getName() + ", $" + getPrice() + "";
    }
}
