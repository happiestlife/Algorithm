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

        for (int i = 0; i < n; i++) {
            dfs(0, i, 1);
        }

        System.out.println(count);

        br.close();
    }

    public static void dfs(int x, int y, int level) {
        /**
         * 1. 방문 check
         * 2. 연결된 곳으로 순회
         *   3. 갈 수 있는가
         *   - 전 노드 제외 & 방문하지 않은 map 모든 곳
         *      4. 간다
         *      * 만약 n과 level이 같다면 count++, 가지는 않음
         * 5. 방문 ckeckout
         */
        if (level == n) {
//            System.out.println("level " + level);
//            for (int[] ints : m) {
//                for (int i : ints) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
//            }
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
