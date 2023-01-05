import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        Stack<Character> same = new Stack<>();
        Stack<Character> diff = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (same.isEmpty() || same.peek() == c) {
                same.push(c);
            } else {
                diff.push(c);
            }

            if (same.size() == diff.size()) {
                count++;
                same.clear();
                diff.clear();
            }
        }
  
        if(!same.isEmpty())
            count++;

        return count;
    }
}