class Solution {
    public int removeDuplicates(int[] nums) {
        // 직전 비교 숫자, 중복 제거된 전체 숫자 개수 변수 선언
        int prevNum = -101;
        int resultIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            // 이전과 같다면 패스
            if(curNum == prevNum) continue;

            // 결과에 삽입, resultIdx+1, prevNum 업데이트
            nums[resultIdx++] = curNum;
            prevNum = curNum;
        }

        return resultIdx;
    }
}