/*
1. Write functions to implement a solution to Towers of Hanoi problem. Check your
program with number of disks = 0, 1, 2 and 3.
*/

package recursion_tree;

public class TowerOfHanoi {
	
	static void towerOfHanoi(int n, char S, char D, char A) {
		if(n == 0)
			return;
		
		towerOfHanoi(n-1, S, A, D);
		System.out.println("Moving disk " + n + " from " + S + " to " + D);
		towerOfHanoi(n-1, A, D, S);
	}
	
	public static void main(String args[]) {
		towerOfHanoi(4, 'A', 'C', 'B');
	}
}


/*
Output

Moving disk 1 from A to B
Moving disk 2 from A to C
Moving disk 1 from B to C
Moving disk 3 from A to B
Moving disk 1 from C to A
Moving disk 2 from C to B
Moving disk 1 from A to B
Moving disk 4 from A to C
Moving disk 1 from B to C
Moving disk 2 from B to A
Moving disk 1 from C to A
Moving disk 3 from B to C
Moving disk 1 from A to B
Moving disk 2 from A to C
Moving disk 1 from B to C

*/