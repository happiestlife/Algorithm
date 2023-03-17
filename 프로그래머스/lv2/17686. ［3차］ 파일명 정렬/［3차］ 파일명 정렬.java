import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // [0] : 인덱스, [1] : 문자열
        ArrayList<Object[]> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(new Object[]{i, files[i]});
        }

        Comparator<Object[]> comparator = (o1, o2) -> {
            String str1 = (String) (o1[1]);
            int headIdx1 = getHead(str1), numberIdx1 = getNumber(str1, headIdx1);
            String head1 = str1.substring(0, headIdx1).toLowerCase(), number1 = str1.substring(headIdx1, numberIdx1);

            String str2 = (String) o2[1];
            int headIdx2 = getHead(str2), numberIdx2 = getNumber(str2, headIdx2);
            String head2 = str2.substring(0, headIdx2).toLowerCase(), number2 = str2.substring(headIdx2, numberIdx2);

            int rs1 = head1.compareTo(head2);
            if (rs1 == 0) {
                int rs2 = (Integer.parseInt(number1) - Integer.parseInt(number2));
                if(rs2 == 0){
                    return (Integer)o1[0] - (Integer)o2[0];
                }else{
                    return rs2;
                }
            } else {
                return rs1;
            }
        };

        Collections.sort(list, comparator);

        String[] rs = new String[files.length];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = (String)list.get(i)[1];
        }
        
        return rs;
    }
    
        public static int getHead(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                break;
            }
        }

        return i;
    }

    public static int getNumber(String s, int startIdx) {
        int idx = startIdx;
        while (idx < s.length() && idx - startIdx < 5) {
            char c = Character.toLowerCase(s.charAt(idx));
            if(c < '0' || c > '9')
                break;

            idx++;
        }

        return idx;
    }
}