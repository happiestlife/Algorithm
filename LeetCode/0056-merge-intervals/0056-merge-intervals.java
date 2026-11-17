import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) ->  Integer.compare(i1[0], i2[0]));

        boolean[] isRemoved = new boolean[intervals.length];
        List<int[]> rs = new ArrayList<>();
        for(int i = 0 ; i < intervals.length; i++) {
            if(isRemoved[i]) continue; 

            int[] curInterval = intervals[i];
            int curStart = curInterval[0];
            int curEnd = curInterval[1];
            for(int j = i+1; j < intervals.length; j++) {
                if(isRemoved[j]) continue;
                
                int[] compareInterval = intervals[j];
                int compareStart = compareInterval[0];
                int compareEnd = compareInterval[1];

                if(curEnd >= compareEnd) isRemoved[j] = true;
                else if(compareStart <= curEnd && curEnd < compareEnd) {
                    curEnd = compareEnd;
                    isRemoved[j] = true;
                } else {
                    break;
                }
            }

            rs.add(new int[]{curStart, curEnd});
        }

        int[][] result = new int[rs.size()][2];
        for(int i = 0; i < result.length; i++) {
            result[i] = rs.get(i);
        }

        return result;
    }
}