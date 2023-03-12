import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        final String[] hexadecimal = {"A", "B", "C", "D", "E", "F"};
        
        // 반복문을 돌면서 구하기
        int num = 0;
        List<Integer> nums = new LinkedList<>();
        // 튜브가 t번 말하기 위해서는 총 p + m * (t-1)번의 게임이 진행되어야 함
        while (true) {
            int tmp = num;
            int inputIdx = Math.max(nums.size(), 0);
            do {
                nums.add(inputIdx, tmp % n);
                tmp /= n;
            } while (tmp > 0);

            if(nums.size() >= p + m * (t - 1))
                break;

            num++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            Integer number = nums.get((p-1) + m * i);
            String element = String.valueOf(number);
            if(number > 9){
                element = hexadecimal[number-10];
            }
            sb.append(element);
        }
        
        return sb.toString();
    }
}