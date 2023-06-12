import java.util.*;

class Solution {
    public int solution(int[] order) {
        int curBoxDigit = 1;
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < order.length; i++) {
            if (curBoxDigit <= order[i]) {
                while (curBoxDigit <= order[i]) {
                    stack.push(curBoxDigit++);
                }
                stack.pop();
                cnt++;
            }
            else{
                if(!stack.isEmpty() && stack.peek() == order[i]){
                    stack.pop();
                    cnt++;
                }else{
                    break;
                }
            }
        }
        
        return cnt;

    }
}