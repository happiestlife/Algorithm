import java.util.*;

class Solution {
    
    private static final int PICKAX_SPAN = 5;
    
    private static final int DIAMOND = 0;
    private static final int IRON = 1;
    private static final int STONE = 2;
    private static final String[] rockType = {"diamond", "iron", "stone"};
    
    private static final int[][] tireByPickaxs = {
        {1,  1, 1},
        {5,  1, 1},
        {25, 5, 1}
    };
    
    
    private class StepRockType{
        int step;
        int[] rockCnt;
        
        public StepRockType(int step){
            this.step = step;
            this.rockCnt = new int[rockType.length];
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        List<StepRockType> stepRockCnt = new ArrayList<>();
        
        int picksCnt = 0;
        for(int i = 0; i < picks.length; i++){
            picksCnt += picks[i];
        }
        
        int maxLen = Math.min(picksCnt * PICKAX_SPAN, minerals.length);
        
        StepRockType rockCnt = new StepRockType(0);
        for(int i = 0; i < maxLen; i++){
            setRockCnt(rockCnt, minerals[i]);
            if(i % PICKAX_SPAN == PICKAX_SPAN - 1){
                stepRockCnt.add(rockCnt);
                rockCnt = new StepRockType((i+1) / PICKAX_SPAN);
            }
        } 
        if(minerals.length % PICKAX_SPAN != 0){
            stepRockCnt.add(rockCnt);
        }
        
        Collections.sort(stepRockCnt, (c1, c2) -> {
            if(c1.rockCnt[DIAMOND] == c2.rockCnt[DIAMOND]){
                if(c1.rockCnt[IRON] == c2.rockCnt[IRON] ){
                    return c2.rockCnt[STONE] - c1.rockCnt[STONE];
                }
                else{
                    return c2.rockCnt[IRON]  - c1.rockCnt[IRON] ;
                }
            }
            return c2.rockCnt[DIAMOND] - c1.rockCnt[DIAMOND];
        });
        
//         for(StepRockType i : stepRockCnt){
//             System.out.print(i.step + " >> ");
//             for(int cnt : i.rockCnt){
//                 System.out.print(cnt + " ");
//             }
//             System.out.println();
//         }
        
        int tireSum = 0;
        for(int i = 0; i < stepRockCnt.size(); i++){
            StepRockType srt = stepRockCnt.get(i);
            for(int j = 0; j < picks.length; j++){
                if(picks[j] <= 0)
                    continue;
                
                int[] pickaxAbility = tireByPickaxs[j];
                
                int s = PICKAX_SPAN * srt.step;
                int e = Math.min(PICKAX_SPAN * (srt.step + 1), minerals.length);
                for(int k = s; k < e; k++){
                    int type = 0;
                    for(int l = 0; l < rockType.length; l++){
                        if(minerals[k].equals(rockType[l])){
                            type = l;
                            break;
                        }
                    }
                    
                    tireSum += tireByPickaxs[j][type];
                }
                
                // System.out.println(tireSum);
                
                
                picks[j]--;
                break;
            }
            // System.out.println(tireSum);
        }
        
        return tireSum;
    }
    
    private void setRockCnt(StepRockType rockCnt, String rock){
        for(int i = 0; i < rockType.length; i++){
            if(rock.equals(rockType[i])){
                rockCnt.rockCnt[i]++;
            }
        }
    }
}