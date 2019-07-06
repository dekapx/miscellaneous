package com.kapx.java8.model;

import java.util.ArrayList;
import java.util.List;

public class CarHelper {
    public static List<Car> getCars() {
        final List<Car> cars = new ArrayList<>();
        cars.add(Car.builder().name("BMW X3").type(CarType.SUV).color("Jet Black").build());
        cars.add(Car.builder().name("BMW X5").type(CarType.SUV).color("Sapphire  Black").build());
        cars.add(Car.builder().name("BMW 4 Series").type(CarType.Coupe).color("Estoril Blue").build());
        cars.add(Car.builder().name("BMW 6 Series").type(CarType.Coupe).color("Alpine White").build());
        cars.add(Car.builder().name("BMW 1 Series").type(CarType.Hatchback).color("Deep Sea Blue").build());
        cars.add(Car.builder().name("BMW 3 Series").type(CarType.GT).color("Estoril Blue").build());
        cars.add(Car.builder().name("BMW 5 Series").type(CarType.Saloon).color("Imperial Blue").build());
        return cars;
    }
}
