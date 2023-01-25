import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static final int[][] type = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] answers) {
      // [0] : 사람번호, [1] : 정답수
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < 3; i++){
            int correctCnt = calc(answers, i);
            // 전제 : 큐에는 항상 같은 수들만 존재
            // 1. 현재 사람의 정답수 > 큐의 정답수
            //      - 모든 큐데이터 클리어
            //      - 큐에 현재 사람의 정답수 넣기
            // 2. 현재 사람의 정답수 == 큐의 정답수
            //      - 큐에 현재 사람의 정답수 넣기
            // 3. 현재 사람의 정답수 < 큐의 정답수
            //      - 아무것도 하지 않음
            if(q.isEmpty()){
                q.add(new int[]{i, correctCnt});
            }
            else if(!q.isEmpty() && correctCnt >= q.peek()[1]){
                if(correctCnt > q.peek()[1]){
                    q.clear();
                }
                q.add(new int[]{i, correctCnt});
            }
        }

        int[] rs = new int[q.size()];
        for(int i = 0; i < rs.length; i++){
            rs[i] = q.poll()[0]+1;
        }
        
        return rs;
    }
    
    public static int calc(int[] a, int t){
        int typeIdx = 0;
        int rs = 0;
        for (int i = 0; i < a.length; i++) {
            if(type[t][typeIdx++] == a[i])
                rs++;

            if(typeIdx == type[t].length)
                typeIdx = 0;
        }

        return rs;
    }
}