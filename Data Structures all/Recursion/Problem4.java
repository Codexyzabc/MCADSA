/*4. Write a recursive function to calculate the sum of all digits of a number entered by the user. */

package Recursion;

import java.util.*;
public class Problem4 {
	public static int sum(int x) {
		if(x==0)return 0;
		
		return x%10+sum(x/10);//calculating remainder and then summing with the quotient
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		System.out.println("answer:"+sum(x));
	}

}
