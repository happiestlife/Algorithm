import java.util.*;

class Solution {
    
    // 오른쪽, 아래, 왼쪽, 위에 대한 움직임
    static final int[] fx = {0, 1, 0, -1};
    static final int[] fy = {1, 0, -1, 0};
    static final int PATH = 1;
    
    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        // [0] : x 좌표, [1] : y 좌표, [2] : 움직인 횟수
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        int rs = -1;
        while(!q.isEmpty()){
            int[] p = q.poll();
            if(p[0] == maps.length-1 && p[1] == maps[0].length-1) {
                rs = p[2];
                break;
            }

            for (int i = 0; i < fx.length; i++) {
                int mx = p[0] + fx[i];
                int my = p[1] + fy[i];
                // 움직이려는 point의 x와 y가 경계선을 넘지 않고
                if((0 <= mx && mx < maps.length &&
                        0 <= my && my < maps[0].length) &&
                        // 벽이 아니고
                        maps[mx][my] == PATH &&
                        // 지나가지 않은 길이라면
                        !isVisited[mx][my]
                ){
                    q.add(new int[]{mx, my, p[2] + 1});
                    // !! 해당 경로가 먼저 갈 경로이기 때문에 나중에 가려고 해도 늦은 경로로 판단하기 위해
                    // !! 미리 넣은 것으로 처리
                    isVisited[mx][my] = true;
                }
            }
        }

        return rs;
    }
}