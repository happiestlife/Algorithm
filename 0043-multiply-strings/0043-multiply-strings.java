class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        String big = num1.length() < num2.length() ? num2 : num1;
        String small = num1.length() < num2.length() ? num1 : num2;

        // System.out.println(addStr(num1, num2));

        String result = "0";
        for(int i = small.length()-1; i >= 0; i--) {
            int curSmallNum = small.charAt(i) - '0';
            
            StringBuilder curStepResult = new StringBuilder("0");
            for(int j = big.length()-1; j >= 0; j--) {
                int curBigNum = big.charAt(j) - '0';
                int curMultiplyResult = curSmallNum * curBigNum;

                StringBuilder curMultiplyResultStr = new StringBuilder(String.valueOf(curSmallNum * curBigNum));
                // System.out.println("curMultiplyResult " + curMultiplyResult);
                
                int curDigitPos = Math.abs(j - big.length());
                for(int k = 0; k < curDigitPos-1; k++) {
                    curMultiplyResultStr.append("0");
                }

                // System.out.println("digit pos " + curDigitPos + " , rs " + curMultiplyResultStr.toString());
                curStepResult = new StringBuilder(addStr(curStepResult.toString(), curMultiplyResultStr.toString()));
                // System.out.println("cur result " + curStepResult);
            }

            int curDigitPos = Math.abs(i - small.length());
            for(int j = 0; j < curDigitPos-1; j++) {
                curStepResult.append("0");
            }

            // System.out.println("before add result " + curStepResult);
            result = addStr(result, curStepResult.toString());

            // System.out.println("after add result " + result);
        }

        return result;
    }

    private String addStr(String s1, String s2) {
        int maxLength = Math.max(s1.length(), s2.length());

        StringBuilder sb = new StringBuilder();
        boolean addNext = false;
        for(int i = 0; i < maxLength; i++) {
            int s1CurNum = 0;
            if(i < s1.length()) s1CurNum = s1.charAt(s1.length() - 1 - i) - '0';

            int s2CurNum = 0;
            if(i < s2.length()) s2CurNum = s2.charAt(s2.length() - 1 - i) - '0';

            int curSum = s1CurNum + s2CurNum;
            if(addNext) {
                curSum++;
                addNext = false;
            }

            int curDigit = curSum % 10;
            sb.insert(0, String.valueOf(curDigit));
            if(curSum >= 10) {
                addNext = true;
            }
        }
        if(addNext) sb.insert(0, "1");
        
        return sb.toString();
    }
}