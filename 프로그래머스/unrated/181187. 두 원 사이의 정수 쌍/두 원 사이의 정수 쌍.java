class Solution {
    public long solution(long r1, long r2) {
        long answer = 0;
        
        for(long x = 0; x < r2; x++){
            long y2 = (long)Math.floor(Math.sqrt(r2 * r2 - x * x));
            long y1 = (long)Math.floor(Math.sqrt(r1 * r1 - x * x));
            
            answer += y2 - y1;
            if(y1 != 0 && y1 * y1 + x * x == r1 * r1){
                answer++;
            }
            // System.out.println(y2 + ", " + y1 + " >> " + answer);
        }
        
        return answer * 4;
    }
}