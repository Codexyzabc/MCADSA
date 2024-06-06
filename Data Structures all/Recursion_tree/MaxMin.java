/*
2. Write a recursive function to find the maximum and minimum number is the given list
that solves this using divide and conquer.
*/

package recursion_tree;
/*
import java.util.*;

class mS {

	public void merge(int arr[], int low, int mid, int high) {
		int temp[] = new int[arr.length];
		int c=0;
		int left = low;
		int right = mid + 1;
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right]) {
				temp[c] = arr[left];
				c++;
				left++;
//				System.out.println("Hello1");
			}
			else {
				temp[c] = arr[right];
				c++;
				right++;
//				System.out.println("Hello2");
			}
		} 

		while(left <= mid) {
			temp[c] = arr[left];
			c++;
			left++;
//			System.out.println("Hello3");
		}

		while(right <= high) {
			temp[c] = arr[right];
			c++;
			right++;
//			System.out.println("Hello4");
		}

		for(int i=low;i<=high;i++) {
			arr[i] = temp[i-low];
		}
		
	}
	public void mergeSort(int arr[], int low, int high) {
		if(low >= high) 
			return;
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
	
	public void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void Pair(int arr[]) {
		int low = 0;
		mergeSort(arr, low, arr.length - 1);
		System.out.println("Minimum element is: " + arr[0]);
		System.out.println("Minimum element is: " + arr[arr.length-1]);
	}
}


public class MaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mS mg = new mS();
		int arr[] = {45,9,8,7,6,5,4,43,2,2,1,10};
		mg.Pair(arr);
		mg.printArray(arr);
	}

}
*/
/*
Output

Minimum element is: 1
Minimum element is: 45

*/


//Online Java Compiler
//Use this editor to write, compile and run your Java code online

//class HelloWorld {
//  public static void main(String[] args) {
//      System.out.println("Try programiz.pro");
//  }
//}

import java.util.*;
public class MaxMin {

	public static void merge(int arr[], int low, int mid, int high) {
//		ArrayList<Integer> temp = new ArrayList<>();
		int temp[] = new int[arr.length];
		int c = 0;
		int left = low;
		int right = mid+1;
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right]) {
				// temp.add(arr[left]);
				temp[c] = arr[left];
				c++;
				left++;
			}
			else {
				// temp.add(arr[right]);
				temp[c] = arr[right];
				c++;
				right++;
			}
		}
		while(left <= mid) {
//			temp.add(arr[left]);
			temp[c] = arr[left];
			c++;
			left++;
		}
		while(right <= high) {
//			temp.add(arr[right]);
			temp[c] = arr[right];
			c++;
			right++;
		}

		for(int i=low;i<=high;i++) {
//			arr[i] = temp.get(i-low);   
			arr[i] = temp[i-low];
		}
		
		for(int i=0;i<arr.length;i++) {
		    System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void mS(int arr[], int low, int high) {
		if(low >= high) 
			return;
		int mid = (low + high) / 2;
		mS(arr, low, mid);
		mS(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public static void mergeSort(int[] arr, int n) {
		// Write your code here.
		mS(arr, 0, arr.length-1);
	}
	
	public static void print(int arr[]) {
	    for(int i=0;i<arr.length;i++) {
		    System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String args[]) {
	    int arr[] = {9,7,6,5,4};
//		int arr[] = {45,9,8,7,6,5,4,43,2,2,1,10};
	    mergeSort(arr, arr.length);
	    print(arr);
	}
}