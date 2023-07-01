import java.util.*;

class Solution {
    
    final int[] dx = {-1, 0, 1, 0};
    final int[] dy = {0, 1, 0, -1};
    
    int[][] map;
    
    public long dfs(int x, int y){
        long liveTime = map[x][y];
        map[x][y] = 0;

        for(int i = 0; i < dx.length; i++){
            int fx = x + dx[i];
            int fy = y + dy[i];
            
            if(0 <= fx && fx < map.length && 
               0 <= fy && fy < map[fx].length &&
               map[fx][fy] != 0){
               liveTime += dfs(fx, fy);
            }
        }
        
        return liveTime;
    }
    
    public long[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            String line = maps[i];
            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j);
                if(c == 'X')
                    map[i][j] = 0;
                else
                    map[i][j] = Character.getNumericValue(c);
            }
        }
        
        List<Long> rs = new ArrayList<>();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] != 0){
                    rs.add(dfs(i, j));
                }
            }
        }
        if(rs.size() == 0){
            rs.add(-1L);
        }
        Collections.sort(rs);
        
        
        long[] answer = new long[rs.size()];
        for(int i = 0; i < rs.size(); i++){
            answer[i] = rs.get(i);
        }
        return answer;
    }
}