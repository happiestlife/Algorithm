import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int maxNum = nums[len-1] + nums[len-2] + nums[len-3];

        boolean[] isNotPrime = new boolean[maxNum + 1];
        for(int i = 2; i < isNotPrime.length; i++){
            if(isNotPrime[i])
                continue;

            for(int j = 2; i * j < isNotPrime.length; j++){
                isNotPrime[i * j] = true;
            }
        }


        int rs = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    int num = nums[i] + nums[j] + nums[k];
                    if (!isNotPrime[num]) {
                        rs++;
                    }

                }
            }
        }

        return rs;
    }
}