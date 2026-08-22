class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. 행 고르기
        int rowIdx = getRowIdx(matrix, target);
        // System.out.println("selected row: " + rowIdx);
        if(rowIdx == -1) return false;

        // 2. 선택한 행의 열 고르기
        int colIdx = getColIdx(matrix, target, rowIdx);
        return colIdx != -1;
    }

    private int getRowIdx(int[][] matrix, int target) {
        int result = -1;
        
        int left = 0, right = matrix.length - 1;
        while(left <= right) {
            int midIdx = (left + right) / 2;
            int midValue = matrix[midIdx][0];

            if(midValue == target) {
                result = midIdx;
                break;
            }
            else if(midValue > target) {
                right = midIdx - 1;
            } else {
                result = midIdx;
                left = midIdx + 1;
            }
        }

        return result;
    }

    private int getColIdx(int[][] matrix, int target, int rowIdx) {
        int result = -1;
        int nums[] = matrix[rowIdx];
        
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int midIdx = (left + right) / 2;
            int midValue = nums[midIdx];

            if(midValue == target) {
                result = midIdx;
                break;
            }
            else if(midValue > target) {
                right = midIdx - 1;
            } else {
                left = midIdx + 1;
            }
        }

        return result;
    }
}