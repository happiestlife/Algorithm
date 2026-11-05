import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // for(int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();


        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            if(num1 > 0) break;
            else if(i > 0 && nums[i-1] == nums[i]) continue;

            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int leftNum = nums[left], rightNum = nums[right];

                int curSum = num1 + leftNum + rightNum;
                if(curSum == 0) {
                    result.add(List.of(num1, leftNum, rightNum));
                } 

                if(curSum <= 0) {
                    while(left+1 < nums.length && nums[left] == nums[left+1]) left++;
                    left++;
                }
                else if(curSum >= 0) {
                    while((i < right-1 && right < nums.length-1) && nums[right] == nums[right-1]) right--;
                    right--;
                }
            }
        }

        return result;
    }
}