import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        
        int[] arr = new int[n];
        int answerIdx = 0;
        int[] result = new int[n];
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        
        int len = n - 1;
        long baseCnt = 1;
        for(int i = 0; i < arr.length; i++){
            long tempBaseCnt = baseCnt; 
            
            long stepSize = 1;
            for(int j = 1; j <= len; j++){
                stepSize *= j;
            }
            
            for(int j = 0; j < arr.length; j++){
                if(isVisited[j])
                    continue;
                
                if(tempBaseCnt <= k && k < tempBaseCnt + stepSize){ 
                    result[answerIdx++] = arr[j];
                    isVisited[j] = true;
                    baseCnt = tempBaseCnt;
                }
                
                tempBaseCnt += stepSize;
            }
            
            len--;
        }
        
        return result;
    }
}