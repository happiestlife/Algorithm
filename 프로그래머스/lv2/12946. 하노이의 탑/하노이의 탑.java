import java.util.*;

class Solution {
    
    private List<int[]> rs = new ArrayList<>(30000);
    
    private void hanoi(int cnt, int from, int tmp, int to){
        if(cnt > 1){
            hanoi(cnt - 1, from, to, tmp);
        }
        rs.add(new int[]{from, to});
        if(cnt > 1){
            hanoi(cnt - 1, tmp, from, to);
        }
    }
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[rs.size()][2];
        for(int i = 0; i < rs.size(); i++){
            answer[i] = rs.get(i);
        }
        
        return answer;
    }
}