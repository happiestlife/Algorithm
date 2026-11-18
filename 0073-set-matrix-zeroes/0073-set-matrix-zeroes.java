import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] isPaintedZero = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isPaintedZero[i][j] || matrix[i][j] != 0) continue;

                for(int k = 0; k < n; k++) {
                    if(matrix[i][k] != 0) {
                        isPaintedZero[i][k] = true;
                        matrix[i][k] = 0;
                    }
                }
                for(int k = 0; k < m; k++) {
                    if(matrix[k][j] != 0) {
                        isPaintedZero[k][j] = true;
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}