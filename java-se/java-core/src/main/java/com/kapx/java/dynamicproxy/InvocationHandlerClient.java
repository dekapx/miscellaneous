package com.kapx.java.dynamicproxy;

public class InvocationHandlerClient {
    public static void main(String[] args) {
        final HelloWorld helloWorld = new HelloWorldImpl();
        final HelloWorld proxyObject = InvocationHandlerFactory.createProxy(helloWorld, HelloWorld.class);
        final String output = proxyObject.sayHello("DeKapx");
        System.out.println(output);
    }
}
