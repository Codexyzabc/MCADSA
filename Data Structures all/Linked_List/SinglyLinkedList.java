/*
 * 1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists
 */


package Linked_List;

import java.util.*;


class Node{
  int data;
  Node next;
  
  Node(int data){
    this.data=data;
    this.next=null;
  }
}

public class SinglyLinkedList {
  Scanner sc=new Scanner(System.in);
  public Node start;
  
  public SinglyLinkedList(){
    start=null;
  }
  
  public Node createNode(int data) {
    return new Node(data);
  }
  
  void insert_at_beg(int data) {
    Node p=createNode(data);
    
    if(start==null) {//if the list is empty
      start=p;
    }
    else {//non empty
      p.next=start;
      start=p;
    }
  }
  
  void insert_at_end(int data) {
    Node s;
        Node p=createNode(data);
    
    if(start==null) {//if the list is empty
      start=p;
    }
    else {//non empty
      s=start;
      while(s.next!=null) {
        s=s.next;
      }
      s.next=p;
    }
  }
  
  void insert_at_pos(int data, int pos) {
    if(pos<=0) {
      System.out.println("invalid position");
      return;
    }
    if(pos==1) {
      insert_at_beg(data);
      return;
    }
    
    Node p=createNode(data);
    
    Node current=start;
    
    int curpos=1;
    
    while(curpos<pos-1 && current!=null) {
      current=current.next;
      curpos++;
    }
    
    if(current==null) {
      System.out.println("Invalid position");
      return;
    }
    p.next=current.next;
    current.next=p;
  }
  
  
  
  
  
  void insert_after_a_node(int data){
    Node s;
//    System.out.println("Enter the node value to insert");
//    int val=sc.n
    
        Node p=createNode(data);
    
    if(start==null) {//if the list is empty
      start=p;
    }
    else {
      System.out.println("Enter node after which to insert");
      int key=sc.nextInt();
      
      s=start;
      while(s!=null & s.data!=key) {
    	  s=s.next;
      }
      if(s==null) {
    	  System.out.println("No such node present");
    	  return;
      }
      else {
    	  p.next=s.next;
    	  s.next=p;
      }
      
    }
    
  }
  
  void delete_from_beg() {
	  Node p;
	  if(start==null) {
		  System.out.println("List is empty nothing to delete");
	  }
	  else {
		  p=start;
		  start=p.next;
		  System.out.println("deleted node value is"+ p.data);
		  
	  }
  }
  void delete_from_end() {
	  Node p,s=null;
	  if(start==null) {
		  System.out.println("List is empty nothing to delete");
	  }
	  else {
		  p=start;
		  while(p.next!=null) {
			  s=p;
			  p=p.next;
		  }
		  if(p==start) {
			  start=null;
			  System.out.println("deleted node value is"+ p.data);
		  }
		  else {
			  s.next=null;
			  System.out.println("deleted node value is"+ p.data);
		  }
	  }
  }
  void delete_particular_node() {
	  Node p,s=null;
	  int key;
	  if(start==null) {
		  System.out.println("List is empty nothing to delete");
	  }
	  else {
		  System.out.println("Enter node to delete");
		  key=sc.nextInt();
		  p=start;
		  while(p!=null && p.data!=key) {
			  s=p;
			  p=p.next;
		  }
		  if(p==null) {
			  System.out.println("no such node to delete");
		  }
		  else if(p==start){
			  start=p.next;
			  System.out.println("deleted node value is"+ p.data);
		  }
		  else {
			  s.next=p.next;
			  System.out.println("deleted node value is"+ p.data);
		  }
	  }
  }
  void delete_at_pos() {
	  if(start==null) {
		  System.out.println("List is empty nothing to delete");
	  }
	  System.out.println("Enter the pos for which node to be deleted");
	  int pos=sc.nextInt();
	  if(pos<=0) {
	      System.out.println("invalid position");
	      return;
	    }
	    if(pos==1) {
	      delete_from_beg();
	      return;
	    }
	    Node current=start;
	    
	    int curpos=1;
	    
	    while(curpos<pos-1 && current!=null) {
	      current=current.next;
	      curpos++;
	    }
	    
	    if(current==null) {
	      System.out.println("Invalid position");
	      return;
	    }
	    current.next=current.next.next;
  }
  
    void display() {
	    if(start==null) {
	      System.out.println("List is empty");
	      return;
	    }
	    Node p=start;
	    System.out.print("\nSTART-->");
		while(p!=null) {
			System.out.print("|"+ p.data + "|-->");
			p=p.next;
		}
		System.out.print("null");
	  }
    
    boolean linear_search() {
    	int key;
    	System.out.println("Enter the node to search");
    	key=sc.nextInt();
    	
    	Node p;
    	p=start;
    	while(p!=null) {
    		if(p.data==key) {
    			return true;
    		}
    		p=p.next;    		
    	}
    	return false;
    }
    
    int countNodes() {
    	int count=0;
    	Node p=start;
    	
    	while(p!=null) {
    		count++;
    		p=p.next;
    	}
    	return count;
    }
    
    void reverse_traverse() {
    	
    	Node p,s,r;
    	
    	if(start==null) {
    		System.out.println("linked list is empty, so traversal not posssible");
    	}
    	else {
    		p=start;
    		s=p.next;
    		p.next=null;
    		while(s!=null) {
    			r=s.next;
    			s.next=p;
    			p=s;
    			s=r;
    		}
    		start=p;
    		
    		System.out.print("\nSTART-->");
    		while(p!=null) {
    			System.out.print("|"+ p.data + "|-->");
    			p=p.next;
    		}
    		System.out.print("null");
    	}
    }
    
    void concatenate(SinglyLinkedList list2) {
        if (start == null) {
            start = list2.start; // If the first list is empty, set it to the second list
        } else {
            Node current = start;
            // Traverse the first list to find the last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = list2.start; // Concatenate the second list to the end of the first list
        }
    }
  
  
  
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    
    SinglyLinkedList list= new SinglyLinkedList();
    
    int choice;
    
    while(true){
      System.out.println("\n Single linked list operations");
      System.out.println("1.insert at front");
      System.out.println("2.insert at end");
      System.out.println("3.insert at any pos");
      System.out.println("4.insert after a element");
      System.out.println("5.delete from beg ");
      System.out.println("6.delete from end");
      System.out.println("7.delete at pos");
      System.out.println("8.delete particular ele");
      System.out.println("9.forward traverse");
      System.out.println("10.reverse traverse");
      System.out.println("11.linear search");
      System.out.println("12.count number of nodes");
      System.out.println("13.concatenate two lists");
      System.out.println("14. to exit");
      //System.out.println("\n 4.to exit");
      System.out.println("Enter your choice: ");
      choice=sc.nextInt();
      
      switch(choice) {
      case 1: System.out.println("Enter the element to insert");
              int data=sc.nextInt();
              list.insert_at_beg(data);
              break;
      case 2: System.out.println("Enter the element to insert");
              int data1=sc.nextInt();
              list.insert_at_end(data1);
              break;
      case 3: System.out.println("Enter the element to insert and position");
            int data2=sc.nextInt();
            sc.nextLine();
            int pos=sc.nextInt();
            list.insert_at_pos(data2,pos);
            break;
      case 4: System.out.println("Enter the element to insert");
      			int data3=sc.nextInt();
      			list.insert_after_a_node(data3);
      			break;
      case 5: list.delete_from_beg();
              break;
      case 6: list.delete_from_end();
              break;
      case 7: list.delete_at_pos();
      		  break;
      case 8: list.delete_particular_node();
              break;
      case 9: list.display();
              break;
      case 10:list.reverse_traverse();
      			break;
      case 11: if(list.linear_search()) {
    	      System.out.println("Element found");
      }else {
    	  System.out.println("Not Found");
      }
      			break;
      case 12: int a=list.countNodes();
               System.out.println("no of nodes"+ a);
               break;
      case 13: SinglyLinkedList list2 = new SinglyLinkedList();
      			System.out.println("Enter elements for the second list (enter -1 to stop):");
      			int data11;
      			while ((data11 = sc.nextInt()) != -1) {
      				list2.insert_at_end(data11);
      			}
      			list.concatenate(list2);
      			System.out.println("Lists concatenated");
      			break;
      case 14: System.exit(0);
                break;
      //case 5: System.out.println("Display");
 
      //case 4: System.exit(0);
      
      default: System.out.println("Wrong choice!!");
     }
    
       }
   }
  
}