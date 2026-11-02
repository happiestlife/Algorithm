import java.util.*;

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap(){{
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }};


        StringBuilder result = new StringBuilder();
        String numStr = String.valueOf(num);
        int numLength = numStr.length();    
        for(int i = 0; i < numLength; i++) {
            int charNum = numStr.charAt(i) - '0';
            int curDigit = numLength - i;
            int curDigitMinNum = (int)Math.pow(10, curDigit-1);
            
            if(charNum == 4 || charNum == 9) {
                boolean isOverFive = charNum == 9;

                int from = curDigitMinNum * (isOverFive ? 10 : 5);
                int to = curDigitMinNum;
                result.append(map.get(to));
                result.append(map.get(from));
            } else {
                if(charNum >= 5) {
                    result.append(map.get(5 * curDigitMinNum));
                    charNum -= 5;
                }
                for(int j = 0; j < charNum; j++) {
                    result.append(map.get(curDigitMinNum));
                }
            }
        }

        return result.toString();
    }
}