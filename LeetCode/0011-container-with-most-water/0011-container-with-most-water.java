import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int maxHeight = getMaxHeight(height);

        int first = 0, last = height.length - 1;
        int result = 0;
        for(int i = 1; i <= maxHeight; i++) {
            int waterHeight = i;

            // 현재 물높이의 최초 시작 지점 찾기
            while(height[first] < waterHeight && first < height.length) {
                first++;
            }

            // 현재 물높이의 마지막 시작 지점 찾기  
            while(height[last] < waterHeight && last >= 0) {
                last--;
            }

            if(
                (first == height.length) ||
                (last == -1) ||
                first >= last
            ) {
                continue;
            }

            int area = waterHeight * (last - first);
            result = Math.max(area, result);
        }

        return result;
    }

    private int getMaxHeight(int[] height) {
        int maxHeight = 0;
        for(int i = 0; i < height.length; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
        }

        return maxHeight;
    }
}