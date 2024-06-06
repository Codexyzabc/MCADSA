package binaryTree;
import java.util.*;

class Node {
	Scanner sc = new Scanner(System.in);
	int data;
	Node left;
	Node right;
	
	public Node() {};
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node BuildTree() {
		System.out.println("Enter the data: ");
		int data = sc.nextInt();
		Node root = new Node(data);
		
		if(data == -1)
			return null;
		
		System.out.println("Enter data for inserting in left of " + root.data + " : ");
		root.left = BuildTree();
		System.out.println("Enter data for inserting in right of " + root.data + " : ");
		root.right = BuildTree();
		
		return root;
	}
	
	public void preOrder(Node root) {
		if(root == null) 
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	int count = 0;
	public int countNodes(Node root) {
		if(root == null)
			return 0;
		if(root != null)
			count++;
		countNodes(root.left);
		countNodes(root.right);
		return count;
	}
	
	static int sum = 0;
	public static int sumOfNodes(Node root) {
		if(root == null) 
			return 0;
		if(root != null) 
			sum += root.data;
		sumOfNodes(root.left);
		sumOfNodes(root.right);
		return sum;
	}
}


public class Tree2 {
	public static void main(String args[]) {
		Node tree = new Node();
		Node root = tree.BuildTree();
		// 1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
		System.out.println(root.data);
		tree.preOrder(root);
		System.out.println();
		tree.inOrder(root);
		System.out.println();
		tree.postOrder(root);
		System.out.println();
		System.out.println("Number of nodes in the binary tree: " + tree.countNodes(root));
		System.out.println("Sum of all the nodes in the binary tree: " + tree.sumOfNodes(root));
	}
}
