class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = nums.length;
        result[1] = -1;
        
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                result[0] = Math.min(result[0], mid);
                result[1] = Math.max(result[1], mid);
                left = mid+1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0; 
        right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                result[0] = Math.min(result[0], mid);
                result[1] = Math.max(result[1], mid);
                right = mid-1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }   
        }

        if(result[0] == nums.length) result[0] = -1;

        return result;
    }
}