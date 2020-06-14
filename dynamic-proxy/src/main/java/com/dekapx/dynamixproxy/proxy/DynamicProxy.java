package com.dekapx.dynamixproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object proxyObject;

    private DynamicProxy(Object object) {
        this.proxyObject = object;
    }

    public static Object newInstance(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new DynamicProxy(object));
    }

    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        return method.invoke(this.proxyObject, args);
    }
}
