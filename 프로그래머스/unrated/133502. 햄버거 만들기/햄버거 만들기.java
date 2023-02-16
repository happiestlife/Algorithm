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
        // order 스택에는 만들어져 전달된 재료들을 차례대로 넣는다.
        // tmp 스택에는 햄버거가 만들어졌다고 판단이 되었을 때 order의 재료를 tmp에 넣으면서 검사
        // 만약 햄버거가 되지 않았다면 tmp있는 모든 재료를 order 스택에 되돌려 넣기
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
                    // 햄버거 제작에 성공했다면 tmp에는 아직 햄버거가 남아있기 때문에 삭제시키기
                    tmp.clear();
                    count++;
                }
            }
        }

        return count;
    }
}