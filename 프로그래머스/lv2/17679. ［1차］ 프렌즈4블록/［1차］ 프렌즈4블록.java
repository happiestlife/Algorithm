import java.util.*;

class Solution {

    static final int[] dx = {0, 0, -1, -1};
    static final int[] dy = {0, 1,  0,  1};
    
    public int solution(int m, int n, String[] board) {
        List<Character>[] map = new List[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = board.length - 1; j >= 0; j--) {
                map[i].add(board[j].charAt(i));
            }
        }

        int rs = 0;
        int x = m - 1, y = n - 1;
        // [0] : x좌표, [1] : y좌표
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isDeleted = new boolean[m][n];
        while (true) {
            for (int i = 0; i < isDeleted.length; i++) {
                Arrays.fill(isDeleted[i], false);
            }
            // 1. 검사하기 (x, 0) ~ (1, y-1)
            //    삭제 대상은 (x,y) 형태로 큐에 넣기
            for (int i = x; i > 0; i--) {
                for (int j = 0; j < y; j++) {
                    if(map[j].size() <= i)
                        continue;

                    char block = map[j].get(i);
                    boolean isSame = true;
                    for (int k = 0; k < dx.length; k++) {
                        int moveX = i + dx[k];
                        int moveY = j + dy[k];
                        if (moveX < 0 || moveX >= map[moveY].size() || block != map[moveY].get(moveX)) {
                            isSame = false;
                            break;
                        }
                    }

                    if(isSame){
                        int cc = 0;
                        for (int k = 0; k < dx.length; k++) {
                            int moveX = i + dx[k];
                            int moveY = j + dy[k];
                            if(isDeleted[moveX][moveY])
                                continue;

                            q.add(new int[]{moveX, moveY});
                            isDeleted[moveX][moveY] = true;
                        }
                    }
                }
            }

            // 2. 큐에 담겨있는 모든 좌표값 삭제
            //    해당 좌표가 삭제되어있는지를 나타내는 boolean isDeleted를 검사하면서 삭제
            // Break: 최초의 큐 검사에서 아무런 좌표가 담겨있지 않다면 break;
            if(q.isEmpty())
                break;

            while (!q.isEmpty()) {
                int[] point = q.poll();
                map[point[1]].remove(point[0]);
                isDeleted[point[0]][point[1]] = true;
                rs++;
            }
        }


        return rs;
    }
}