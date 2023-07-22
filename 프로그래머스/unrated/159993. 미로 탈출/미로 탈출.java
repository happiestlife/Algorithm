import java.util.*;

class Solution {
    
    private static final char PATH = 'O';
    private static final char START = 'S';
    private static final char EXIT = 'E';
    private static final char WALL = 'X';
    private static final char LEVER = 'L';
    
    private static final int[] dx = {-1, 0, 1,  0};
    private static final int[] dy = {0,  1, 0, -1};
    
    private char[][] map;
    
    public int solution(String[] maps) {
        
        map = new char[maps.length][];
        
        // [0] : x, [1] : y
        int[] startPoint = new int[2];
        int[] leverPoint = new int[2];
        for(int i = 0; i < maps.length; i++){
            String row = maps[i];
            map[i] = new char[row.length()];
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == START){
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
                else if(map[i][j] == LEVER){
                    leverPoint[0] = i;
                    leverPoint[1] = j;
                }
            }
        }
        
        for(char[] row : map){
            for(char d : row){
                System.out.print(d + " ");
            }
            System.out.println();
        }
        
        // 1. 레버 찾기
        int toLeverTime = getShortestTimeToDest(startPoint, LEVER);
        if(toLeverTime == -1){
            return toLeverTime;
        }
        // System.out.println(toLeverTime);
        
        // 2. 출구 찾기
        int toExitCnt = getShortestTimeToDest(leverPoint, EXIT);
        if(toExitCnt == -1){
            return toExitCnt;
        }
        // System.out.println(toExitCnt);

        return toLeverTime + toExitCnt;
    }
    
    public int getShortestTimeToDest(int[] p, int dest){
        // [0] : x, [1] : y
        Queue<int[]> q = new LinkedList<>();
        int[][] cntMap = new int[map.length][map[0].length];
        q.add(new int[]{p[0], p[1]});
        while(!q.isEmpty()){
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            
            for(int i = 0; i < dx.length; i++){
                int fx = x + dx[i];
                int fy = y + dy[i];
                
                if((0 <= fx && fx < map.length) &&
                   (0 <= fy && fy < map[fx].length) &&
                   map[fx][fy] != WALL && 
                   cntMap[fx][fy] == 0){
                    cntMap[fx][fy] = cntMap[x][y] + 1;
                    if(map[fx][fy] == dest){
                        return cntMap[fx][fy];
                    }
                    
                    q.add(new int[]{fx, fy});
                }
            }
        }
        
        return -1;
    }
}