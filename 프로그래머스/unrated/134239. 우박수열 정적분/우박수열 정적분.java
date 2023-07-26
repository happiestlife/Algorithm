import java.util.*;
class Solution {
    public double[] solution(long k, int[][] ranges) {
        List<Double> widths = new ArrayList<>();
        int cnt = 0;
        
        long prev = k;
        while(k != 1){
            if(k % 2 == 0){
                k /= 2;
            }
            else{
                k = k * 3 + 1;
            }
            double width = ((double)prev + k) / 2;
            widths.add(width);
            prev = k;
            cnt++;
        }
        
        int idx = 0;
        double[] answer = new double[ranges.length];
        for(int i = 0; i < ranges.length; i++){
            int[] range = ranges[i];
            range[1] = cnt + range[1];
            
            if(range[0] > range[1]){
                answer[idx++] = -1;
            }
            else{
                double w = 0;
                // System.out.println(range[0] + ", " + range[1]);
                for(int j = range[0]; j <= range[1]; j++){
                    if(j == range[0])
                        continue; 
                    
                    // System.out.println(w + " << + " + widths.get(j - 1));
                    w += (double)widths.get(j - 1);
                }
                // System.out.println(w);
                answer[idx++] = w;
            }
        }
        
        return answer;
    }
}