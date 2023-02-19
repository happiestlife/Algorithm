import java.util.ArrayList;

class Solution {
    public int solution(int number, int limit, int power) {
        // 소인수분해를 통해 각 소수의 (지수+1) 곱셈을 통해서 구함
        // 소수 구하기
        boolean[] isNotPrime = new boolean[number + 1];
        ArrayList<int[]> primeList = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if(!isNotPrime[i]){
                primeList.add(new int[]{i, 0});
                for (int j = 2; i * j <= number; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }

        // 1인 기사는 항상 1kg만 필요 -> limit이 항상 2 이상이기 때문.
        int rs = 1;
        for (int i = 2; i <= number; i++) {
            // 약수 개수 초기화
            int knight = i;
            primeList.forEach(o -> o[1] = 0);

            // 약수 개수 구하기
            // 1. 각 소수를 몇개씩 사용해서 나눠지는지 알아내기
            int idx = 0;
            while (knight > 1) {
                int[] p = primeList.get(idx);

                while (knight % p[0] == 0) {
                    p[1]++;
                    knight /= p[0];
                }

                idx++;
            }
            
            // 2. 약수 총 개수를 구하기 (공식 사용)
            int x = 1;
            for (int j = 0; j < primeList.size(); j++) {
                if(primeList.get(j)[1] > 0){
                    x *= (primeList.get(j)[1] + 1);
                }
            }
            
            if(x > limit)
                x = power;
            rs += x;
        }

        return rs;
    }
}