package com.dekapx.dynamixproxy.client;

import com.dekapx.dynamixproxy.factory.DynamicProxyFactory;
import com.dekapx.dynamixproxy.subject.HelloWorld;
import com.dekapx.dynamixproxy.subject.HelloWorldImpl;

public class HelloWorldClient {
    public static void main(String[] args) {
        HelloWorld helloWorld = DynamicProxyFactory.INSTANCE.createProxyObject(HelloWorldImpl.class);
        String value = helloWorld.sayHello("Test");
        System.out.println(value);
    }
}
