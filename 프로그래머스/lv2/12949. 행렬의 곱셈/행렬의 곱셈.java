class Solution {
    public long[][] solution(int[][] arr1, int[][] arr2) {
        // 그냥 곱하기
        long[][] rs = new long[arr1.length][arr2[0].length];
        int row = 0, col = 0;
        for (int i = 0; i < rs.length; i++) {
            for (int j = 0; j < rs[0].length; j++) {
                rs[i][j] = calc(arr1[row], arr2, col);

                col++;
                if(col >= rs[0].length){
                    row++;
                    col = 0;
                }
            }
        }
        
        return rs;
    }
    
    public static long calc(int[] arr1, int[][] arr2, int col) {
        long rs = 0;

        for (int i = 0; i < arr1.length; i++) {
            rs += (long) arr1[i] * arr2[i][col];
        }

        return rs;
    }
}