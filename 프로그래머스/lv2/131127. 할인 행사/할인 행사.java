import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 초기화 : 날짜별 할인목록 1 ~ 10일자에 대해 만들기
        Map<String, Integer> bucket = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            String type = discount[i];
            if (bucket.containsKey(type)) {
                bucket.put(type, bucket.get(type) + 1);
            }else{
                bucket.put(type, 1);
            }
        }

        // 날짜별 할인 목록을 i ~ i+9씩 보면서 정현이가 원하느 목록과 같은지 비교하기
        int rs = 0;
        for (int i = 0; i + 9 < discount.length; i++) {
            // 0. 다음날 + 10번째의 할인 물품 넣기
            int count = 1;
            if (bucket.containsKey(discount[i + 9]))
                count += bucket.get(discount[i + 9]);
            bucket.put(discount[i + 9], count);
            // 1. 검사해서 같은지 비교
            boolean isSuccess = true;
            for (int j = 0; j < want.length; j++) {
                Integer typeCnt = bucket.get(want[j]);
                // 해당 항목이 나오지 않았거나 개수가 부족하다면 실패
                if(typeCnt == null || typeCnt < number[j])
                    isSuccess = false;
            }

            if(isSuccess) {
                rs++;
            }

            if(bucket.get(discount[i]) == 1)
                bucket.remove(discount[i]);
            else
                bucket.put(discount[i], bucket.get(discount[i]) - 1);
        }
        
        return rs;

    }
}