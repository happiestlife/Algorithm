import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[] dx = { 1, 1, 1};
    private static final int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] isVisited = new int[n][n];
        int result = dfs(isVisited, 0);

        System.out.println(result);

        br.close();
    }

    private static int dfs(int[][] isVisited, int x) {
        int n = isVisited.length;
        if(x == n) {
            return 1;
        }

        int result = 0;
        for(int y = 0; y < n; y++) {
            if(isVisited[x][y] >= 1) continue;

            visit(isVisited, x, y, true);

            result += dfs(isVisited, x+1);

            visit(isVisited, x, y, false);
        }


        return result;
    }

    private static void visit(int[][] isVisited, int x, int y, boolean isVisitNow) {
        final int n = isVisited.length;

        int addCnt = isVisitNow ? 1 : -1;

        for (int i = 0; i < dx.length; i++) {
            int fx = x;
            int fy = y;
            while(
                (0 <= fx && fx < n) &&
                (0 <= fy && fy < n)
            ) {
                isVisited[fx][fy] += addCnt;
                fx += dx[i];
                fy += dy[i];
            }
        }
    }
}
