import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        List<Integer> deployCnt = new ArrayList<>();
        int beforeNeedDays = -1;
        int cnt = 0;
        for (int i = 0; i < progresses.length; i++) {
            int needDays = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);

            if(beforeNeedDays == -1){
                beforeNeedDays = needDays;
            }
            else if(beforeNeedDays < needDays){
                deployCnt.add(cnt);
                cnt = 0;
                beforeNeedDays = needDays;
            }
            
            cnt++;
        }
        deployCnt.add(cnt);

        int idx = 0;
        int[] rs = new int[deployCnt.size()];
        for (Integer count : deployCnt) {
            rs[idx++] = count;
        }
        
        return rs;
    }
}