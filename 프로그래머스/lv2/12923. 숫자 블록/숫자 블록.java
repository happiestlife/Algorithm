import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin + 1)];
        
        Arrays.fill(answer, 1);
        if(begin == 1){
            answer[0] = 0;
        }
        for(long i = begin; i <= end; i++){
            int idx = (int)(i - begin);
            
            long sqrt = (long)Math.sqrt(i);
            for(long j = 2; j <= sqrt + 1; j++){
                if(i % j == 0){
                    if(i / j <= 10000000){
                        answer[idx] = (int)(i / j);
                        break;
                    }
                    else{
                        answer[idx] = (int)j;
                    }
                }
            }
        }   
        return answer;
    }
}