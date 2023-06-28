import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // [0] : queue 값, [1] : 시작지점인가? 0 = 시작 지점, 나머지 모든 수 : 나머지 경우
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i < queue1.length; i++){
            sum1 += queue1[i];
            q1.add(new int[]{queue1[i], i});
        }
        for(int i = 0; i < queue2.length; i++){
            sum2 += queue2[i];
            q2.add(new int[]{queue2[i], i});
        }
        
        if( (sum1 + sum2) % 2 == 1)
            return -1;
        
        int cnt = 0;
        int stepCnt = 0;
        while(true){
            // System.out.println(sum1 + " : " + sum2);
            if(sum1 == sum2){
                break;
            }
            else if(sum1 > sum2){
                sum1 -= q1.peek()[0];
                sum2 += q1.peek()[0];
                q2.add(q1.poll());
            }
            else{
                sum2 -= q2.peek()[0];
                sum1 += q2.peek()[0];
                q1.add(q2.poll());
            }
            cnt++;
            stepCnt++;
            
            if(q1.isEmpty() || q2.isEmpty() || stepCnt >= (queue1.length + queue2.length) * 2){
                cnt = -1;
                break;
            }
        }
        return cnt;
    }
}