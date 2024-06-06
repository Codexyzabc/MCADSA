/*
package queue;

import java.util.*;

class Dequeue<T> {
	int size;
	int front, rear;
	T arr[];

	Dequeue(int size) {
		this.size = size;
		front = -1;
		rear = -1;
		arr = (T[]) new Object[size];
	}

	boolean isFull() {
		return (front == 0 && rear == size - 1) || (front == rear + 1);
	}

	boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	void insertLeft(T x) {
		if (isFull()) {
			System.out.println("overflow");
			return;
		}
//		System.out.println("front:"+front+" rear:"+rear);

		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (front == 0) {
			front = size - 1;
		} else {
			front--;
		}
		arr[front] = x;

	}

	void insertRight(T x) {

		if (isFull()) {
			System.out.println("overflow");
			return;
		}
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (rear == size - 1) {
			rear = 0;
		} else {
			rear++;
		}
		arr[rear] = x;
	}

	T deleteLeft() {
		if (isEmpty()) {
			System.out.println("underflow");
			return null;
		}
		T temp = arr[front];
		arr[front] = null;
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else
			front++;
		return temp;

	}

	T deleteRight() {
		if (isEmpty()) {
			System.out.println("underflow");
			return null;
		}
		T temp = arr[rear];
		arr[rear] = null;
		if (rear == front) {
			rear = -1;
			front = -1;
		} else if (rear == 0) {
			rear = size - 1;
		} else
			rear--;
		return temp;
	}

	void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

public class SuvQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int control;
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.println("choose type of deque, 1 to input restricted, 2 to output restricted");
		control = sc.nextInt();
		System.out.println("enter the size of the queue");
		size = sc.nextInt();
		Dequeue<Integer> o1 = new Dequeue<Integer>(4);

		switch (control) {
		case 1:

			int c1=-1;
			while (c1 != 5) {
			System.out.println("choose option, 1-push-front, 2-pop-front, 3-pop-back, 4-display 5-exit");
			c1 = sc.nextInt();

				switch (c1) {
				case 1:
					int val;
					System.out.println("enter the number");
					val = sc.nextInt();
					o1.insertLeft(val);
					break;
				case 2:
					System.out.println("pop front value is:" + o1.deleteLeft());
					break;
				case 3:
					System.out.println("pop front value is:" + o1.deleteRight());
					break;
				case 4:
					o1.display();
					break;
				}
			}
		case 2:
			int c2=-1;
			while (c2 != 5) {
			System.out.println("choose option, 1-push-front, 2-push-back, 3-pop-front, 4-display 5-exit");
			c2 = sc.nextInt();

				switch (c2) {
				case 1:
					int val;
					System.out.println("enter the number");
					val = sc.nextInt();
					o1.insertLeft(val);
					break;
				case 2:
					int val2;
					System.out.println("enter the number");
					val2 = sc.nextInt();
					o1.insertLeft(val2);
					break;
				case 3:
					System.out.println("pop front value is:" + o1.deleteRight());
					break;
				case 4:
					o1.display();
					break;
				}
			}
		}

	}
}
*/