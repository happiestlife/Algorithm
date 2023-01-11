class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0, oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                oneCnt++;
            } else {
                zeroCnt++;
            }
        }
        
        int zeroRs = 0, cnvrtCnt = 1;
        while (true) {
            // 1. 삭제한 총 0의 개수 update
            zeroRs += zeroCnt;
            
            // 2. 길이 초기화
            int len = oneCnt;
            if (len == 1) {
                break;
            }
            
            // 3.길이를 이진수로 변환하면서 0과 1의 개수 세기
            zeroCnt = 0; oneCnt = 0;
            while (len > 0) {
                int remainder = len % 2;
                if (remainder == 0) zeroCnt++; 
                else oneCnt++;

                len /= 2;
            }
            cnvrtCnt++;
        }
        
        return new int[]{cnvrtCnt, zeroRs};
    }
}