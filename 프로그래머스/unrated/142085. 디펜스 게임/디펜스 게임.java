import java.util.Collections;
import java.util.PriorityQueue;


class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());

        int round = 0;
        int totalEnemy = 0;
        for (;; round++) {

            totalEnemy += enemy[round];
            maxh.add(enemy[round]);

            if(totalEnemy > n){
                if(k > 0){
                    if(!maxh.isEmpty()) {
                        totalEnemy -= maxh.poll();
                    }
                    k--;
                }else{
                    round--;
                    break;
                }
            }

            if(round == enemy.length - 1)
                break;
        }

        return round + 1;
    }
}