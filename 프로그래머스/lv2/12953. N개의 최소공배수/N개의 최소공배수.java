import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public long solution(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }

        ArrayList<Integer> rsEle = new ArrayList<>();
        while (true) {

            // 0. 오름차순으로 정렬하기 (공통 약수를 찾기 위함)
            Collections.sort(arrList);
            
            while (arrList.size() > 0 && arrList.get(0) == 1) {
                arrList.remove(0);
            }
            
            if(arrList.size() == 0)
                break;

            // 1. 가장 작은 수의 약수 구하기 (약수는 큰 것부터 저장)
            ArrayList<Integer> divisors = new ArrayList<>();
            Integer minNum = arrList.get(0);
            for (int i = 2; i <= minNum; i++) {
                if(minNum % i == 0)
                    divisors.add(i);
            }

            // 2. 모든 수에 대해서 나눠지는 것이 2개 이상 있는지 체크
            int dvdCnt = 0;
            int divisor = 1;
            for (int i = 0; i < divisors.size(); i++) {
                divisor = divisors.get(i);
                for (int j = 0; j < arrList.size(); j++) {
                    if(arrList.get(j) % divisor == 0)
                        dvdCnt++;
                }

                if(dvdCnt > 1)
                    break;
            }

            //  2-1. 0?
            //      - 약수를 ele에 추가
            //      - 나눠지는 수에 대해서 몫을 list에 저장
            //      - 만약 몫 = 1 이면 저장 x
            if (divisor > 1) {
                rsEle.add(divisor);
                for (int i = 0; i < arrList.size(); i++) {
                    Integer curNum = arrList.get(i);
                    if(curNum % divisor == 0){
                        arrList.set(i, curNum / divisor);
                    }
                }
            }

            //  2-2. X?
            //      - 가장 작은 수를 ele에 넣고 list에서 빼기
            else{
                rsEle.add(minNum);
                arrList.remove(0);
            }
        }

        int rs = 1;
        for (int i = 0; i < rsEle.size(); i++) {
            rs *= rsEle.get(i);
        }


        return rs;
    }
}