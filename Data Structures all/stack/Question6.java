//6. Write a method in a separate class to convert an infix expression to its corresponding prefix expression.

//Step 1: Reverse the infix string, while reversing you must interchange left and right parentheses.
//Step 2: Obtain the postfix expression of the infix expression.
//Step 3: Reverse the postfix expression to get prefix expression.

package stack;

class InfixToPrefix {
	static String reverse(String s) {
		String temp="";
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			if(c == '(') 
				temp += ')';
			else if(c == ')') 
				temp += '(';
			else
				temp += c;
		}
		return temp;
	}
	
	static String infixToPrefix(String s) {
		String revStr = reverse(s);
		InfixToPostfix obj = new InfixToPostfix();
		String postfixRevStr = obj.infixToPostfix(revStr);
		String cast = postfixRevStr.toString();
		String result = reverse(cast);
		return result;
	}
}

public class Question6 {
	public static void main(String args[]) {
		InfixToPrefix obj = new InfixToPrefix();
		
		String exp = "(A-B/C)*(A/K-L)";
		System.out.println("Assuming that the given expression is correct the answer is: " + obj.infixToPrefix(exp));
				
		String exp1 = "a^b^c";
		System.out.println("Assuming that the given expression is correct the answer is: " + obj.infixToPrefix(exp1));
	}
}


/*
Output:

Assuming that the given expression is correct the answer is: *-A/BC-/AKL
Assuming that the given expression is correct the answer is: ^^abc
*/