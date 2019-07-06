package com.kapx.java.lambda;

@FunctionalInterface
interface Calc {
	int sum(int num1, int num2);
}

@FunctionalInterface
interface HelloWorld {
    String sayHello(String msg);
}

public class LambdaDemo {
	public static void main(String[] args) {
        calcDemo();
        helloWorldDemo();
	}

    public static void helloWorldDemo() {
        final HelloWorld helloWorld = (final String arg) -> {
            return "Hello ! " + arg;
        };

        final String output = helloWorld.sayHello("Kapx");
        System.out.println(output);
    }

    public static void calcDemo() {
        final Calc calc = (final int x, final int y) -> {
            return (x + y);
        };

        final int sum = calc.sum(5, 7);
        System.out.println("Sum: " + sum);
    }
}
