package com.dekapx.dynamixproxy.factory;

import com.dekapx.dynamixproxy.proxy.DynamicProxy;

import java.lang.reflect.Constructor;

public enum DynamicProxyFactory {
    INSTANCE;

    public <T> T createProxyObject(Class<T> clazz) {
        try {
            Constructor constructor = clazz.getConstructors()[0];
            return (T) DynamicProxy.newInstance(constructor.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
