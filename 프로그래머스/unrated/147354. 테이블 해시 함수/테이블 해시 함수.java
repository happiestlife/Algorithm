import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 1. 정렬
        final int standard = col - 1;
        Arrays.sort(data, (r1, r2) -> {
            if(r1[standard] == r2[standard]){
                return r2[0] - r1[0];
            } 
            else{
                return r1[standard] - r2[standard];
            }
        });
        
        // 2. 누적 S_i 구하기 & xor
        for(int i = row_begin - 1; i < row_end; i++){
            int[] row = data[i];
            int sum = 0;
            for(int j = 0; j < row.length; j++){
                sum += row[j] % (i + 1);
            }
            answer = answer ^ sum;
        }
        
        return answer;
    }
}