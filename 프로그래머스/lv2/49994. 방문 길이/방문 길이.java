import java.util.*;

class Solution {
    public int solution(String dirs) {
        final int SIZE = 11;
                        // U  R  D  L
        final int[] fx = { 0, 1, 0,-1};
        final int[] fy = {-1, 0, 1, 0};
        final char[] move = {'U', 'R', 'D', 'L'};

        // if-else if문을 없애고 배열로 간편하게 연산하기 위한 용도
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < move.length; i++) {
            map.put(move[i], i);
        }

        // [현재 x][움직인 x][현재 y][움직인 y]
        boolean[][][][] isVisited = new boolean[SIZE][SIZE][SIZE][SIZE];

        int rs = 0;
        int x = 5, y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int idx = map.get(c);

            int curX = x;
            int curY = y;
            int moveX = x + fx[idx];
            int moveY = y + fy[idx];

            // 경계선을 넘어가지 않도록 하기
            if(moveX < 0 || moveX >= SIZE ||
                moveY < 0 || moveY >= SIZE)
                continue;

            // 방문하지 않았어야 정답
            if(!isVisited[curX][moveX][curY][moveY]) {
                rs++;
                isVisited[curX][moveX][curY][moveY] = true;
                isVisited[moveX][curX][moveY][curY] = true;
            }

            x = moveX; y = moveY;
        }
        
        return rs;
    }
}