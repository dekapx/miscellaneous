package com.kapx.java.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Item {
    private long id;
    private String name;
    private ItemType itemType;
    private double price;
}
