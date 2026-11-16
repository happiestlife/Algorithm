import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int size = 1;
        for(int i = 1; i <= nums.length; i++) size *= i;

        List<List<Integer>> result = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            if(i > 0) {
                int switchIdx = nums.length-2;
                while(switchIdx >= 0 && nums[switchIdx] >= nums[switchIdx+1]) switchIdx--;

                if(switchIdx >= 0) {
                    int standardNum = nums[switchIdx];
                    int minOverNumIdx = -1;
                    for(int j = switchIdx+1; j < nums.length; j++) {
                        int curNum = nums[j];
                        if(curNum > standardNum) {
                            if(minOverNumIdx == -1) minOverNumIdx = j;
                            else minOverNumIdx = nums[minOverNumIdx] < curNum ? minOverNumIdx : j;
                        }
                    }
                    
                    int tmp = nums[switchIdx];
                    nums[switchIdx] = nums[minOverNumIdx];
                    nums[minOverNumIdx] = tmp;
                }

                List<Integer> rest = new ArrayList<>();
                for(int j = switchIdx+1; j < nums.length; j++) {
                    rest.add(nums[j]);
                }
                Collections.sort(rest);
                for(int j = 0; j < rest.size(); j++) {
                    nums[switchIdx+1+j] = rest.get(j);
                }
            }

            List<Integer> resultComp = new ArrayList<>(nums.length);
            for(int j = 0; j < nums.length; j++) {
                resultComp.add(nums[j]);
            }
            result.add(resultComp);
        }

        return result;
    }
}