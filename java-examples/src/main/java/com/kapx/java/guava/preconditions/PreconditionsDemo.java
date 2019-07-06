package com.kapx.java.guava.preconditions;

import static com.google.common.base.Preconditions.*;

public class PreConditionsDemo {
    public String sayHello(final String arg) {
        checkNotNull(arg, "Argument must not be null.");
        checkState(!arg.isEmpty(), "Argument must not be empty.");
        return "-- Hello " + arg + " --";
    }
}
