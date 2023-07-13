class Solution {
    
    private static final char PERSON = 'P';
    private static final char TABLE = '0';
    private static final char PARTITION = 'X';
    
    private static final int[] lineDx = {-1, 0, 1,  0};
    private static final int[] lineDy = { 0, 1, 0, -1};
    
    private static final int[] crossDx = {-1, -1, 1,  1};
    private static final int[] crossDy = {-1,  1, 1, -1};
    
    private boolean isOutOfRoom(char[][] room, int x, int y){
        return (x < 0 || x >= room.length) || ( y < 0 || y >= room[x].length);
    }
    
    private boolean isSafe(char[][] room, int x, int y){
        // System.out.println(x + ", " + y);
        for(int i = 0; i < lineDx.length; i++){
            int dx = lineDx[i];
            int dy = lineDy[i];

            // (-1,0) , (-2,0) 모두 검사하기 위함
            for(int j = 1; j <= 2; j++){
                int len = Math.max(Math.abs(dx), Math.abs(dy)) * j;
                int fx = x, fy = y;
                boolean isOutOfRoom = false;
                boolean passPartition = false;
                for(int k = 0; k < len; k++){
                    fx += dx;
                    fy += dy;
                    
                    isOutOfRoom = isOutOfRoom(room, fx, fy);
                    if(isOutOfRoom){
                        break;
                    }
                    
                    if(room[fx][fy] == PARTITION){
                        passPartition = true;
                    }
                }
                
                if(!isOutOfRoom && !passPartition && room[fx][fy] == PERSON){
                    // System.out.println(isOutOfRoom + ", " + passPartition + " x : " + fx + ", y : " + fy + " (" + dx + ","+dy+ ") len " + len);
                    // System.out.println("no partition " + dx + ", " + dy + " >> * " + j);
                    return false;
                }
            }
        }
        
        
        for(int i = 0; i < crossDx.length; i++){
            int dx = crossDx[i];
            int dy = crossDy[i];
            
            // 초기화
            int fx = x, fy = y;
            boolean passPartition = false;
            
            // 1. x부터 move
            fx += dx;
            if(isOutOfRoom(room, fx, fy))
                continue;
            
            if(room[fx][fy] == PARTITION){
                passPartition = true;
            }
            fy += dy;
            if(isOutOfRoom(room, fx, fy))
                continue;
            
            if(!passPartition && room[fx][fy] == PERSON){
                return false;
            }
            
            // 초기화
            fx = x; fy = y;
            passPartition = false;
            
            // 2. y부터 move
            fy += dy;
            if(isOutOfRoom(room, fx, fy))
                continue;
            
            if(room[fx][fy] == PARTITION){
                passPartition = true;
            }
            fx += dx;
            if(isOutOfRoom(room, fx, fy))
                continue;
            
            if(!passPartition && room[fx][fy] == PERSON){
                return false;
            }
        }
        
        return true;
    }
    
    public int[] solution(String[][] places) {

        char[][][] waitRooms = new char[5][5][5];
        for(int i = 0; i < places.length; i++){
            for(int j = 0; j < places[i].length; j++){
                String input = places[i][j];
                for(int k = 0; k < input.length(); k++){
                    waitRooms[i][j][k] = input.charAt(k);
                }
            }
        }
        
        int idx = 0;
        int[] answer = new int[5];
        for(int i = 0; i < waitRooms.length; i++){
            int curAnswer = 1;
            
            // for(char[] j : waitRooms[i]){
            //     for(char k : j){
            //         System.out.print(k + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            
            for(int x = 0; x < waitRooms[i].length; x++){
                for(int y = 0; y < waitRooms[i][x].length; y++){
                    char c = waitRooms[i][x][y];
                    if(c == PERSON && !isSafe(waitRooms[i], x, y)){
                        curAnswer = 0;
                        break;
                    }
                }
            }
            
            answer[idx++] = curAnswer;
        }
        
        return answer;
    }
}