package com.kapx.java8.classloaders;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;

public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        final String className = DummyClass.class.getName();
        final DummyClass instance = createInstanceWithClassLoader(className);
        instance.doSomething();
    }

    private static <T> T createInstanceWithClassLoader(final String className) {
        try {
            final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            final Class<?> clazz = classLoader.loadClass(className);
            return (T)classLoader.loadClass(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void loadClassWithReflectionFactory(final String className) throws Exception {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final Class<DummyClass> clazz = (Class<DummyClass>) classLoader.loadClass(className);

        final DummyClass instance = create(clazz, Object.class);
        instance.doSomething();
    }

    public static <T> T create(final Class<T> clazz, final Class<? super T> parent) throws Exception {
        final ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
        final Constructor<? super T> declaredConstructor = parent.getDeclaredConstructor();
        final Constructor<?> constructor = reflectionFactory.newConstructorForSerialization(clazz, declaredConstructor);
        return clazz.cast(constructor.newInstance());
    }
}
