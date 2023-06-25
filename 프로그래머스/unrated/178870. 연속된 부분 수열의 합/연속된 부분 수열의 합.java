class Solution {
    public int[] solution(int[] sequence, int k) {
        /*
        if curSum = k
            e - s를 min 길이와 비교해서 작은 인덱스를 답으로 선정
            
        else if curSum > k
            s++
            cursum에서 s 인덱스 값 제거
        
        else
            e++
            curSum에 e 인덱스 값 추가
            
        종료조건 : s > e (k가 현재 배열의 요소보다 작을 때) || e >= 배열 길이 (k가 현재 배열의 요소들의 합보다 클 때)
        */
        
        int s = 0, e = 0;
        int curSum = sequence[s];
        int[] answer = {0, 1000001};
        while(s <= e){
            if(curSum == k){
                if(answer[1] - answer[0] > e - s){
                    answer[0] = s;
                    answer[1] = e;
                }
                curSum -= sequence[s]; 
                s++;
            }
            else if(curSum > k){
                curSum -= sequence[s];
                s++;
            }
            else{
                e++;
                if(e >= sequence.length){
                    break;
                }
                curSum += sequence[e];
            }
        }
        return answer;
    }
}