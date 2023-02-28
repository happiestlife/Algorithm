class Solution {
    public long[] solution(int n, long left, long right) {
        int idx = 0;
        long[] rs = new long[(int) (right - left + 1)];
        while (left <= right) {
            long x = left / n;
            long y = left % n;

            long bigNum = Math.max(x, y);
            rs[idx++] = bigNum+1;

            left++;
        }
        
        return rs;
    }
}