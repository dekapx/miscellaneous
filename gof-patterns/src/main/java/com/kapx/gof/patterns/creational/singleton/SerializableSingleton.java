package com.kapx.gof.patterns.creational.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {
	private static final long serialVersionUID = 1L;

	private static SerializableSingleton INSTANCE = new SerializableSingleton();

	private String state = "default-state";

	private SerializableSingleton() {
	}

	public static SerializableSingleton getInstance() {
		return INSTANCE;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	protected Object readResolve() {
		return INSTANCE;
	}

}
