import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] isVisited = new boolean[1000001];

        // [0] : 숫자, [1] : 연산 횟수
        Queue<int[]> q = new LinkedList<>();

        int rs = -1;
        q.add(new int[]{x, 0});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int number = node[0];
            if(number == y){
                rs = node[1];
                break;
            }

            int nextCalCnt = node[1] + 1;
            for (int i = 0; i < 3; i++) {
                int calcNum = cal(n, number, i);
                if (calcNum <= y && !isVisited[calcNum]) {
                    q.add(new int[]{calcNum, nextCalCnt});
                    isVisited[calcNum] = true;
                }
            }
        }
        
        return rs;
    }
    
    private static int cal(int addNum, int number, int idx) {
        switch (idx){
            case 0:
                return number + addNum;
            case 1:
                return number * 2;
            default:
                return number * 3;
        }
    }
}