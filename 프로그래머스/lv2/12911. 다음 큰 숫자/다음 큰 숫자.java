class Solution {
    public int solution(int n) {
        int bigNum = n + 1;
        int nOneCnt = getBinaryOneCnt(n);
        while (true) {
            int bigNumOneCnt = getBinaryOneCnt(bigNum);
            if(bigNumOneCnt == nOneCnt)
                break;

            bigNum++;
        }
        
        return bigNum;
    }
    
    public static int getBinaryOneCnt(int num) {
        int oneCnt = 0;
        while (num > 0) {
            if(num % 2 == 1){
                oneCnt++;
            }
            num /= 2;
        }

        return oneCnt;
    }
}