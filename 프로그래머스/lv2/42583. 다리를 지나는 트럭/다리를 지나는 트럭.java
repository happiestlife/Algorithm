import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int weightSum = 0;
        // [0] : 차량무게, [1] : 종료시간
        Queue<int[]> q = new LinkedList<>();
        int truckIdx = 0;
        while(true){
            while (!q.isEmpty() && q.peek()[1] == time) {
                weightSum -= q.poll()[0];
            }

            if (truckIdx < truck_weights.length
                    && q.size() + 1 <= bridge_length
                    && weightSum + truck_weights[truckIdx] <= weight) {
                weightSum += truck_weights[truckIdx];
                q.add(new int[]{truck_weights[truckIdx++], time+bridge_length});
            }

            time++;

            if (q.isEmpty() && truckIdx == truck_weights.length) {
                break;
            }
        }
        
        return time;
    }
}