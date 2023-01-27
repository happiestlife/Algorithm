import java.util.Arrays;

class Solution {
    public long solution(int k, int m, int[] score) {
        Arrays.sort(score);

        long rs = 0;
        int i = score.length;
        while(i >= 0){
            if(i / m == 0)
                break;
            i -= m;
            rs += score[i] * (long)m;
        }
        
        return rs;
    }
}