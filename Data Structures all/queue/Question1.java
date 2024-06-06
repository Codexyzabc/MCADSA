/*
1. Write a program to implement a Queue class (use a list to store the elements of the
Queue). [Implement Queue Overflow and Underflow by Exception]. Write a
method to check two Queue are carrying similar elements or not. (Repetition of the
elements are not consider)
*/
package queue;

import java.util.*;
class OverflowException extends Exception {
	public OverflowException(String msg) {
		super(msg);
	}
}

class UnderflowException extends Exception {
	public UnderflowException(String msg) {
		super(msg);
	}
}

class MyQueue<T> {
	int size;
	int front;
	int rear;
	T[] queue;
	
	
	MyQueue(int size) {
		this.size = size;
		front = rear = -1;
		queue = (T[]) new Object[size];
	}
	
	boolean isEmpty() {
		return (front == rear);
	}
	
	boolean isFull() {
		return (rear == size - 1);
	}
	
	public void insert(T element) throws OverflowException {
		if(this.isFull())
			throw new OverflowException("Queue overflow");

		queue[++rear] = element;

	}
	
	public T delete() throws UnderflowException {
		if(this.isEmpty()) {
			throw new UnderflowException("Queue underflow");
		}
		T temp = queue[++front];
		queue[front] = null;		// Deleting the element by making it null
		if(front == rear) {		// Reset the front and rear (reset queue)
			front = -1;
			rear = -1;
		}
		return temp;
	}
	
	void display() {
		System.out.println("Elements in the queue are: ");
		for(int i=0;i<=rear;i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}
	
	boolean isSame(MyQueue q1) {			// Checking two queues if they are equal
		Set<T> s1 = new HashSet<T>();
		Set<T> s2 = new HashSet<T>();
		for(int i=0;i<this.size;i++) {
			s1.add(this.queue[i]);
		}
		for(int i=0;i<q1.size;i++) {
			s2.add((T) q1.queue[i]);
		}
		if(s1.equals(s2)) return true;
		return false;
	}
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> obj = new MyQueue<Integer>(5);
		MyQueue<Integer> q1 = new MyQueue<Integer>(3);
		MyQueue<Integer> q2 = new MyQueue<Integer>(3);
		try {
			obj.insert(1);
			obj.insert(2);
			obj.display();
			System.out.println("Deleted element is: " + obj.delete());
			obj.insert(3);
			obj.display();
			obj.insert(4);
			obj.insert(5);
			obj.display();
			obj.delete();
			obj.delete();
			obj.delete();
			obj.display();
			obj.delete();
			obj.insert(10);
			obj.display();
			
			q1.insert(1);
			q1.insert(2);
			q1.insert(3);
			q2.insert(1);
			q2.insert(4);
			q2.insert(3);
			System.out.println(q1.isSame(q2));		// Checking if two queues are same

		}
		catch(Exception e) {
			System.out.println(e);
		}	
		
//		MyQueue<Double> obj1 = new MyQueue<Double>(3);
//		try {
//			obj1.insert(2.3);
//			System.out.println("Deleted element is: " + obj1.delete());
//			System.out.println("Deleted element is: " + obj1.delete());
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
		
//		MyQueue<String> obj2 = new MyQueue<String>(3);
//		try {
//			obj2.insert("Ram");
//			obj2.insert("Tom");
//			obj2.insert("World");
//			obj2.display();
//			System.out.println("Deleted element is: " + obj2.delete());
//			obj2.display();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
	}

}

/*
Output1:

Elements in the queue are: 
1 2 
Deleted element is: 1
Elements in the queue are: 
null 2 3 
Elements in the queue are: 
null 2 3 4 5 
Elements in the queue are: 
null null null null 5 
Elements in the queue are: 
10 
false

Output2:

Deleted element is: 2.3
day4.UnderflowException: Queue underflow

Output3:

Elements in the queue are: 
Ram Tom World 
Deleted element is: Ram
Elements in the queue are: 
null Tom World 
*/
