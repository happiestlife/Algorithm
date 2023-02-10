import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack;
        List<Character> q = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
        }
        int rs = 0;
        // 문자열의 가장 앞 문자를 가장 뒤에 더해가면 시작 지점을 바꿔주기 위한 변수
        int startPoint = 0;
        for (int i = 0; i < s.length(); i++) {
            stack = new Stack<>();
            boolean isFail = false;
            // 검사 시작
            for (int j = startPoint; j < q.size(); j++) {
                char c = q.get(j);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                else {
                    // 닫는 괄호가 먼저 나오거나 짝이 맞지 않는 경우 실패 처리
                    if (stack.isEmpty() ||
                            (stack.peek() != '(' && c == ')') ||
                            (stack.peek() != '{' && c == '}') ||
                            (stack.peek() != '[' && c == ']')) {
                        isFail = true;
                        break;
                    }
                    stack.pop();
                }
            }
            // 여는 괄호가 남아 있는 경우 실패 처리
            if(!stack.isEmpty()){
                isFail = true;
            }

            if (!isFail) {
                rs++;
            }

            // 가장 앞에 있는 문자를 가장 뒤에 더하기 
            q.add(q.get(startPoint++));
        }

        return rs;
    }
}