import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    
    static final int MONTH_TOTAL_COUNT = 12;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<Character, Integer> validDate = new HashMap<>();

        StringTokenizer stk;
        for (int i = 0; i < terms.length; i++) {
            stk = new StringTokenizer(terms[i]);

            char type = stk.nextToken().charAt(0);
            int term = Integer.parseInt(stk.nextToken());

            validDate.put(type, term);
        }

        ArrayList<Integer> over = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            stk = new StringTokenizer(privacies[i]);

            String strtDT = stk.nextToken();
            char type = stk.nextToken().charAt(0);

            int validDateFromNow = validDate.get(type);

            String[] tmp = strtDT.split("\\.");
            int year = Integer.parseInt(tmp[0]);
            int month = Integer.parseInt(tmp[1]);

            month += validDateFromNow;
            if(month > MONTH_TOTAL_COUNT) {
                year += month / MONTH_TOTAL_COUNT;
                month %= MONTH_TOTAL_COUNT;
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