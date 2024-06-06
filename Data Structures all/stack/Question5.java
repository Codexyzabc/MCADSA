//5. Write a method in a separate class to convert an infix expression to its corresponding postfix expression.

/*
Input: A + B * C + D
Output: ABC*+D+

Input: ((A + B) – C * (D / E)) + F
Output: AB+CDE/*-F+  

Below are the steps to implement the above idea:

1. Scan the infix expression from left to right. 
2. If the scanned character is an operand, put it in the postfix expression. 
3. Otherwise, do the following
	1. If the precedence and associativity of the scanned operator are greater than the precedence and associativity 
	of the operator in the stack [or the stack is empty or the stack contains a ‘(‘ ], then push it in the stack. 
	[‘^‘ operator is right associative and other operators like ‘+‘,’–‘,’*‘ and ‘/‘ are left-associative].
	
		1. Check especially for a condition when the operator at the top of the stack and the scanned operator both are ‘^‘. 
		In this condition, the precedence of the scanned operator is higher due to its right associativity. 
		So it will be pushed into the operator stack.
		 
		2. In all the other cases when the top of the operator stack is the same as the scanned operator, then pop the 
		operator from the stack because of left associativity due to which the scanned operator has less precedence. 
		
	2. Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator.
		
		1. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then 
		stop there and push the scanned operator in the stack.) 
		
4. If the scanned character is a ‘(‘, push it to the stack. 
5. If the scanned character is a ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis. 
6. Repeat steps 2-5 until the infix expression is scanned. 
7. Once the scanning is over, Pop the stack and add the operators in the postfix expression until it is not empty.
8. Finally, print the postfix expression.
*/


package stack;
import java.util.*;
class InfixToPostfix {
	static int precedence(char c) {
		if(c == '^')
			return 3;
		else if(c == '*' || c == '/')
			return 2;
		else if(c == '+' || c == '-')
			return 1;
		else
			return -1;
	}
	
	static char associativity(char c) {
		if(c == '^') 
			return 'R';
		return 'L';
	}
	
	static String infixToPostfix(String s) {
		s ="(" + s + ")";
		String result = "";
		try {
			
			MyStack<Character> operator = new MyStack<Character>(s.length());
			
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
//				System.out.println(c);
				if(c == '(') {
					operator.push('(');
				}
				else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
					result += c;
//					System.out.println("Result1" + result);
				}
				else if(c == '(') {
					operator.push('(');
				}
				else if(c == ')') {
					while(!operator.isEmpty() && operator.peek() != '(') {
						result += operator.pop();
//						System.out.println("Result2" + result);
					}
					operator.pop();
				}
				else {
					while(!operator.isEmpty() && (precedence(c) <= precedence(operator.peek()) && associativity(c) == 'L')) {
						result += operator.pop();
//						System.out.println("Result3" + result);
					}
					operator.push(c);
				}				
			}
			
			while(!operator.isEmpty()) {
				result += operator.pop();
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
}

public class Question5 {
	public static void main(String args[]) {
		InfixToPostfix obj = new InfixToPostfix();
		
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Assuming that the given expression is correct the answer is: " + obj.infixToPostfix(exp));

		String exp1 = "(A-B/C)*(A/K-L)";
		System.out.println("Assuming that the given expression is correct the answer is: " + obj.infixToPostfix(exp1));
		
		String exp2 = "a^b^c";
		System.out.println("Assuming that the given expression is correct the answer is: " + obj.infixToPostfix(exp2));
	}
}

/*
Output:

Assuming that the given expression is correct the answer is: abcd^e-fgh*+^*+i-
Assuming that the given expression is correct the answer is: ABC/-AK/L-*
*/



/*
// GFG

import java.util.Stack;

public class InfixToPostfix {

	// Function to return precedence of operators
	static int prec(char c) {
		if (c == '^')
			return 3;
		else if (c == '/' || c == '*')
			return 2;
		else if (c == '+' || c == '-')
			return 1;
		else
			return -1;
	}

	// Function to return associativity of operators
	static char associativity(char c) {
		if (c == '^')
			return 'R';
		return 'L'; // Default to left-associative
	}

	// The main function to convert infix expression to postfix expression
	static void infixToPostfix(String s) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// If the scanned character is an operand, add it to the output string.
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
				result.append(c);
			}
			// If the scanned character is an ‘(‘, push it to the stack.
			else if (c == '(') {
				stack.push(c);
			}
			// If the scanned character is an ‘)’, pop and add to the output string from the stack
			// until an ‘(‘ is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				stack.pop(); // Pop '('
			}
			// If an operator is scanned
			else {
				while (!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.peek()) ||
											prec(s.charAt(i)) == prec(stack.peek()) &&
												associativity(s.charAt(i)) == 'L')) {
					result.append(stack.pop());
				}
				stack.push(c);
			}
		}

		// Pop all the remaining elements from the stack
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		System.out.println(result);
	}

	// Driver code
	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";

		// Function call
		infixToPostfix(exp);
	}
}


// Suvankar
 
package dsa_stack;
import dsa_stack.Stack;
import java.util.*;
public class Problem5 {
	public static int getVal(char ch) {
		//the function where it returns the presidence value according to the symbol
		HashMap<Character ,Integer> m=new HashMap<Character,Integer>();
		m.put('+',1);
		m.put('-',1);
		m.put('*', 2);
		m.put('/', 2);
		m.put('^',3);
		return m.get(ch)==null?-1:m.get(ch);
	}
	static String eval(String s) {
		s="("+s+")";
		String output="";
		try {
			
			Stack<Character> st=new Stack<Character>(s.length());//declaring my own stack which is imported from the first problem
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']') {// checking if it is closing brackets.. if it is, then removing symbols until getting an opening one..
					while((!st.isEmpty())&&(st.peek()!='('&&st.peek()!='{'&&st.peek()!='[')) {
						output+=st.peek();
						st.pop();
						
					}
					st.pop();
				}
				 else if((s.charAt(i)>=48&&s.charAt(i)<=57)||(s.charAt(i)>=64&&s.charAt(i)<=90)||(s.charAt(i)>=97&&s.charAt(i)<=122)) {// if it is not a bracket or a operator.. then insert it into answer
					 
					 output+=s.charAt(i);
				 }
				else {//if it is any operator, then taking action. 
					if(s.charAt(i)=='^')//if operator is ^ then follow the right associativity
					while(getVal(s.charAt(i))!=-1&&getVal(st.peek())!=-1&&(getVal(s.charAt(i))<getVal(st.peek()))) {
						output+=st.peek();
						st.pop();
						
					}
					else {//else using normal logic for left associativity.. 
						while(getVal(s.charAt(i))!=-1&&getVal(st.peek())!=-1&&(getVal(s.charAt(i))<=getVal(st.peek()))) {
							output+=st.peek();
							st.pop();
							
						}
					}
					st.push(s.charAt(i));// lastly add the current operator
				}
			}
		}catch(Exception e) {
			
		}
		return output;// and all set
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("assuming that the given expression is correct");
		String s="((a+b*c-d)+f-g)";
		System.out.println(eval(s));
	}

}



*/
