/*2. Write a menu driven program to implement a doubly circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list*/


import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class CircularLinkedList {
    static Node start = null;

    static Node getNode(int item) {
        return new Node(item);
    }

    static void insertAtBeginningCircularDLL(int item) {
        Node temp = getNode(item);
        if (start == null) {
            start = temp;
            start.next = start;
            System.out.println("\nNew node value " + item + " inserted at the beginning of the linked list");
        } else if (start.next == start) {
            temp.next = start;
            start.prev = temp;
            temp.prev = start;
            start.next = temp;
            start = temp;
            System.out.println("\nNew node value " + item + " inserted at the beginning of the linked list");
        } else {
            temp.next = start;
            temp.prev = start.prev;
            start.prev.next = temp;
            start.prev = temp;
            start = temp;
            System.out.println("\nNew node value " + item + " inserted at the beginning of the linked list");
        }
    }

    static void insertAtEndCircularDLL(int item) {
        Node temp = getNode(item);
        if (start == null) {
            start = temp;
            start.next = start;
            System.out.println("\nThe linked list is empty so new node value " + item + " will be inserted at start");
        } else if (start.next == start) {
            temp.prev = start;
            start.next = temp;
            temp.next = start;
            start.prev = temp;
            System.out.println("\nNew node value " + item + " inserted at the end of the linked list");
        } else {
            Node p = start;
            while (p.next != start) {
                p = p.next;
            }
            temp.prev = p;
            temp.next = p.next;
            p.next.prev = temp;
            p.next = temp;
            System.out.println("\nNew node value " + item + " inserted at the end of the linked list");
        }
    }

    static void deleteFromBeginningCircularDLL() {
        if (start == null) {
            System.out.println("\nThe linked list is empty so, Deletion is not possible...!");
        } else {
            Node p = start;
            if (p.next == start) {
                start = null;
                System.out.println("\nDeleted node value from the beginning is " + p.data);
            } else {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                start = start.next;
                System.out.println("\nDeleted node value from the beginning is " + p.data);
            }
        }
    }

    static void deleteFromEndCircularDLL() {
        if (start == null) {
            System.out.println("\nThe linked list is empty so, Deletion is not possible...!");
        } else {
            Node p = start;
            while (p.next != start) {
                p = p.next;
            }
            if (p == start) {
                start = null;
                System.out.println("\nDeleted node value from the end is " + p.data);
            } else {
                p.next.prev = p.prev;
                p.prev.next = p.next;
                System.out.println("\nDeleted node value from the end is " + p.data);
            }
        }
    }

    static void printCircularDLL() {
        if (start == null) {
            System.out.println("\nDoubly Linked List is empty so, cannot be printed...!");
        } else {
            Node p = start;
            System.out.println("\nElements of the Circular Doubly Linked List in forward direction:");
            do {
                System.out.print("\t" + p.data);
                p = p.next;
            } while (p != start);

            System.out.println("\nElements of the Circular Doubly Linked List in backward direction:");
            do {
                System.out.print("\t" + p.data);
                p = p.prev;
            } while (p != start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch, item;
        do {
            System.out.println("\n1.Insert at beginning of Circular DLL\n2.Insert at end of Circular DLL\n3.Delete from beginning of Circular DLL\n4.Delete from end of Circular DLL\n5.Display Circular DLL\n6.Exit from the System");
            System.out.print("\nEnter your choice:");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("\nEnter the node value to be inserted:");
                    item = scanner.nextInt();
                    insertAtBeginningCircularDLL(item);
                    break;
                case 2:
                    System.out.print("\nEnter the node value to be inserted:");
                    item = scanner.nextInt();
                    insertAtEndCircularDLL(item);
                    break;
                case 3:
                    deleteFromBeginningCircularDLL();
                    break;
                case 4:
                    deleteFromEndCircularDLL();
                    break;
                case 5:
                    printCircularDLL();
                    break;
                case 6:
                    System.out.println("\nExit from the System....");
                    break;
                default:
                    System.out.println("\nInvalid Choice...!");
            }
        } while (ch != 6);
    }
}
