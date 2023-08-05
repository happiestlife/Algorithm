class Solution {
    
    private static int FAIL = 0;
    private static int SUCCESS = 1;
    
    private static int MAP_SIZE = 3;
    
    private static int[][] move = { 
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}
          };
    
    public int solution(String[] board) {

        char[][] map = new char[MAP_SIZE][MAP_SIZE];
        
        int oCnt = 0, xCnt = 0;
        for(int i = 0; i < board.length; i++){
            String str = board[i];
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'O'){
                    oCnt++;
                }
                else if(map[i][j] == 'X'){
                    xCnt++;
                }
            }
        }
        
        char findType = ' ';
        if(oCnt < xCnt || oCnt > xCnt + 1){
            return FAIL;
        }
        else if(oCnt == xCnt){
            findType = 'O';
        }
        else{
            findType = 'X';
        }
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == findType){
                    for(int k = 0; k < move.length; k++){
                        int[] m = move[k];
                        int dx = m[0];
                        int dy = m[1];
                        
                        int sameCnt = 0;
                        int fx = i, fy = j;
                        while((0 <= fx && fx < map.length) && 
                              (0 <= fy && fy < map[fx].length) &&
                              map[fx][fy] == findType){
                            sameCnt++;
                            if(sameCnt == MAP_SIZE) break;
                            fx += dx;
                            fy += dy;
                        }
                        
                        if(sameCnt == MAP_SIZE){
                            return FAIL;
                        }
                    }
                }
            }
        }
        
        return SUCCESS;
    }
}