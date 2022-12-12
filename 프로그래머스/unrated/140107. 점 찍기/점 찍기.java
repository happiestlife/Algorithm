class Solution {
    public long solution(int k, int d) {
        int maxInd = d / k;

        long count = 0;
        for (int i = 0; i <= maxInd; i++) {
            count += calc(i * k, d)/k + 1;
        }

        return count;

    }

    public static long calc(long x, long d) {
        return (long)Math.floor(Math.sqrt(d*d - x*x));
    }
}