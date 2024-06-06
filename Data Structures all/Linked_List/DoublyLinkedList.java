/*1. Write a menu driven program to implement a doubly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list*/

package Linked_List;



import java.util.*;

class Node {
    Node prev;
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    static Node start = null;

    static Node createNode(int item) {
        return new Node(item);
    }

    static void insert_at_beg() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a node value which you want to insert at the beginning of the linked list:");
        int item = scanner.nextInt();
        Node p = createNode(item);

        if (start == null) {
            start = p;
            System.out.println("\nNew node value " + item + " inserted at the beginning of the linked list");
        } else {
            p.next = start;
            start.prev = p;
            start = p;
            System.out.println("\nNew node value " + item + " inserted at the beginning of the linked list");
        }
    }

    static void insert_at_end() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a node value which you want to insert at the end of the linked list:");
        int item = scanner.nextInt();
        Node p = createNode(item);

        if (start == null) {
            start = p;
            System.out.println("\nThe linked list is empty so new node value " + item + " will be inserted at start");
        } else {
            Node q = start;
            while (q.next != null) {
                q = q.next;
            }
            q.next = p;
            p.prev = q;
            System.out.println("\nNew node value " + item + " inserted at the end of the linked list");
        }
    }

    static void insert_before_a_node() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the node value which you want to insert:");
        int item = scanner.nextInt();
        Node p = createNode(item);

        if (start == null) {
            System.out.println("\nThe linked list is empty so, new node value " + item + " will be inserted at start");
            start = p;
        } else {
            System.out.print("\nEnter the node value before which you want to insert the new node:");
            int key = scanner.nextInt();
            Node q = start;
            while (q != null && q.data != key) {
                q = q.next;
            }
            if (q == null) {
                System.out.println("\nNo such node value present in the linked list so, Insertion is not possible...!");
            } else if (q == start) {
                p.next = start;
                start.prev = p;
                start = p;
                System.out.println("\nNew node value " + item + " inserted before the node value " + key);
            } else {
                p.prev = q.prev;
                p.next = q;
                q.prev.next = p;
                q.prev = p;
                System.out.println("\nNew node value " + item + " inserted before the node value " + key);
            }
        }
    }

    static void insert_after_a_node() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the node value which you want to insert:");
        int item = scanner.nextInt();
        Node p = createNode(item);

        if (start == null) {
            System.out.println("\nThe linked list is empty so, new node value " + item + " will be inserted at start");
            start = p;
        } else {
            System.out.print("\nEnter the node value after which you want to insert the new node:");
            int key = scanner.nextInt();
            Node q = start;
            while (q != null && q.data != key) {
                q = q.next;
            }
            if (q == null) {
                System.out.println("\nNo such node value present in the linked list so, Insertion is not possible...!");
            } else if (q.next == null) {
                p.prev = q;
                q.next = p;
                System.out.println("\nNew node value " + item + " inserted after the node value " + key);
            } else {
                p.prev = q;
                p.next = q.next;
                q.next.prev = p;
                q.next = p;
                System.out.println("\nNew node value " + item + " inserted after the node value " + key);
            }
        }
    }

    static void delete_from_beg() {
        if (start == null) {
            System.out.println("\nThe linked list is empty so, Deletion is not possible...!");
        } else {
            Node p = start;
            if (p.next == null) {
                start = null;
                System.out.println("\nDeleted node value from the beginning is " + p.data);
            } else {
                p.next.prev = null;
                start = p.next;
                System.out.println("\nDeleted node value from the beginning is " + p.data);
            }
        }
    }

    static void delete_from_end() {
        if (start == null) {
            System.out.println("\nThe linked list is empty so, Deletion is not possible...!");
        } else {
            Node p = start;
            while (p.next != null) {
                p = p.next;
            }
            if (p == start) {
                start = null;
                System.out.println("\nDeleted node value from the end is " + p.data);
            } else {
                p.prev.next = null;
                System.out.println("\nDeleted node value from the end is " + p.data);
            }
        }
    }

    static void delete_particular_node() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the node value which you want to delete:");
        int key = scanner.nextInt();

        if (start == null) {
            System.out.println("\nThe linked list is empty so, Deletion is not possible...!");
        } else {
            Node p = start;
            while (p != null && p.data != key) {
                p = p.next;
            }
            if (p == null) {
                System.out.println("\nNo such node value present in the linked list so, Deletion is not possible...!");
            } else if (p == start) {
                if (p.next == null) {
                    start = null;
                    System.out.println("\n Deleted node value is " + p.data);
                } else {
                    p.next.prev = null;
                    start = p.next;
                    System.out.println("\n Deleted node value is " + p.data);
                }
            } else if (p.next == null) {
                p.prev.next = null;
                System.out.println("\n Deleted node value is " + p.data);
            } else {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                System.out.println("\n Deleted node value is " + p.data);
            }
        }
    }

    static void forward_traverse() {
        if (start == null) {
            System.out.println("\nLinked list is empty so, Traversal is not possible...!");
        } else {
            Node p = start;
            System.out.print("\nSTART-->");
            while (p != null) {
                System.out.print("|" + p.data + "|-->");
                p = p.next;
            }
            System.out.print("NULL");
        }
    }

    static void reverse_traverse() {
        if (start == null) {
            System.out.println("\nLinked list is empty so, Traversal is not possible...!");
        } else {
            Node p = start;
            while (p.next != null) {
                p = p.next;
            }
            System.out.print("\nSTART-->");
            while (p != null) {
                System.out.print("|" + p.data + "|-->");
                p = p.prev;
            }
            System.out.print("NULL");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n\n1.INSERTION\n2.DELETION\n3.TRAVERSAL\n4.EXIT from the System");
            System.out.print("\n\nEnter your choice:");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    char sch;
                    do {
                        System.out.println("\n\nWhich Insertion method do you want to perform?");
                        System.out.println("\n\na.Insertion at beginning\nb.Insertion at end\nc.Insertion before particular node\nd.Insertion after a particular node\ne.Quit Insertion and back to Main Menu");
                        System.out.print("\n\nEnter your choice:");
                        sch = scanner.next().charAt(0);
                        switch (sch) {
                            case 'a':
                                insert_at_beg();
                                break;
                            case 'b':
                                insert_at_end();
                                break;
                            case 'c':
                                insert_before_a_node();
                                break;
                            case 'd':
                                insert_after_a_node();
                                break;
                            case 'e':
                                break;
                            default:
                                System.out.println("\nWrong Choice...!");
                        }
                    } while (sch != 'e');
                    break;

                case 2:
                    do {
                        System.out.println("\n\nWhich Deletion method do you want to perform?");
                        System.out.println("\n\na.Deletion from beginning\nb.Deletion from end\nc.Deletion of a particular node\nd.Quit Deletion and back to Main Menu");
                        System.out.print("\n\nEnter your choice:");
                        sch = scanner.next().charAt(0);
                        switch (sch) {
                            case 'a':
                                delete_from_beg();
                                break;
                            case 'b':
                                delete_from_end();
                                break;
                            case 'c':
                                delete_particular_node();
                                break;
                            case 'd':
                                break;
                            default:
                                System.out.println("\nWrong Choice...!");
                        }
                    } while (sch != 'd');
                    break;

                case 3:
                    do {
                        System.out.println("\n\nWhich Traversal method do you want to perform?");
                        System.out.println("\n\na.Forward Traversal\nb.Reverse Traversal\nc.Quit Traversal and back to Main Menu");
                        System.out.print("\n\nEnter your choice:");
                        sch = scanner.next().charAt(0);
                        switch (sch) {
                            case 'a':
                                forward_traverse();
                                break;
                            case 'b':
                                reverse_traverse();
                                break;
                            case 'c':
                                break;
                            default:
                                System.out.println("\nWrong Choice...!");
                        }
                    } while (sch != 'c');
                    break;

                case 4:
                    System.out.println("\nExit from the system....)");
                    break;

                default:
                    System.out.println("\nWrong Choice...!");
            }
        } while (ch != 4);
    }
}
