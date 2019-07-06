package com.kapx.java.designpatterns.creational.singleton;

import com.kapx.java.designpatterns.common.service.HelloWorld;

public class ServiceManagerClient {
    public static void main(String[] args) {
        final ServiceManager serviceManager = ServiceManager.INSTANCE;
        final HelloWorld helloWorld = serviceManager.getService(HelloWorld.class);
        System.out.println(helloWorld.sayHello("DeKapx"));
    }
}
