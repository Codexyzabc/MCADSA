/*
2. Write a menu driven program to implement a circular queue (use an array to store
the elements of the queue).
You can follow any one of the schemes A circular list with front and rear indices and
one position left vacant. Or, A circular list with front and rear indices and an integer
variable counting entries
*/

package queue;

class CirQueue<T> {
	
	int size;
	int front, rear;
	T arr[];
	
	CirQueue(int size) {
		this.size = size;
		front = rear = -1;
		arr = (T[]) new Object[size];
	}
	
	boolean isFull() {
		if(front == 0 && rear == size - 1) 
			return true;
		if(front == rear + 1)
			return true;
		return false;
	}
	
	boolean isEmpty() {
		if(front == -1)
			return true;
		else
			return false;
	}
	
	void push(T element) throws OverflowException {
		if(this.isFull())
			throw new OverflowException("Queue overflow");
		if(front == -1) 
			front = 0;
		rear = (rear + 1) % size;
		arr[rear] = element;
	}
	
	public T serve() throws UnderflowException {
		T element;
		if(this.isEmpty())
			throw new UnderflowException("Queue underflow");
		element = arr[front];
		arr[front] = null;
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		else {
			front = (front + 1) % size;
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

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CirQueue<Integer> obj = new CirQueue<Integer>(4);
//		try {
//			obj.push(1);
//			obj.push(2);
//			obj.push(3);
//			obj.push(4);
//			obj.display();
//			obj.serve();
//			obj.serve();
//			obj.display();
//			obj.push(10);
//			obj.display();
//			obj.push(34);
//			obj.display();
////			obj.push(10);
//			obj.serve();
//			obj.serve();
//			obj.serve();
//			obj.serve();
//			obj.serve();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
		
		CirQueue<String> obj1 = new CirQueue<String>(3);
		try {
			obj1.push("Delhi");
			obj1.push("Tokyo");
			obj1.push("Kolkata");
			obj1.display();
			obj1.serve();
			obj1.display();
			obj1.push("Chennai");
			obj1.display();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}

/*
Output1:

Elements in the queue are: 
1 2 3 4 
Elements in the queue are: 
null null 3 4 
Elements in the queue are: 
10 null 3 4 
Elements in the queue are: 
10 34 3 4 
day4.OverflowException: Queue overflow		// Exception due to overflow


Output2:

Elements in the queue are: 
1 2 3 4 
Elements in the queue are: 
null null 3 4 
Elements in the queue are: 
10 null 3 4 
Elements in the queue are: 
10 34 3 4 
queue.UnderflowException: Queue underflow		// Exception due to underflow


Output3:

Elements in the queue are: 
Delhi Tokyo Kolkata 
Elements in the queue are: 
null Tokyo Kolkata 
Elements in the queue are: 
Chennai Tokyo Kolkata 

*/