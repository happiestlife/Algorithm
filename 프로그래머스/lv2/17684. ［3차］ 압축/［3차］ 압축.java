import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), c - 'A' + 1);
        }

        int idx = 0;
        int[] rs = new int[1000];
        for (int i = 0; i < msg.length(); i++) {
            int e = i;
            // 사전에 포함된 가장 긴 문자열 찾기
            while (e < msg.length() && dictionary.containsKey(msg.substring(i, e + 1))) {
                e++;
            }

            // 사전에 포함된 문자열에 대한 색인 번호 가져오기
            String subStr = msg.substring(i, e);
            rs[idx++] = dictionary.get(subStr);

            // 사전에 신규 문자열 넣기
            if (e < msg.length()) {
                dictionary.put(msg.substring(i, e + 1), dictionary.size() + 1);
            }
            i = e-1;
        }
        
        return Arrays.copyOfRange(rs, 0, idx);
    }
}