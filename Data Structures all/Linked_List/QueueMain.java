/*2. Write a program to implement a queue using linked list, such that the operations
‘enqueue’ and ‘dequeue’ are performed in constant time.*/

package Linked_List;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int item) {
        this.data = item;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;

    Queue() {
        this.front = null;
        this.rear = null;
    }

    void insertion(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            rear = newNode;
            front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("\nElement inserted: " + item);
    }

    void deletion() {
        if (front == null) {
            System.out.println("\nQueue is empty, nothing to delete.");
            return;
        }
        System.out.println("\nElement deleted: " + front.data);
        front = front.next;
        if(front==null) rear=null;
    }

    void display() {
        Node temp = front;
        if (front == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Resultant Queue is:");
            System.out.print("front");
            while (temp != null) {
                System.out.print("-->|" + temp.data + "|");
                temp = temp.next;
            }
            System.out.println("<--rear");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPress 1 for insertion");
            System.out.println("Press 2 for deletion");
            System.out.println("Press 3 for display");
            System.out.println("Press 4 for exit from system");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int item = scanner.nextInt();
                    queue.insertion(item);
                    break;
                case 2:
                    queue.deletion();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("\nExit from the system");
                    break;
                default:
                    System.out.println("\nWrong Choice!!");
            }
        } while (choice != 4);
        scanner.close();
    }
}
