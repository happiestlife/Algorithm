class Solution {
    
    static int rs;
    
    public int solution(int[] numbers, int target) {
        int[] nums = new int[numbers.length + 1];
        nums[0] = 0;
        System.arraycopy(numbers, 0, nums, 1, numbers.length);

        calc(target, nums, 0, 0);
        
        return rs;
    }
    
    public static void calc(int target, int[] nums, int idx, int currentValue) {
        if(idx == nums.length-1){
            if(currentValue == target){
                rs++;
            }
            return;
        }
        
        calc(target, nums, idx + 1, currentValue + nums[idx+1]);
        calc(target, nums, idx + 1, currentValue - nums[idx+1]);
    }
}