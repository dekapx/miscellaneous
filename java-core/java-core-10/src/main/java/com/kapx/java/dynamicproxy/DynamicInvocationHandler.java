package com.kapx.java.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {
    private final Object target;

    public DynamicInvocationHandler(final Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Exception {
//        args[0] = null; // make argument null, cause exception to occur...
        final Object result = method.invoke(target, args);
        return result;
    }
}
