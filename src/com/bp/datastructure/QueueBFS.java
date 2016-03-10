package com.bp.datastructure;

public class QueueBFS {

	final static int MAX_SIZE = 100;

	private int queue[];
	private int front;
	private int rear;

	public QueueBFS() {
		queue = new int[MAX_SIZE];
		front = 0;
		rear = 0;
	}

	public void add(int in) {

		if (front == MAX_SIZE) {
			System.out.println("Full Queue!!");
			return;
		}

		queue[++front] = in;

	}

	public int poll() {

		int result;

		if (front == rear) {
			System.out.println("Empty Queue!!");
			return -100;
		}

		result = queue[rear];
		queue[rear++] = 0;

		return result;
	}

	boolean isEmpty() {
		if (front == rear)
			return true;
		else
			return false;
	}
}