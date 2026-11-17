import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toList()));
        while(true) {
            int switchPoint = nums.length - 2;
            while(switchPoint >= 0 && nums[switchPoint] >= nums[switchPoint+1]) switchPoint--;
            if(switchPoint == -1) break;

            if(switchPoint >= 0) {
                int switchNum = nums[switchPoint];
                int minOverNumIdx = -1;
                for(int j = switchPoint+1; j < nums.length; j++) {
                    int compareNum = nums[j];
                    if(compareNum > switchNum) {
                        if(minOverNumIdx == -1) minOverNumIdx = j;
                        else minOverNumIdx = nums[minOverNumIdx] < compareNum ? minOverNumIdx : j;
                    }
                }

                int tmp = nums[switchPoint];
                nums[switchPoint] = nums[minOverNumIdx];
                nums[minOverNumIdx] = tmp;
            }

            List<Integer> rest = new ArrayList<>(nums.length - (switchPoint+1));
            for(int j = switchPoint+1; j < nums.length; j++) {
                rest.add(nums[j]);
            }
            Collections.sort(rest);
            for(int j = 0; j < rest.size(); j++) {
                nums[switchPoint+1+j] = rest.get(j);
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