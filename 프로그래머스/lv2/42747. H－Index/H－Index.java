import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        Integer[] ctts = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(ctts, Collections.reverseOrder());

        int rs = ctts.length;
        for (int i = 0; i < ctts.length; i++) {
            if(i + 1 > ctts[i]) {
                rs = i;
                break;
            }
        }
        
        return rs;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/42747/questions