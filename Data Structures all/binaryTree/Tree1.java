/*
		1
	2		3
 4	   5	   6
 
*/
package binaryTree;
import java.util.*;
public class Tree1 {
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTree {
		static int idx = -1;
		public static Node buildTree(int nodes[]) {
			idx++;
			if(nodes[idx] == -1) 
				return null;
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			
			return newNode;
		}	
	}
	
	public static void preOrder(Node root) {
		if(root == null) 
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void levelOrder(Node root) {
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node currNode = q.remove();
			if(currNode == null) {
				if(!q.isEmpty()) {
					System.out.println();
					q.add(null);
				}
				else {
					break;
				}
			}
			else {
				System.out.print(currNode.data + " ");
				if(currNode.left != null) {
					q.add(currNode.left);
				}
				if(currNode.right != null) {
					q.add(currNode.right);
				}
			}
		}
	}
	
	public static int countNodes(Node root) {
		if(root == null)
			return 0;
		int leftNodes = countNodes(root.left);
		int rightNodes = countNodes(root.right);
		
		return leftNodes + rightNodes + 1;
	}
	
	public static int sumOfNodes(Node root) {
		if(root == null)
			return 0;
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);
		
		return leftSum + rightSum + root.data;
	}
	
	public static int height(Node root) {
		if(root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int myHeight = Math.max(leftHeight, rightHeight) + 1;
		return myHeight;
	}
	
	public static int diameter(Node root) {		// O(n^2) time complexity total
		if(root == null)
			return 0;
		
		int diam1 = diameter(root.left);	// O(n) time complexity
		int diam2 = diameter(root.right);
		int diam3 = height(root.left) + height(root.right) + 1;		// O(n) time complexity
		
		return Math.max(diam3, Math.max(diam1, diam2));
	}
	
	static class TreeInfo {		// class to store height and diameter of a node
		int ht;
		int diam;
		
		TreeInfo(int ht, int diam) {
			this.ht = ht;
			this.diam = diam;
		}
	}
	
	// Here height and diameter are calculated simultaneously
	public static TreeInfo diameter2(Node root) {		// O(n) time complexity
		if(root == null)
			 return new TreeInfo(0, 0);
		
		TreeInfo left = diameter2(root.left);
		TreeInfo right = diameter2(root.right);
		
		int myHeight = Math.max(left.ht, right.ht) + 1;
		
		int diam1 = left.diam;
		int diam2 = right.diam;
		int diam3 = left.ht + right.ht + 1;
		
		int myDiam = Math.max(Math.max(diam1, diam2), diam3);
		TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
		return myInfo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		System.out.println(root.data );
		System.out.println("Preorder traversal");
		preOrder(root);
		System.out.println();
		System.out.println("Inorder traversal");
		inOrder(root);
		System.out.println();
		System.out.println("Postorder traversal");
		postOrder(root);
		System.out.println();
		System.out.println("Level order traversal");
		levelOrder(root);
		System.out.println();
		System.out.println("Number of nodes in the binary tree: " + countNodes(root));
		System.out.println("Sum of all the nodes in the binary tree: " + sumOfNodes(root));
		System.out.println("Heigth of the binary tree: " + height(root));
		System.out.println("Diameter of the binary tree: " + diameter(root));
		System.out.println("Diameter of the binary tree: " + diameter2(root).diam);
	}


}
