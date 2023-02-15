import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    
    static final int MONTH_TOTAL_COUNT = 12;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer stk;
        // key : 타입, value : 유효기간
        HashMap<Character, Integer> validDate = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            stk = new StringTokenizer(terms[i]);

            char type = stk.nextToken().charAt(0);
            int term = Integer.parseInt(stk.nextToken());

            validDate.put(type, term);
        }

        ArrayList<Integer> over = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            stk = new StringTokenizer(privacies[i]);

            // 개인정보 약관의 시작일과 타입
            String strtDT = stk.nextToken();
            char type = stk.nextToken().charAt(0);

            int validDateFromNow = validDate.get(type);

            // 날짜를 년,월,일로 분리
            String[] tmp = strtDT.split("\\.");
            int year = Integer.parseInt(tmp[0]);
            int month = Integer.parseInt(tmp[1]);

            month += validDateFromNow;
            // 약관기한을 더한 달이 13월을 넘긴 경우에만 +1년 이상 된 것이기 때문에 >
            if(month > MONTH_TOTAL_COUNT) {
                year += month / MONTH_TOTAL_COUNT;
                month %= MONTH_TOTAL_COUNT;
                // 총 월이 12의 배수인 경우 년이 추가된 것이 아니기 때문에 그에 대한 처리 진행
                if (month % MONTH_TOTAL_COUNT == 0) {
                    year--;
                    month = 12;
                }
            }

            tmp[0] = String.valueOf(year);
            tmp[1] = String.valueOf(month);
            if(month < 10)
                tmp[1] = "0" + tmp[1];

            String lastDT = String.join(".", tmp);

            if(today.compareTo(lastDT) >= 0) {
                over.add(i + 1);
            }
        }

        int[] rs = new int[over.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = over.get(i);
        }
        
        return rs;
    }
}