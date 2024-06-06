/*package Sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Initially elements are: ");
        printArray(arr);
        
        Heap_sort sorter = new Heap_sort();
        sorter.sort(arr);
        
        System.out.println("\nFinally elements are: ");
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class Heap_sort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i-1, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            
            heapify(arr, n, largest);
        }
    }
}*/



class Solution
{
    //Function to build a Heap from array.
    void swap(int arr[],int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=n/2 -1;i>=0;i--){
            heapify(arr,n,i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[left]>arr[largest]){
            largest=left;
        }
        if(right<n&&arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr,n);
        for(int i=n-1;i>=0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
 }

public class Main{
    public static void main(String[] args){
        int arr[]={12,11,15,66,55};
        Solution s=new Solution();
        s.heapSort(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            
        }

    }
}