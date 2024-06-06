/*8. Write a Program to calculate the length of the string using a recursive function. */

package Recursion;

public class Problem8 {

    
    public static int calculateLength(String str) {
        // Base case: if the string is empty, its length is 0
        if (str.isEmpty()) {
            return 0;
        } else {
            //recursive calling of function starting at index 1
            return 1 + calculateLength(str.substring(1));
        }
    }

    public static void main(String[] args) {
        String inputString = "Hello, world!";
        int length = calculateLength(inputString);
        System.out.println("Length of the string '" + inputString + "' is: " + length);
    }
}
