/*1. Write a recursive function to calculate the gcd of two numbers. */

package Recursion;

public class Problem1 {
	public static int gcd(int a, int b) {
		
		if (a==0) return b;//base case
		if(b==0)return a;//base case
		if(a>b) {
			return gcd(a-b,b);
		}
		return gcd(a,b-a);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=20,b=28;
		System.out.println("gcd of two number is:"+gcd(a,b));
	}

}

