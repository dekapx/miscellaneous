package com.kapx.java8.quickstart;

import com.kapx.java8.model.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.kapx.java8.model.CarHelper.getCars;

public class SortListOfObjects {

    public static void main(String[] args) {
        sortJava7();
        System.out.println("\n-----------------------------------------------");
        sortJava8Example1();
        System.out.println("\n-----------------------------------------------");
        sortJava8Example2();
    }

    private static void sortJava7() {
        final List<Car> cars = getCars();
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getName().compareTo(car2.getName());
            }
        });
        display(cars);
    }

    private static void sortJava8Example1() {
        final List<Car> cars = getCars();
        cars.sort(compareCars());
        display(cars);
    }

    private static void sortJava8Example2() {
        final List<Car> cars = getCars();
        display(cars.stream()
                .sorted(compareCars())
                .collect(Collectors.toList()));
    }

    private static Comparator<Car> compareCars() {
        return (car1, car2) ->  car1.getName().compareTo(car2.getName());
    }

    private static void display(final List<Car> cars) {
        cars.forEach(System.out::println);
    }
}
