/*6. Write a program to find whether a matrix is orthogonal or not. Also find the 1-norm of the
matrix. */

class Orthogonal{
	int [][] transpose(int [][]arr){
		int [][] temp=new int [arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				temp[j][i]=arr[i][j];
			}
		}
		return temp;
	}
	void display(int [][]arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	int [][] multiply(int a[][],int b[][]){
		int ans[][]=new int[a.length][b[0].length];
		for(int i=0;i<a.length;i++) {
			for(int k=0;k<b[0].length;k++) {
				int sum=0;
				for(int j=0;j<a[0].length;j++) {
					sum+=a[i][j]*b[j][k];
				}
				ans[i][k]=sum;
			}
		}
		return ans;
	}
	boolean checkIdentity(int [][]mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(i==j&&mat[i][j]!=1) {
					return false;
				}
				if(i!=j&&mat[i][j]!=0)return false;
				
			}
		}
		return true;
	}
	boolean checkOrthogonal(int [][]arr, int trans[][]) {
		int mul[][]=multiply(arr,trans);
		display(mul);
		return checkIdentity(mul);
	}
	int getNorm(int arr[][]){
		int ma=0;
		for(int i=0;i<arr[0].length;i++) {
			int sum=0;
			for(int j=0;j<arr.length;j++) {
				sum+=Math.abs(arr[j][i]);
			}
			ma=Math.max(ma, sum);
		}
		return ma;
	}
	
}
public class Orthogonalcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][]= {
				{2,4,6},
				{1,3,-5},
				{-2,7,9}
		};
		Orthogonal o1=new Orthogonal();
		int trans[][]=o1.transpose(mat);
		System.out.println(o1.checkOrthogonal(mat,trans));
		int mat2[][]= {
				{1,9,8},
				{5,2,6},
				{-5,1,7}
		};
		System.out.println("1-norm of matrix is:"+o1.getNorm(mat2));
	}

}

