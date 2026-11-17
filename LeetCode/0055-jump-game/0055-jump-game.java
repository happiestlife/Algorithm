import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        boolean[] isVisited = new boolean[nums.length];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while(!q.isEmpty()) {
            int curIdx = q.poll();
            int maxJumpLen = nums[curIdx];

            for(int i = 1; i <= maxJumpLen; i++) {
                int moveIdx = curIdx + i;
                if(moveIdx >= nums.length || isVisited[moveIdx]) continue;
                else if(moveIdx == nums.length-1) return true;
                
                isVisited[moveIdx] = true;
                q.add(moveIdx);
            }
        }

        return false;
    }
}