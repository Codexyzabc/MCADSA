/*
1. Write a program to implement a Stack class (use a Array to store the elements of the stack).
[Implement Stack Overflow and Underflow by user defined Exception]. Write a method to
check two stack are carrying similar elements or not.(Repetition of the elements are not
consider)
*/

package stack;

import java.util.*;

// Custom exception for stack overflow
class OverflowException extends Exception {
	public OverflowException(String msg) {
		super(msg);
	}
}

// Custom exception for stack underflow
class UnderflowException extends Exception {
	public UnderflowException(String msg) {
		super(msg);
	}
}

// Generic Stack class implementation
class MyStack<T> {
	private int maxSize;
	private T arr[];
	private int top;

	MyStack(int size) {
		maxSize = size;
		arr = (T[]) new Object[maxSize];
		top = -1;
	}

	// Push element onto stack
	public void push(T x) throws OverflowException {
		if (this.isFull())
			throw new OverflowException("Stack is full");
		else
			arr[++top] = x;
	}

	// Pop element from stack
	public T pop() throws UnderflowException {
		if (this.isEmpty())
			throw new UnderflowException("Stack is empty");
		else
			return arr[top--];
	}

	// Get the top data element of the stack, without removing it
	public T peek() throws UnderflowException {
		if (this.isEmpty())
			throw new UnderflowException("Stack is empty");
		else
			return arr[top];
	}

	// Check if stack is full
	public boolean isFull() {
		return (top == maxSize - 1);
	}

	// Check if stack is empty
	public boolean isEmpty() {
		return (top == -1);
	}

	// Check if two stacks have similar elements
	public boolean areSimilar(MyStack otherStack) {
		T[] thisStackCopy = Arrays.copyOf(this.arr, top+1);		// Copy array into another array
		Object[] otherStackCopy = Arrays.copyOf(otherStack.arr, otherStack.top+1);		// Copy the array to compare with into another array

		// Sort both the copied arrays
		Arrays.sort(thisStackCopy);
		Arrays.sort(otherStackCopy);

		// Check with equals method, if similar returns true else false
		return Arrays.equals(thisStackCopy, otherStackCopy);
	}
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			MyStack<Integer> obj = new MyStack<Integer>(3);
			MyStack<String> obj1 = new MyStack<String>(3);
			obj.push(10);
			obj.push(20);
			obj.push(30);
//			obj.push(40);		// It will give Stack.OverflowException: Stack is full
			System.out.println("Popped out element: " + obj.pop());
			System.out.println("Top element: " + obj.peek());
			System.out.println("Popped out element: " + obj.pop());
			System.out.println("Popped out element: " + obj.pop());
//			System.out.println("Popped out element: " + obj.pop());		// It will give Stack.UnderflowException: Stack is empty

			obj1.push("Hello");
			obj1.push("World");
			System.out.println("Top element: " + obj1.peek());

			MyStack<Integer> obj2 = new MyStack<Integer>(3);
			MyStack<Integer> obj3 = new MyStack<Integer>(3);
			
			obj2.push(1);
			obj2.push(2);
			obj2.push(3);
			
			obj3.push(4);
			obj3.push(2);
			obj3.push(1);
			
			System.out.println("Check if two stack contains similar elements: " + obj2.areSimilar(obj3));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

/*
Output:

Popped out element: 30
Top element: 20
Popped out element: 20
Popped out element: 10
Top element: World
Check if two stack contains similar elements: true

Popped out element: 30
Top element: 20
Popped out element: 20
Popped out element: 10
Top element: World
Check if two stack contains similar elements: false
 */