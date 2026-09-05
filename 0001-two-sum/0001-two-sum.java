class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rs = null;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int x = nums[i], y = nums[j];
                int result = x + y;

                if(result == target) {
                    rs = new int[]{i, j};
                }
            }

            if(rs != null) break;
        }

        return rs;
    }
}