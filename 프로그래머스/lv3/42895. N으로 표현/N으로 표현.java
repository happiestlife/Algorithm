import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        Set[] sets = new Set[9];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<Long>();
        }

        int i = 0;
        while(true) {
            StringBuilder sb = new StringBuilder(String.valueOf(N));
            for (int j = 0; j < i; j++) {
                sb.append(N);
            }
            long continueNum = Long.parseLong(sb.toString());
            if(continueNum == number){
                return i+1;
            }
            sets[i].add(continueNum);


            for (int j = 0; j <= i; j++) {
                Object[] arr1 = sets[j].toArray();
                Object[] arr2 = sets[i - j].toArray();
                for (int k = 0; k < arr1.length; k++) {
                    for (int l = 0; l < arr2.length; l++) {
                        long rs1 = (long) arr1[k];
                        long rs2 = (long) arr2[l];
                        if(calculate(sets[i+1], rs1, rs2, number))
                            return i+2;
                        
                    }
                }
            }
            i++;
            if(i >= 8)
                break;
        }

        return -1;

    }
    
    private static boolean calculate(Set<Long> set, long rs1, long rs2, int number) {
        long sum = rs1 + rs2;
        set.add(sum);
        if(sum == number)
            return true;


        long minus = rs1 - rs2;
        set.add(minus);
        if(minus == number)
            return true;

        long multiple = rs1 * rs2;
        set.add(multiple);
        if(multiple == number)
            return true;


        if(rs2 != 0) {
            long divide = rs1 / rs2;
            set.add(divide);
            if (divide == number)
                return true;
        }

        return false;
    }
}