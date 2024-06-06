/*5. Write a Class CheckTriangular within that implement methods to check whether a matrix is
i) Lower triangular ii) Upper triangular iii) Diagonal iv) Identity v) Tridiagonal. */


public class CheckTriangular {
    
    public static boolean isLowerTriangular(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUpperTriangular(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentity(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isTridiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Math.abs(i - j) > 1 && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] lowerTriangular = {{1, 0, 0}, {2, 3, 0}, {4, 5, 6}};
        System.out.println("Lower Triangular: " + isLowerTriangular(lowerTriangular));

        int[][] upperTriangular = {{1, 2, 3}, {0, 4, 5}, {0, 0, 6}};
        System.out.println("Upper Triangular: " + isUpperTriangular(upperTriangular));

        int[][] diagonal = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
        System.out.println("Diagonal: " + isDiagonal(diagonal));

        int[][] identity = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println("Identity: " + isIdentity(identity));

        int[][] tridiagonal = {{1, 2, 0}, {3, 4, 5}, {0, 6, 7}};
        System.out.println("Tridiagonal: " + isTridiagonal(tridiagonal));
    }
}


/*Lower Triangular: true
Upper Triangular: true
Diagonal: true
Identity: true
Tridiagonal: true */