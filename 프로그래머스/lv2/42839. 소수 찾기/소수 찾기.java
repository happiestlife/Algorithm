import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static Set<Integer> rs = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] isInPaper;
    static boolean[] isNotPrime;
    static String numbers;
    
    public int solution(String nums) {
        numbers = nums;
        
        isNotPrime = new boolean[10000000];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= (int)Math.sqrt(isNotPrime.length); i++) {
            if (!isNotPrime[i]) {
                int idx = 2;
                while (idx * i < isNotPrime.length) {
                    isNotPrime[idx * i] = true;
                    idx++;
                }
            }
        }

        isInPaper = new boolean[numbers.length()];

        // 원소 개수 : 1 ~ numbers 원소의 개수
        for (int i = 1; i <= numbers.length(); i++) {
            for (int j = 0; j < numbers.length(); j++) {
                findCase(i, j);
            }
        }
        
        return rs.size();
    }
    
    public static void findCase(int maxCnt, int idx) {
        sb.append(numbers.charAt(idx));
        isInPaper[idx] = true;
        if (sb.length() == maxCnt) {
            int num = Integer.parseInt(sb.toString());
            if(!isNotPrime[num]){
                rs.add(num);
            }
        }
        else{
            for (int i = 0; i < numbers.length(); i++) {
                if(!isInPaper[i]){
                    findCase(maxCnt, i);
                }
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        isInPaper[idx] = false;
    }
}