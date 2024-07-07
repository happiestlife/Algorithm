import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] opers) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int counter = 0;
        for (String oper : opers) {
            String[] operComp = oper.split(" ");
            char operator = operComp[0].charAt(0);
            int operand = Integer.parseInt(operComp[1]);

            if(operator == 'I') {
                minHeap.add(operand);
                maxHeap.add(operand);
                counter++;
            }
            else {
                if(minHeap.isEmpty() && maxHeap.isEmpty()) continue;

                if(operand == 1) maxHeap.poll();
                else minHeap.poll();
                counter--;

                if(minHeap.isEmpty() || maxHeap.isEmpty() || counter == 0) {
                    minHeap.clear();
                    maxHeap.clear();
                }
            }
        }

        if(minHeap.isEmpty()) return new int[]{0, 0};
        else return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}