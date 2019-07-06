package com.kapx.java.reflection;

import com.kapx.java.common.model.Dummy;

import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        accessPrivateMethod();
    }

    private static void accessPrivateMethod() throws Exception {
        final Method method = Dummy.class.getDeclaredMethod("pingMe");
        method.setAccessible(true);
        final Dummy dummyObject = new Dummy();
        System.out.println(method.invoke(dummyObject));
    }
}
