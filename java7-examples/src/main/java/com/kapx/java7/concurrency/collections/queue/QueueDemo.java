package com.kapx.java7.concurrency.collections.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		final QueueDemo demo = new QueueDemo();
		demo.demoLinkedList();
		demo.demoPriorityQueue();
	}

	public void demoLinkedList() {
		System.out.println("LinkedList demo...");
		final Queue<String> queue = new LinkedList<String>();

		queue.offer("Z");
		System.out.println(queue);

		queue.offer("X");
		System.out.println(queue);

		queue.offer("Y");
		System.out.println(queue);

		System.out.println(queue.poll() + "->" + queue);
		System.out.println(queue.poll() + "->" + queue);
		System.out.println(queue.poll() + "->" + queue);
	}

	public void demoPriorityQueue() {
		System.out.println("PriorityQueue demo...");
		final Queue<String> queue = new PriorityQueue<String>();

		queue.offer("Z");
		System.out.println(queue);

		queue.offer("X");
		System.out.println(queue);

		queue.offer("Y");
		System.out.println(queue);

		System.out.println(queue.poll() + "->" + queue);
		System.out.println(queue.poll() + "->" + queue);
		System.out.println(queue.poll() + "->" + queue);
	}
}
