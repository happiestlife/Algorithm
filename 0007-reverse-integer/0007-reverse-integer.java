class Solution {
    public int reverse(int x) {
        double result = 0;

        // 1. 뒤에서부터 하나씩 생성
        String str = String.valueOf(x);
        for(int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if(c == '-') continue;

            double curNum = c - '0';

            result = result * 10 + curNum;
        }

        // 2. 음수이면 음수로 변경
        if(x < 0) {
            result *= -1;
        }

        double min = (double)Math.pow(2, 31) * -1;
        double max = (double)Math.pow(2, 31) - 1;
        if(!(min <= result && result <= max)) result = 0;

        return (int)result;
    }
}