package com.kapx.java.streams;

import java.util.HashMap;
import java.util.Map;

public class StreamWithMapDemo
{
    public static void main(String[] args)
    {
        final String name = "DeKapx";
        final String car = "BMW";
        final Map<String, String> elements = new HashMap<>();
        elements.put(name, car);

        final String result = findAndReturnElement(elements, name, car);
        System.out.println(result);
    }

    private static final String findAndReturnElement(final Map<String, String> elements, final String key, final String value)
    {
        return elements.entrySet()
                .stream()
                .filter(map -> map.getKey().equals(key) && map.getValue().equals(value))
                .map(map -> map.getKey() + " owns " + map.getValue())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element not found"));
    }
}
