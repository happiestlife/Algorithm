import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        int rotateCnt = getRotatedCnt(nums);
        System.out.println("rotate cnt " + rotateCnt);

        int result = -1;
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        while(left <= right) {
            int midIdx = (left + right) / 2;
            int midValue = nums[midIdx];

            if(midValue == target) {
                result = midIdx;
                break;
            }
            else if(midValue < target) {
                left = midIdx + 1;
            } else {
                right = midIdx - 1;
            }
        }

        if(result == -1) return -1;
        else {
            result -= rotateCnt;
            if(result < 0) {
                result += nums.length;
            }
            return result;
        }
    }

    private int getRotatedCnt(int[] nums) {
        int prevNum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            if(prevNum > curNum) {
                return nums.length - i;
            }
            prevNum = curNum;
        }
        return 0;
    }
}