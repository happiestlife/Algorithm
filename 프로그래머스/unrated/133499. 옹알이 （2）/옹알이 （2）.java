import java.util.*;

class Solution {
    
    static final String[] pronounce = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < babbling.length; i++) {
            String s = babbling[i];

            // stack에 각 단어 채우기
            stack.clear();
            for (int j = s.length() - 1; j >= 0; j--) {
                stack.add(s.charAt(j));
            }

            // 비교하기
            int bfrPronounce = -1;
            boolean isFail = false;
            while (!stack.isEmpty()) {
                Character c = stack.peek();

                int j = 0;
                // 발음가능한 단어를 찾아서 발음해보기
                for (; j < pronounce.length; j++) {
                    if (c == pronounce[j].charAt(0) && bfrPronounce != j) {
                        bfrPronounce = j;
                        isFail = isSame(stack, pronounce[j]);
                        break;
                    }
                }

                // 발음할 수 없는 경우가 있을 때 실패로 간주
                if(isFail || j == pronounce.length) {
                    isFail = true;
                    break;
                }
            }

            if(!isFail) {
                count++;
            }
        }
        
        return count;
    }
    
    public static boolean isSame(Stack<Character> ori, String comp) {
        for (int i = 0; i < comp.length(); i++) {
            // 발음하려는 남은 단어가 바닥났지만 더 발음을 해야할 경우 || 발음할 수 없을 경우
            if((ori.isEmpty() && i < comp.length())
                || ori.pop() != comp.charAt(i)){
                return true;
            }
        }

        return false;
    }
}