import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int max = 0;
        boolean[] isVisited = new boolean[cards.length];
        boolean[] isVisited2 = new boolean[cards.length];
        for(int i = 0; i < cards.length; i++){
            int openBoxCnt1 = getBoxCnt(cards, i, isVisited);
            if(openBoxCnt1 == 0){
                continue;
            }
            
            // System.out.print("first >> ");
            // for(boolean b : isVisited){
            //     if(b){
            //         System.out.print("T ");
            //     }
            //     else{
            //         System.out.print("F ");
            //     }
            // }
            // System.out.println();
            
            for(int j = 0; j < cards.length; j++){
                if(isVisited[j])
                    continue;
                System.arraycopy(isVisited, 0, isVisited2, 0, isVisited2.length);
                // System.out.print("second >> ");
                // for(boolean b : isVisited){
                //     if(b){
                //         System.out.print("T ");
                //     }
                //     else{
                //         System.out.print("F ");
                //     }
                // }
                // System.out.println();
                
                int openBoxCnt2 = getBoxCnt(cards, j, isVisited2);
                max = Math.max(max, openBoxCnt1 * openBoxCnt2);
            }
            
            // 초기화
            Arrays.fill(isVisited, false);
        }
        
        return max;
    }
    
    public int getBoxCnt(int[] cards, int s, boolean[] isVisited){
        int cnt = 0;
        while(true){
            if(isVisited[s]){
               break; 
            }
            isVisited[s] = true;
            cnt++;
            s = cards[s] - 1;
        }
        
        return cnt;
    }
}