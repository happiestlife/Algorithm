import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String s) {
        // 1. 문자열 파싱
        s = s.substring(1, s.length() - 1);
        // 각 튜플의 요소 중 적은 길이의 것부터 나열하기 위함
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.length));
        int openIdx = -1, closeIdx = -1;
        while (true) {
            openIdx  = s.indexOf('{');
            closeIdx = s.indexOf('}');
            // 각 요소의 {}를 제거하고 ,를 기준으로 튜플 요소 안 데이터를 가져온다.
            StringTokenizer stk = new StringTokenizer(s.substring(openIdx + 1, closeIdx), ",");
            int[] eleArr = new int[stk.countTokens()];
            for (int i = 0; i < eleArr.length; i++) {
                eleArr[i] = Integer.parseInt(stk.nextToken());
            }

            heap.add(eleArr);

            if(closeIdx == s.length()-1)
                break;

            s = s.substring(closeIdx + 1);
        }

        // 2. 튜플 구하기
        int rsIdx = 0;
        int[] rs = new int[heap.size()];
        boolean[] isFound = new boolean[100001];
        while (!heap.isEmpty()) {
            int[] ele = heap.poll();
            for (int num : ele) {
                if (isFound[num]) {
                    continue;
                } else {
                    isFound[num] = true;
                    rs[rsIdx++] = num;
                }
            }
        }
        
        return rs;
    }
}