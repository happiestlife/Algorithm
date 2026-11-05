import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = 10001;
        for(int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int leftNum = nums[left], rightNum = nums[right];

                int curSum = num1 + leftNum + rightNum;
                result = getResult(target, result, curSum);
                
                // 결과가 타겟과 동일하면 정답이므로 종료
                if(curSum == target) {
                    break;
                }
                // 결과 > 타켓일 경우, right--
                else if(curSum > target) {
                    while(right-1 > i && nums[right-1] == nums[right]) right--;
                    right--;
                } 
                // 결과 < 타켓일 경우, left++
                else {
                    while(left+1 < nums.length && nums[left] == nums[left+1]) left++;
                    left++;
                }
            }
        }

        return result;
    }

    private int getResult(int target, int prevResult, int curResult) {
        if(prevResult == 10001) return curResult;

        int prevDiff = Math.abs(target - prevResult);
        int curDiff = Math.abs(target - curResult);
        if(prevDiff >= curDiff) {
            return curResult;
        } else {
            return prevResult;
        }
    }
}