import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // 1. k진법으로 변환
        List<Integer> ele = new LinkedList<>();
        do {
            ele.add(0, n % k);
            n /= k;
        } while (n > 0);

        // 2. 조건에 맞는 수 고르기
        // 조건에 맞는 숫자의 시작 & 끝 인덱스
        int s = -1, e = -1;
        List<Long> nums = new ArrayList<>(20);
        for (int i = 0; i < ele.size(); i++) {
            int num = ele.get(i);
            if(num != 0){
                if(s == -1){
                    s = e = i;
                }else{
                    e = i;
                }
            }
            // 현재 숫자가 0이 아니고, 0이 전에 숫자가 나왔던 경우
            else if(s != -1){
                long number = 0;
                for(int j = s; j <= e; j++){
                    number = number * 10 + ele.get(j);
                }
                if(number != 1)
                    nums.add(number);

                s = e = -1;
            }
        }
        if(s != -1){
            long number = 0;
            for(int j = s; j <= e; j++){
                number = number * 10 + ele.get(j);
            }
            if(number != 1)
                nums.add(number);
        }

        // 4. 조건에 맞는 수가 소수인지 판별하기
        int rs = 0;
        for (Long num : nums) {
            boolean isPrime = true;
            for(int i = 2; i <= (int)Math.sqrt(num); i++){
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime)
                rs++;
        }
        return rs;

    }
}