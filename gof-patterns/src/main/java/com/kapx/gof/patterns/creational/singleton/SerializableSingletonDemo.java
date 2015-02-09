package com.kapx.gof.patterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableSingletonDemo {
	private static final String SER_FILE_NAME = "singleton.ser";

	public static void main(String[] args) {
		final SerializableSingleton singleton = SerializableSingleton.getInstance();
		System.out.println("Before S1: " + singleton.getState());
		singleton.setState("new-state");
		System.out.println("After S1: " + singleton.getState());

		// serialize singleton object
		serialize(singleton);

		// deserialization single
		final SerializableSingleton singleton2 = deserialize();
		System.out.println("Before S2: " + singleton2.getState());
		singleton2.setState("singleton2-new-state");
		System.out.println("After S1: " + singleton.getState());
		System.out.println("After S2: " + singleton2.getState());
	}

	public static <T> void serialize(T object) {
		ObjectOutputStream objectOutputStream = null;
		try {
			final FileOutputStream fileOutputStream = new FileOutputStream(SER_FILE_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T deserialize() {
		T object = null;
		ObjectInputStream objectInputStream = null;

		try {
			final FileInputStream fileInputStream = new FileInputStream(SER_FILE_NAME);
			objectInputStream = new ObjectInputStream(fileInputStream);
			object = (T) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return object;
	}
}
