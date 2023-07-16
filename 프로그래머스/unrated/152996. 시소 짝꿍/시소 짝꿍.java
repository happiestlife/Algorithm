import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Long> peopleCntByWeigth = new HashMap<>();
        for(int w : weights){
            if(peopleCntByWeigth.containsKey(w)){
                peopleCntByWeigth.put(w, peopleCntByWeigth.get(w) + 1);
            }
            else{
                peopleCntByWeigth.put(w, 1L);
            }
        }
        
        long answer = 0;
        int idx = 0;
        int[] ws = new int[peopleCntByWeigth.size()];
        for(Map.Entry<Integer, Long> cntByWeight : peopleCntByWeigth.entrySet()){
            int weight = cntByWeight.getKey();
            long cnt = cntByWeight.getValue();

            ws[idx++] = weight;
            if(cnt >= 1)
                answer += (cnt * (cnt - 1)) / 2;
        }
        
        for(int i = 0; i < ws.length; i++){
            for(int j = i + 1; j < ws.length; j++){
                int w1 = Math.min(ws[i], ws[j]);
                int w2 = Math.max(ws[i], ws[j]);
                
                // System.out.println("orgin >> " + w1 + ", " + w2);
                // System.out.println("      >> " + w1 * 2 + ", " + w2 * 3 + " = " + (w1 * 3 == w2 * 2));
                // System.out.println("      >> " + w1 * 2 + ", " + w2 * 4 + " = " + (w1 * 3 == w2 * 2));
                // System.out.println("      >> " + w1 * 3 + ", " + w2 * 4 + " = " + (w1 * 4 == w2 * 3));
                
                if(w1 == w2 ||
                   w1 * 3 == w2 * 2 ||
                   w1 * 4 == w2 * 2 ||
                   w1 * 4 == w2 * 3)
                    answer += peopleCntByWeigth.get(w1) * peopleCntByWeigth.get(w2);
            }
        }
        return answer;
    }
}