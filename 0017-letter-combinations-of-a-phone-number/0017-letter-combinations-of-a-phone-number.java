import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] numChars = {
            {},
            {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
        };

        List<String> result = new ArrayList<>();

        int digitLength = digits.length();
        int[] numCharIndexes = new int[digitLength];
        int caseCnt = getCaseCnt(numChars, digits);
        for(int i = 0; i < caseCnt; i++){
            StringBuilder resultCase = new StringBuilder();

            // 현재 케이스를 결과에 포함시키기
            for(int j = 0; j < numCharIndexes.length; j++) {
                int curNum = digits.charAt(j) - '0';
                String[] numChar = numChars[curNum];
                int numCharIndex = numCharIndexes[j];

                resultCase.append(numChar[numCharIndex]);    
            }
            result.add(resultCase.toString());

            // 마지막 인덱스를 1상승시키기
            numCharIndexes[numCharIndexes.length-1]++;
            // 그에 따른 인덱스들 계산
            for(int j = numCharIndexes.length-1; j >= 0; j--){
                int curNum = digits.charAt(j) - '0';
                String[] curNumChar = numChars[curNum];

                int numCharIndex = numCharIndexes[j];
                int curNumCharMaxIndex = curNumChar.length;

                // 만약 현재 numChar의 최대 인덱스에 도달하면 이전 numChar의 인덱스+1
                if(j > 0 && numCharIndex == curNumCharMaxIndex) {
                    numCharIndexes[j-1]++;
                    numCharIndexes[j] = 0;
                }
            }
        }

        return result;
    }

    private int getCaseCnt(String[][] numChars, String digits) {
        int cnt = 1;
        for(int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            int digitCnt = numChars[digit].length;

            cnt *= digitCnt;
        }

        return cnt;
    }
}