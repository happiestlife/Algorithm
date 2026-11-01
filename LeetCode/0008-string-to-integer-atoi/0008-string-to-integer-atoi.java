class Solution {
    public int myAtoi(String s) {
        String resultStr = s;
        // 1. trim
        resultStr = s.trim();

        // 2. 양수 / 음수 판단
        boolean isPositive = isPositive(resultStr);
        if(resultStr.length() > 0 && (resultStr.charAt(0) == '+' || resultStr.charAt(0) == '-')) {
            resultStr = resultStr.substring(1);
        }

        // 3. 문자열이 끝날때까지 혹은 숫자가 아닌 것이 나올때까지 0으로 시작하는 문자는 스킵하면서 숫자 읽기
        double result = 0;
        for(int i = 0; i < resultStr.length(); i++) {
            char c = resultStr.charAt(i);

            // result가 0인데 0이 등장했다면 스킵
            // 문자가 나왔다면 종료
            if(result == 0 && c == '0') continue;
            else if(!('0' <= c && c <= '9')) break;

            result = result * 10 + (c - '0');
        }
        
        if(!isPositive) result *= -1;

        // 4. 숫자가 -2^31 미만이거나 2^31 - 1 초과라면 %적용
        double min = Math.pow(2, 31) * -1;
        double max = Math.pow(2, 31) - 1;
        if(isPositive && result > max) {
            result = max;
        } else if(!isPositive && result < min) {
            result = min;
        }

        return (int)result;
    }

    private boolean isPositive(String s) {
        if(s.length() == 0) return true;

        char firstChar = s.charAt(0);
        if(firstChar == '-') {
            return false;
        } else {
            return true;
        }
    }
}