import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        m--;
        n--;

        int small = m < n ? m : n;
        int big = m < n ? n : m;

        double result = 1;
        for(int i = 1; i <= small; i++) {
            result = result * (big+i) / i;
        }

        return (int)result;
    }
}