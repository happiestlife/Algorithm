import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0, right = 0;
        Set<Character> compChar = new HashSet<>();
        while(right < s.length()) {
            Character rightChar = s.charAt(right);
            if(compChar.contains(rightChar)){
                result = Math.max(result, compChar.size());
                for(int i = left; i <= right; i++) {
                    Character findChar = s.charAt(i);
                    compChar.remove(findChar);
                    left++;
                    if(findChar == rightChar) break;
                }
            }
            
            compChar.add(rightChar);
            right++;
        }
        result = Math.max(result, compChar.size());
        return result;
    }
}