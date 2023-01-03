import java.io.IOException;
import java.util.Stack;

class Solution {
    
    static final int BREAD = 1;
    static final int VEGETABLE = 2;
    static final int MEAT = 3;
    
    public int solution(int[] ingredient) {
        // 쉽게 계산하기 위해 순서의 반대로 해놓기
        int[] HAMBURGER = {BREAD, MEAT, VEGETABLE, BREAD};

        int count = 0;
        Stack<Integer> order = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            order.push(ingredient[i]);
            if (ingredient[i] == BREAD) {
                // 햄버거가 완성되는지 검사
                boolean isFail = false;
                for (int j = 0; j < HAMBURGER.length; j++) {
                    if (order.isEmpty() || order.peek() != HAMBURGER[j]) {
                        while (!tmp.isEmpty()) {
                            order.push(tmp.pop());
                        }
                        isFail = true;
                        break;
                    }

                    tmp.add(order.pop());
                }

                if (!isFail) {
                   tmp.clear();
                    count++;
                }
            }
        }

        return count;
    }
}