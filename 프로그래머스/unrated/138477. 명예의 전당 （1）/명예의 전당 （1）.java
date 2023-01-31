import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        
        int[] rs = new int[score.length];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i = 0; i < score.length; i++){
            if(heap.size() < k){
                heap.add(score[i]);
            }else{
                if(heap.peek() < score[i]){
                    heap.add(score[i]);
                    heap.poll();
                }
            }
            
            rs[i] = heap.peek();
        }
        
        return rs;
    }
}