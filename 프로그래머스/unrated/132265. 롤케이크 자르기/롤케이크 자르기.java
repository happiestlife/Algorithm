import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // key : 토핑 종류, value : 토핑 개수
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            int toppingType = topping[i];
            if (right.containsKey(toppingType)) {
                right.put(toppingType, right.get(toppingType) + 1);
            }
            else{
                right.put(toppingType, 1);
            }
        }

        int rs = 0;
        for (int i = 0; i < topping.length; i++) {
            int toppingType = topping[i];
            if (left.containsKey(toppingType)) {
                left.put(toppingType, left.get(toppingType) + 1);
            }
            else{
                left.put(toppingType, 1);
            }

            if(right.get(toppingType) > 1){
                right.put(toppingType, right.get(toppingType) - 1);
            }
            else{
                right.remove(toppingType);
            }

            if (left.keySet().size() == right.keySet().size()) {
                rs++;
            }
        }

        return rs;
    }
}