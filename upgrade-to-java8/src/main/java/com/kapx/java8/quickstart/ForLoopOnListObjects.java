package com.kapx.java8.quickstart;

import com.kapx.java8.model.Car;
import com.kapx.java8.model.CarType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.kapx.java8.model.CarHelper.getCars;

public class ForLoopOnListObjects {
    private final static Predicate<Car> findByTypePredicate(final CarType type) {
        return c -> c.getType().equals(type);
    }

    private static void findByTypeJava7(final List<Car> cars, final CarType carType) {
        final List<Car> selectedCars = new ArrayList<>();
        for (Car car : cars) {
            if (isMatchByType(car, carType)) {
                selectedCars.add(car);
            }
        }
        display(selectedCars);
    }

    private static boolean isMatchByType(final Car car, final CarType carType) {
        return car.getType().equals(carType);
    }

    private static void findByTypeJava8(final List<Car> cars, final CarType carType) {
        final List<Car> selectedCars = cars.stream()
                .filter(findByTypePredicate(carType))
                .collect(Collectors.toList());
        display(selectedCars);
    }

    private static void display(final List<Car> cars) {
        cars.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final List<Car> cars = new ArrayList<>();
        // option 1
//        cars.stream().collect(Collectors.toCollection(() -> getCars()));
        // option 2
        cars.addAll(getCars());

        findByTypeJava7(cars, CarType.Coupe);
        System.out.println("---------------------------------------------------------------------");
        findByTypeJava8(cars, CarType.SUV);
    }
}
