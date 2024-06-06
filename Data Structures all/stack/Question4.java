/*
4. Write a method in a separate class to evaluate a prefix expression. (Consider more than single 
digit number as a input)
*/

package stack;
import java.util.*;

class PrefixEvaluate {
	public Integer prefixEvaluate(String s) {
		try {
			String arr[] = s.split(" ");
			MyStack<Integer> store = new MyStack<Integer>(arr.length);
			for(int i=arr.length-1;i>=0;i--) {
//				System.out.println(arr[i]);
				if(arr[i].equals("+")==false && arr[i].equals("-")==false && arr[i].equals("*")==false 
						&& arr[i].equals("/")==false && arr[i].equals("%")==false) {
					store.push(Integer.parseInt(arr[i]));
//					System.out.println(Integer.parseInt(arr[i]));
				}
				else {
					Integer operand2 = store.pop();
					Integer operand1 = store.pop();
					Integer temp = 0;
					String operator = arr[i];
//					System.out.println(operator);
					if(operator.equals("+")==true) {
						temp = operand2 + operand1;
					}
					else if(operator.equals("-")==true) {
						temp = operand2 - operand1;
					}
					else if(operator.equals("*")==true) {
						temp = operand2 * operand1;
					}
					else if(operator.equals("/")==true) {
						temp = operand2 / operand1;
					}
					else {
						temp = operand2 % operand1;
					}
					store.push(temp);
				}
			}
			return store.pop();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

public class Question4 {
	public static void main(String args[]) {
		PrefixEvaluate obj = new PrefixEvaluate();
		String s2 ="- 9 / + * 3 4 8 4";
		System.out.println("The result of the prefix expression is: " + obj.prefixEvaluate(s2));
	}
}

/*
Output:

The result of the prefix expression is: 4
*/