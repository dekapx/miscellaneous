package com.kapx.java.dynamicproxy;

import java.lang.reflect.Proxy;

public class InvocationHandlerFactory {

    public static <T> T createProxy(final T target, final Class<T> clazz) {
        final DynamicInvocationHandler invocationHandler = new DynamicInvocationHandler(target);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, invocationHandler);
    }
}
