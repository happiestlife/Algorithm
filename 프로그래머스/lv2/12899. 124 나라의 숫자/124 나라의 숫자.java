class Solution {
    public String solution(int n) {
        // 1. 자리수 구하기
        int digit = 1;
        while (true) {
            double maxSizeOfDigit = getCanExpressCnt(digit);
            if (maxSizeOfDigit >= n) {
                break;
            }
            digit++;
        }

        // 2. 각 자릿수 구하기
        final String[] numbers = {"1", "2", "4"};
        StringBuilder sb = new StringBuilder();
        while (digit > 0) {
            double canExpressCnt = getCanExpressCnt(digit - 1) + 1;
            double stepCnt = Math.pow(3, digit - 1);
            int step;

            // 각 단계에서 몇단계인지 파악하기
            if(n < canExpressCnt) {
                sb.append(numbers[1]);
            }
            else {
                for (step = 0; step < 3; step++) {
                    if (canExpressCnt + stepCnt * step <= n && n < canExpressCnt + stepCnt * (step + 1)) {
                        break;
                    }
                }

                sb.append(numbers[step]);
                n -= stepCnt * (step + 1);
            }

            digit--;
        }

        return sb.toString();
    }

    public static double getCanExpressCnt(int digit){
        return (Math.pow(3, digit) - 1) * 3 / 2;
    }
}