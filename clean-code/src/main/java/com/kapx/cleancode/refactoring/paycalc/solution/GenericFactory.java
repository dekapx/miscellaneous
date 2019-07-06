package com.kapx.cleancode.refactoring.paycalc.solution;

public class GenericFactory {
    private static <T> T create(final T clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (T) Class.forName(clazz.getClass().getName()).newInstance();
    }
}
