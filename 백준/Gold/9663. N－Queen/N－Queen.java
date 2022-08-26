import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int n;
    static boolean map[][];
    static int count;

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        // 퀸이 n개 이려면 한층에 한개씩 존재해야 한다.
        // 따라서 DFS는 X축 한 칸씩에 대해서 실시
        for (int i = 0; i < n; i++) {
            dfs(0, i, 1);
        }

        System.out.println(count);

        br.close();
    }

    public static void dfs(int x, int y, int level) {
        /**
         * 0. 만약 n과 level이 같다면 count++
         * 1. 방문 check
         * 2. 연결된 곳으로 순회
         *   3. 갈 수 있는가
         *   - 이전 노드 다음층(x+1) & 이전 퀸들과 겹치지 않는 동선(가려는 노드의 왼쪽 위로, 오른쪽 위로 향하는 대각에 퀸이 있는지 검사)
         *      4. 간다
         * 5. 방문 ckeckout
         */
        if (level == n) {
            count++;
            return;
        }
        
        map[x][y] = true;

        for (int i = 0; i < n; i++) {
            if (checkRoute(x+1, i, level)) {
                dfs(x+1, i, level + 1);
            }
        }

        map[x][y] = false;

    }

    public static boolean checkRoute(int x, int y, int level) {
        for (int i = 0; i < level; i++) {
            // y축 체크
            if(map[i][y])
                return false;
        }

        // 왼쪽 위 대각 체크
        int mx = x-1, my = y-1;
        while (mx >= 0 && my >= 0) {
            if(map[mx][my])
                return false;

            mx--; my--;
        }

        // 오른쪽 위 대각 체크
        mx = x-1; my = y+1;
        while (mx >= 0 && my < n) {
            if(map[mx][my])
                return false;

            mx--; my++;
        }

        return true;
    }
}
