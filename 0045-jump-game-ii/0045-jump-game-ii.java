import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        
        Queue<Integer> q = new LinkedList();
        q.add(0);
        while(!q.isEmpty()) {
            int curIdx = q.poll();

            for(int i = 1; i <= nums[curIdx]; i++) {
                int targetIdx = curIdx + i;
                if(targetIdx >= nums.length || dp[targetIdx] > 0) continue;

                dp[targetIdx] = dp[curIdx]+1;
                q.add(targetIdx);
            }
        }

        return dp[nums.length-1];
    }
}