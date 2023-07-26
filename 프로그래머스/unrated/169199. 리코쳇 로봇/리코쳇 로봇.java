import java.util.*;

class Solution {
    
    private static int EMPTY = 0;
    private static int HURDLE = -1;
    
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] board) {
        int[] goalPoint = new int[2];
        int[] startPoint = new int[2];
        int[][] map = new int[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            String row = board[i];
            for(int j = 0; j < row.length(); j++){
                char c = row.charAt(j);
                if(c == '.' || c == 'R' || c == 'G'){
                    map[i][j] = EMPTY;
                    if(c == 'R'){
                        startPoint[0] = i;
                        startPoint[1] = j;
                    }
                    else if(c == 'G'){
                        goalPoint[0] = i;
                        goalPoint[1] = j;
                    }
                }
                else {
                    map[i][j] = HURDLE;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(startPoint);
        while(!q.isEmpty()){
            // for(int[] row : map){
            //     for(int col : row){
            //         System.out.printf("%2d ", col);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            
            for(int i = 0; i < dx.length; i++){
                int fx = x, fy = y;
                while(true){
                    if(
                        (fx + dx[i] < 0 || fx + dx[i] >= map.length) ||
                        (fy + dy[i] < 0 || fy + dy[i] >= map[fx + dx[i]].length) ||
                        map[fx + dx[i]][fy + dy[i]] == HURDLE){
                        break;
                    }
                    fx += dx[i];
                    fy += dy[i];
                }
                
                if(map[fx][fy] == 0 && !(fx == startPoint[0] && fy == startPoint[1])){
                    // System.out.println("reach >> " + fx + ", " + fy);
                    if(fx == goalPoint[0] && fy == goalPoint[1]){
                        return map[x][y] + 1;
                    }
                    
                    map[fx][fy] = map[x][y] + 1;
                    q.add(new int[]{fx, fy});
                }
            }
            
        }
        
        return -1;
    }
}