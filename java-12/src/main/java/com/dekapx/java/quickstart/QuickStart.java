package com.dekapx.java.quickstart;

import lombok.val;

import java.time.LocalDate;
import java.util.HashMap;

public class QuickStart {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());

        val map = new HashMap<Integer, String>();
        map.put(1, "One");

        System.out.println(map);
    }
}
