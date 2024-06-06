// 2. Write a method in a separate class to check an expression is valid or not. 

package stack;
import java.util.*;


class CheckExpression {
	public boolean CheckExpression(String s){
		try {
			
			MyStack<Character> st = new MyStack<Character>(s.length());
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
					st.push(s.charAt(i));
				}
				if(s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']') {
					Character ch = st.pop();
					if(s.charAt(i)==')' && ch!='(' || s.charAt(i)=='}' && ch!='{' || s.charAt(i)==']' && ch!='[' ) {
						return false;
					}
				}
			}
			if(!st.isEmpty())
				return false;
			return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
}

public class Question2 {
	public static void main(String args[]) throws Exception{
		String s1 = "(a+b)*(c+d)";
		CheckExpression c1 = new CheckExpression();
		System.out.println("The expression is valid: " + c1.CheckExpression(s1));
		
		String s2 = "((a+b)*(c+d)";
		System.out.println("The expression is valid: " + c1.CheckExpression(s2));
		
		String s3 = "(a+b)*[(c+d)+g]";
		System.out.println("The expression is valid: " + c1.CheckExpression(s3));
		
		String s4 = "((a+b)*(c+d)}";
		System.out.println("The expression is valid: " + c1.CheckExpression(s4));
	}
}

/*
Output:

The expression is valid: true
The expression is valid: false
The expression is valid: true
The expression is valid: false
*/