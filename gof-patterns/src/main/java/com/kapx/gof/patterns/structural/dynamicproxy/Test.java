package com.kapx.gof.patterns.structural.dynamicproxy;

public class Test {

    public static void main(String[] args) {
        Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
        String str = foo.sayHello("Kapx");
        System.out.println(str);
    }
}
