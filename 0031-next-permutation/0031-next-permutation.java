import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;

        int length = 2;
        boolean is2DigitMaxPermutation = isMaxPermutation(nums, length);
        if(!is2DigitMaxPermutation) {
            int tmp = nums[nums.length-2];
            nums[nums.length-2] = nums[nums.length-1];
            nums[nums.length-1] = tmp;
            return;
        }

        length++;
        while(length <= nums.length) {
            boolean isCurDigitMaxPermutation = isMaxPermutation(nums, length);
            // System.out.println(isMaxPermutation(nums, length));
            if(isCurDigitMaxPermutation) {
                length++;
                continue;
            }
            else {
                // 1. 이전 숫자들 중 현재 자리 이상이면서 가장 적은값 구하기
                int curDigit = nums[nums.length - length];
                int minOverCurDigitNumIdx = -1;
                for(int i = nums.length - length+1; i < nums.length; i++){
                    int curNum = nums[i];
                    if(curNum > curDigit) {
                        if(minOverCurDigitNumIdx == -1) minOverCurDigitNumIdx = i;
                        else minOverCurDigitNumIdx = curNum <= nums[minOverCurDigitNumIdx] ? i : minOverCurDigitNumIdx ; 
                    }
                }

                // 1.1 만약 없다면 continue
                if(minOverCurDigitNumIdx == -1) {
                    length++;
                    continue;
                }

                // 2. 현재 자리를 1에서 구한 값으로 교체
                List<Integer> restNums = new ArrayList<>();
                // System.out.println(minOverCurDigitNumIdx + " :: " + nums[minOverCurDigitNumIdx]);
                for(int i = nums.length - length; i < nums.length; i++) {
                    if(i != minOverCurDigitNumIdx) {
                        System.out.println(nums[i]);
                        restNums.add(nums[i]);
                    }
                }
                Collections.sort(restNums);    

                nums[nums.length - length] = nums[minOverCurDigitNumIdx];
                // 3. 나머지 숫자들을 최소 premutation으로 변경
                for(int i = 0; i < restNums.size(); i++) {
                    nums[nums.length - length + i + 1] = restNums.get(i);
                    // System.out.println(nums[nums.length - length + i + 1] + " << " + restNums.get(i));
                }

                // System.out.println(nums.length - length + ", " + nums[minOverCurDigitNumIdx]);
                // for(int i = 0; i < nums.length; i++) {
                //     System.out.print(nums[i] + " ");
                // }
                // System.out.println();
                return;
            }
        }

        // 마지막으로 생성된 결과가 최대 Premutation이라면, 가장 낮은 Premutation으로 변경
        Integer[] maxPremutation = new Integer[nums.length];
        for(int i = 0; i < maxPremutation.length; i++) {
            maxPremutation[i] = nums[i];
        }
        Arrays.sort(maxPremutation, Collections.reverseOrder());

        boolean isMaxPremutation = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != maxPremutation[i]) {
                isMaxPremutation = false;
                break;
            }
        }

        if(isMaxPremutation) Arrays.sort(nums);
        


    }

    private boolean isMaxPermutation(int[] nums, int length) {
        Integer[] compare = new Integer[length];
        for(int i = 0; i < compare.length; i++) {
            compare[i] = nums[nums.length - length + i];
        }

        Arrays.sort(compare, Collections.reverseOrder());

        for(int i = 0; i < compare.length; i++) {
            if(compare[i] != nums[nums.length - length + i]) {
                return false;
            }
        }
        return true;
    }
}