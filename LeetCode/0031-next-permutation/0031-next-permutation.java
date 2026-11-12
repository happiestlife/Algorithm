import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int ascIdx = nums.length - 2;
        while(ascIdx >= 0 && nums[ascIdx] >= nums[ascIdx+1]) ascIdx--;

        if(ascIdx >= 0) {
            int ascNumOverNumIdx = nums.length - 1;
            while(ascNumOverNumIdx > ascIdx && nums[ascNumOverNumIdx] <= nums[ascIdx]) ascNumOverNumIdx--;

            swap(nums, ascNumOverNumIdx, ascIdx);
        }

        sortAsc(nums, ascIdx+1, nums.length-1);
    }

    private void sortAsc(int[] nums, int start, int end) {
        List<Integer> ascNums = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            ascNums.add(nums[i]);
        }
        Collections.sort(ascNums);

        for(int i = 0; i < ascNums.size(); i++) {
            nums[i + start] = ascNums.get(i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}