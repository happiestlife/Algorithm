import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        final int NOT_RESULT = 0;
        final int RESULT = 1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int flag = NOT_RESULT;
            if (i == location) {
                flag = RESULT;
            }

            q.add(new int[]{priorities[i], flag});
            minHeap.add(priorities[i]);
        }

        int rs = 1;
        while (!q.isEmpty()) {
            int[] node = q.peek();
            if(node[0] == minHeap.peek()){
                if(node[1] == RESULT)
                    break;
                q.poll();
                minHeap.poll();
                rs++;
            }else{
                q.add(q.poll());
            }
        }
        
        return rs;

    }
}