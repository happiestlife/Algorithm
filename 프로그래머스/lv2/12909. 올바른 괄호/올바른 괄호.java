import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            if(c == '('){
                stack.push(1);
            }else {
                // ')'이 '('보다 먼저 나온 경우 실패
                if(stack.isEmpty())
                    break;
                stack.pop();
            }
        }

        // 문자열을 전부 검사했는데 '('이 남아있는 경우
        return (idx == s.length() && stack.isEmpty() ? true : false);
    }
}