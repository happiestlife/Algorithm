import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // [0] : idx,  [1] : num
        int[] rs = new int[prices.length];
        // 스택에는 항상 이전 값보다 같거나 큰 값이 들어간다.
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            // 스택의 가장 윗값보다 작은 값이 나오면 해당 값을 빼서 결과에 넣기 
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] data = stack.pop();
                rs[data[0]] = i - data[0];
            }
            stack.push(new int[]{i, prices[i]});
        }

        // 스택에 남아있는 증가하는 값들을 제거하면서 결과에 저장하기 
        while (!stack.isEmpty()) {
            int[] data = stack.pop();
            rs[data[0]] = prices.length - 1 - data[0];
        }
        
        return rs;
    }
}