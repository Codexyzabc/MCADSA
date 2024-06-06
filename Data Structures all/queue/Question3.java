/*
3. Write a menu driven program to implement a deque using list.
Call the two ends of the deque left and right and write four C functions, remvLeft,
remvRight, insrtLeft, insrtRight to remove and insert elements at the left and right
ends of the deque. Make sure that the routines work properly for empty deque and
that they detect overflow and underflow
*/

package queue;
import java.util.*;

class DEQueue<T> {
	
	int size;
	int front;
	int rear;
	T arr[];
	
	DEQueue(int size) {
		this.size = size;
		front = -1;
		rear = -1;
		arr = (T[]) new Object[size];
	}
	
	boolean isFull() {
		if(front == 0 && rear == size-1)
			return true;
		if(front == rear + 1)
			return true;
		return false;
	}
	
	boolean isEmpty() {
		return (front == -1);
	}
	
	void insert_rear(T element) {
		if(this.isFull()) {
			System.out.println("Queue overflow");
			return;
		}
		if(front == -1) {
			front = 0;
			rear = 0;
		}
		else if(rear == size - 1) {
			rear = 0;
		}
		else {
			rear++;
		}
		arr[rear] = element;
	}
	
	void insert_front(T element) {
		if(this.isFull()) {
			System.out.println("Queue overflow");
			return;
		}
		if(front == -1) {
			front = 0;
			rear = 0;
		}
		else if(front == 0) {
			front = size - 1;
		}
		else {
			front--;
		}
		arr[front] = element;
	}
	
	T delete_front() {
		if(this.isEmpty()) {
			System.out.println("Queue underflow");
			return null;
		}
		T element = arr[front];
		arr[front] = null;
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		else if(front == size - 1) {
			front = 0;
		}
		else {
			front++;
		}
		return element;
	}
	
	T delete_rear() {
		if(this.isEmpty()) {
			System.out.println("Queue underflow");
			return null;
		}
		T element = arr[rear];
		arr[rear] = null;
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		else if(rear == 0) {
			rear = size - 1;
		}
		else {
			rear--;
		}
		return element;
	}
	
	void display() {
		System.out.println("Elements in the queue are: ");
		for(int i=0;i<size;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

public class Question3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of queue: ");
		int size = sc.nextInt();
		DEQueue<Integer> obj = new DEQueue<Integer>(size);
		System.out.println("Choose type of queue, 1 to input restricted, 2 to output restricted: ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			while(true) {
				System.out.println("Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit");
				int ch = sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("Enter the element to insert: ");
					int n = sc.nextInt();
					obj.insert_rear(n);
					break;
				case 2:
					System.out.println("Deleted element is: " + obj.delete_front());
					break;
				case 3:
					System.out.println("Deleted element is: " + obj.delete_rear());
					break;
				case 4:
					obj.display();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid choice");
				}
			}
		case 2:
			while(true) {
				System.out.println("Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit");
				int ch = sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("Enter the element to insert: ");
					int n = sc.nextInt();
					obj.insert_front(n);
					break;
				case 2:
					System.out.println("Enter the element to insert: ");
					int m = sc.nextInt();
					obj.insert_rear(m);
					break;
				case 3:
					System.out.println("Deleted element is: " + obj.delete_front());
					break;
				case 4:
					obj.display();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid choice");
				}
			}
		default:
			System.out.println("Invalid choice");
		}
	}
}




/*
Output1:

Enter the size of queue: 
4
Choose type of queue, 1 to input restricted, 2 to output restricted: 
1
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
5
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
6
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
8
Invalid choice
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
9
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
3
Deleted element is: 9
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
13
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
4
Elements in the queue are: 
5 6 13 null 
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
2
Deleted element is: 5
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
3
Deleted element is: 13
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
4
Elements in the queue are: 
null 6 null null 
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
10
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
45
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
4
Elements in the queue are: 
null 6 10 45 
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
20
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
41
Queue overflow
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
4
Elements in the queue are: 
20 6 10 45 
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
2
Deleted element is: 6
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
3
Deleted element is: 20
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
1
Enter the element to insert: 
19
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
3
Deleted element is: 19
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
4
Elements in the queue are: 
null null 10 45 
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
3
Deleted element is: 45
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
3
Deleted element is: 10
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
2
Queue underflow
Deleted element is: null
Choose option 1.Insert rear, 2.Delete front, 3.Delete rear, 4.Display, 5.Exit
5



Output2:

Enter the size of queue: 
4
Choose type of queue, 1 to input restricted, 2 to output restricted: 
2
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
1
Enter the element to insert: 
12
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
1
Enter the element to insert: 
47
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
4
Elements in the queue are: 
12 null null 47 
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit

2
Enter the element to insert: 
35
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
4
Elements in the queue are: 
12 35 null 47 
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
2
Enter the element to insert: 
7
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
1
Enter the element to insert: 
8
Queue overflow
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
4
Elements in the queue are: 
12 35 7 47 
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
3
Deleted element is: 47
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
3
Deleted element is: 12
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
3
Deleted element is: 35
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
3
Deleted element is: 7
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
3
Queue underflow
Deleted element is: null
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
7
Invalid choice
Choose option 1.Insert front, 2.Insert rear, 3.Delete front, 4.Display, 5.Exit
5



*/










