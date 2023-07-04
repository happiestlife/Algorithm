class Solution {
    
    // [i][0] : x, [i][1] : y
    final int[][] dxy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        
        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = num++;
            }
        }
        
        int idx = 0;
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int x  = query[0] - 1, y  = query[1] - 1;
            int ex = query[2] - 1, ey = query[3] - 1;
            int xLen = ey - y;
            int yLen = ex - x;
            
            int min = Integer.MAX_VALUE;
            int prevNum = map[x][y];
            for(int j = 0; j < dxy.length; j++){
                int dx = dxy[j][0];
                int dy = dxy[j][1];
                
                int len = 0;
                if(j % 2 == 0){
                    len = xLen;
                }
                else{
                    len = yLen;
                }
                
                for(int k = 0; k < len; k++){
                    x = x + dx;
                    y = y + dy;
                    int tmp = map[x][y];
                    map[x][y] = prevNum;
                    prevNum = tmp;
                    min = Math.min(min, prevNum);
                }
            }
            
            answer[idx++] = min;
        }
        
        return answer;
    }
}