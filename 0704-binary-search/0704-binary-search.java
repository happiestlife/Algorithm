class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 반복문 i = 0 ~ nums.length
        while(left <= right) {
            // 1. 중간값 추출
            int mid = (left + right) / 2;
            int midValue = nums[mid];
            // 2-1. 정답이라면 인덱스 반환
            if (midValue == target) {
                return mid;
            }
            // 2-2. 값이 정답보다 작다면 right = mid - 1
            else if (midValue < target) {
                left = mid + 1;
            }
            // 2-3. 값이 정답보다 크다면 left = mid + 1    
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}