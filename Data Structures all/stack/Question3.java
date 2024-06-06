/*
3. Write a method in a separate class to evaluate a postfix expression (Consider more than single 
digit number as a input).
*/

package stack;
import java.util.*;

class PostfixEvaluate {
	public Integer postfixEvaluate(String s) {
		try {
			String arr[] = s.split(" ");
			MyStack<Integer> store = new MyStack<Integer>(arr.length);
			for(int i=0;i<arr.length;i++) {
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
//					System.out.println(operand1);
					String operator = arr[i];
//					System.out.println(operator);
					if(operator.equals("+")==true) {
						temp = operand1 + operand2;
					}
					else if(operator.equals("-")==true) {
						temp = operand1 - operand2;
					}
					else if(operator.equals("*")==true) {
						temp = operand1 * operand2;
					}
					else if(operator.equals("/")==true) {
						temp = operand1 / operand2;
					}
					else {
						temp = operand1 % operand2;
					}
					store.push(temp);
//					System.out.println(temp);
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





public class Question3 {
	public static void main(String args[]) throws Exception {
		String s1 = "9 3 4 * 8 + 4 / -";
		PostfixEvaluate obj = new PostfixEvaluate();
		System.out.println("The result of the postfix expression is: " + obj.postfixEvaluate(s1));
		
		String s2 = "12 20 4 * 120 - 4 / -";
		System.out.println("The result of the postfix expression is: " + obj.postfixEvaluate(s2));
		
		String s3 = "12 20 4 * 120 - 0 / -";
		System.out.println("The result of the postfix expression is: " + obj.postfixEvaluate(s3));
	}
}

/*
Output:

The result of the postfix expression is: 4
The result of the postfix expression is: 22
java.lang.ArithmeticException: / by zero
The result of the postfix expression is: null
*/