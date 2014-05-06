package com.kapx.java7.concurrency.collections;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");

		System.out.println("Element of queue = " + queue);
		// peek() retrieves, but does not remove, the head of this queue
		String element = queue.peek();
		System.out.println("Head element of queue = " + element);

		// isEmpty() checks if queue is empty
		boolean isEmpty = queue.isEmpty();
		System.out.println("Queue is empty : " + isEmpty);

		// contains() method
		boolean flag = queue.contains("D");
		System.out.println("Is element 'D' existed into queue ? " + flag);

		// poll() Retrieves and removes the head of this queue
		element = queue.poll();
		System.out.println("Removed head element = " + element);

		// size() check the numbers of elements in queue
		int size = queue.size();
		System.out.println("Size of queue = " + size);
	}
}
