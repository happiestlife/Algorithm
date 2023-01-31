import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        // 같은 문자끼리, 다른 문자끼리 스택 / 큐에 넣어놓고 
        // 문자열을 검사해가면서 검사를 진행하다가 2개의 스택 / 큐의 길이가 같아지면 문자열 분리
        // 문자열 분리는 2개의 스택 / 큐를 초기화함으로 이루어진다. 
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