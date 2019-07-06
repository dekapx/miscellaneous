package com.kapx.java8.basics;

interface DefaultMethod {
    void print(String arg);

    default String format(final String arg) {
        return "[ " + arg + " ]";
    }
}

class DefaultMethodImpl implements DefaultMethod {
    @Override
    public void print(final String arg) {
        System.out.println(format(arg));
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        final DefaultMethod obj = new DefaultMethodImpl();
        obj.print("Java 8");
    }
}
