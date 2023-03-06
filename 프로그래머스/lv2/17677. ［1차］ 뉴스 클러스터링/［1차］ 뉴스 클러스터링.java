import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // key : 길이가 2인 부분 문자열,  value : 해당 부분 문자열이 나온 횟수
        Map<String, Integer> comp1 = analyze(str1);
        Map<String, Integer> comp2 = analyze(str2);

        int common = 0, sum = 0;
        Set<String> comp2Ele = comp2.keySet();
        for (String s : comp2Ele) {
            Integer comp1EleCnt = comp1.get(s);
            Integer comp2EleCnt = comp2.get(s);

            // 공통이 있을 때, 교집합은 min 합집합은 max
            // 해당 loop는 str2를 기준으로 하고 있기 때문에 loop가 끝나고 str1에만 속한 부분문자열을 교집합에 더해주기 위해 comp1에서 공통 문자열 제거
            if (comp1.containsKey(s)) {
                common += Math.min(comp1EleCnt, comp2EleCnt);
                sum += Math.max(comp1EleCnt, comp2EleCnt);
                comp1.remove(s);
            } else {
                sum += comp2EleCnt;
            }
        }
        // str1에만 속한 부분 문자열 합집합에 추가 
        for (String s : comp1.keySet()) {
            sum += comp1.get(s);
        }
        
        // 예외 케이스
        if(sum == 0 && common == 0){
            sum = common = 1;
        }
        
        return (int)(((double)common / sum) * 65536);
    }
    
    public static Map<String, Integer> analyze(String str) {
        // 영문자가 아닌 요소에 대해서 제외
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String subStr = str.substring(i, i + 2);
            matcher = pattern.matcher(subStr);
            if (!matcher.find()) {
                if(!map.containsKey(subStr)) {
                    map.put(subStr, 1);
                }else{
                    map.put(subStr, map.get(subStr) + 1);
                }
            }
        }

        return map;
    }
}