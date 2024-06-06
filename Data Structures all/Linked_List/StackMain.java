package Linked_List;

import java.util.Scanner;

class Node {
    int info;
    Node next;

    Node(int info) {
        this.info = info;
        this.next = null;
    }
}

class Stack {
    Node top;

    Stack() {
        this.top = null;
    }

    void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        System.out.println("Element inserted: " + item);
    }

    void pop() {
        if (top == null) {
            System.out.println("No node to delete, underflow");
            return;
        }
        System.out.println("Node deleted: " + top.info);
        top = top.next;
    }

    void display() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }
        Node p = top;
        System.out.println("Elements of stack:");
        while (p != null) {
            System.out.println("|" + p.info + "|");
            p = p.next;
        }
    }
}

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPress 1 for push");
            System.out.println("Press 2 for pop");
            System.out.println("Press 3 for display");
            System.out.println("Press 4 for exit from system");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int item = scanner.nextInt();
                    stack.push(item);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exit from the system");
                    break;
                default:
                    System.out.println("Wrong Choice!!");
            }
        } while (choice != 4);
        scanner.close();
    }
}
