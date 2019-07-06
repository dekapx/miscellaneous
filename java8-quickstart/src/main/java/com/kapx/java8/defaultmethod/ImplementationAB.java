package com.kapx.java8.defaultmethod;

interface InterfaceA {
    default void defaultMethod() {
        System.out.println("InterfaceA.defaultMethod()");
    }
}

interface InterfaceB {
    default void defaultMethod() {
        System.out.println("InterfaceB.defaultMethod()");
    }
}

public class ImplementationAB implements InterfaceA, InterfaceB {
    public void defaultMethod() {
        defaultMethod();    // cause stack overflow...
    }


    public static void main(String[] args) {
        ImplementationAB obj = new ImplementationAB();
        obj.defaultMethod();
    }
}
