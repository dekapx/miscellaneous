package com.kapx.gof.patterns.structural.dynamicproxy;

public class FooImpl implements Foo {

    @Override
    public String sayHello(String arg) {
        return "Hello !!! " + arg;
    }

}
