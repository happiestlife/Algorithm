import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            heap.add((long)scoville[i]);
        }

        int rs = 0;
        while (heap.size() >= 2) {
            if(heap.peek() >= K)
                break;

            long num1 = heap.poll();
            long num2 = heap.poll();

            heap.add(num1 + num2 * 2);
            rs++;
        }
        
        if(heap.peek() < K)
            rs = -1;
        
        return rs;
    }
}