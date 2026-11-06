import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> openCharByCloseChar = new HashMap(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 문자('(', ['', '{')라면 Push
            if(
                c == '(' ||
                c == '{' ||
                c == '['
            ) {
                stack.push(c);
            } 
            // 닫는 문자라면 검증
            // 쌍이 맞지 않다면 실패로 break;
            // 쌍이 맞다면 pop
            else {
                if(stack.isEmpty()) {
                    stack.push(c);
                    break;
                }
                
                char expectedOpneChar = openCharByCloseChar.get(c);
                char actualOpenChar = stack.peek();
                if(expectedOpneChar == actualOpenChar) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        // 스택에 값이 남아있다면 닫히지 않는 문자가 남아 있으므로 실패
        return stack.isEmpty();
    }
}