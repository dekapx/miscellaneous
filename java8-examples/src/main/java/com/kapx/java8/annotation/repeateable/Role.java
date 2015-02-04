package com.kapx.java8.annotation.repeateable;

import java.lang.annotation.Repeatable;

@Repeatable(value = Roles.class)
public @interface Role {
	String name() default "AUTHOR";
}
