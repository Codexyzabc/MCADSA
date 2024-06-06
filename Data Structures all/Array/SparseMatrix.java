/*4. Write class SparseMatrix to give a compressed storage representation of a sparse matrix and
also find the transpose of the sparse matrix (from the compressed representation). */

import java.util.*;

class Sparse {
    int[][] convert(int arr[][], int rows, int cols) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] != 0) count++;
            }
        }

        int[][] sp = new int[count][3];
        if (count * 3 >= rows * cols) {
            System.out.println("There's no benefit to convert this matrix into sparse compressed form");
            System.out.println("Returning the given matrix");
            return arr;
        } else {
            count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (arr[i][j] != 0) {
                        sp[count][0] = i;
                        sp[count][1] = j;
                        sp[count][2] = arr[i][j];
                        count++;
                    }
                }
            }
        }
        System.out.println("Converted sparse matrix:");
        display(sp);
        return sp;
    }

    void display(int arr[][]) {
        System.out.println("row\tcol\tvalue");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1] + "\t" + arr[i][2]);
        }
    }

    void transpose(int arr[][], int rows, int cols) {
        Arrays.sort(arr, Comparator.comparingInt(temp -> temp[1]));
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][0];
            arr[i][0] = arr[i][1];
            arr[i][1] = temp;
        }
        System.out.println("Transpose sparse matrix:");
        display(arr);
    }
}

public class SparseMatrix {

    public static void main(String[] args) {

        int sparse[][] = {
                {0, 2, 3},
                {0, 4, 4},
                {1, 2, 5},
                {1, 3, 7},
                {3, 1, 2},
                {3, 2, 6}
        };
        int normalArr[][] = {
                {0, 0, 3, 0, 4},
                {0, 0, 5, 7, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 6, 0, 0}
        };

        int sparseRows = sparse.length;
        int sparseCols = sparse[0].length;
        int normalRows = normalArr.length;
        int normalCols = normalArr[0].length;

        Sparse s1 = new Sparse();
        s1.convert(normalArr, normalRows, normalCols);
        s1.display(sparse);
        s1.transpose(sparse, sparseRows, sparseCols);

    }
}


/*Converted sparse matrix:
row     col     value
0       2       3
0       4       4
1       2       5
1       3       7
3       1       2
3       2       6
row     col     value
0       2       3
0       4       4
1       2       5
1       3       7
3       1       2
3       2       6
Transpose sparse matrix:
row     col     value
1       3       2
2       0       3
2       1       5
2       3       6
3       1       7
4       0       4 */