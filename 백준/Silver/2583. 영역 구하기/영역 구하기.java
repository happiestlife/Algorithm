import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 북, 동, 남, 서
    static final int[] dx = {-1, 0, 1,  0};
    static final int[] dy = { 0, 1, 0, -1};

    static int[][] map;

    static int blockCnt;

    static int curBlockApartmentCnt;

    static List<Integer> blockApartmentCnts;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        map = new int[m][n];
        for (int i = 0; i < k; i++) {
            // [0] : 시작 x, [1] : 시작 y, [2] : 종료 x , [3] : 종료 y
            int[] square = new int[4];
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < square.length; j++) {
                square[j] = Integer.parseInt(stk.nextToken());
            }

            for (int j = square[1]; j < square[3]; j++) {
                for (int l = square[0]; l < square[2]; l++) {
                    map[j][l] = 1;
                }
            }
        }

        blockApartmentCnts = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 0){
                    dfs(i, j);
                    blockCnt++;
                    blockApartmentCnts.add(curBlockApartmentCnt);
                    curBlockApartmentCnt = 0;
                }
            }
        }
        Collections.sort(blockApartmentCnts);

        StringBuilder sb = new StringBuilder(blockCnt + "\n");
        for (Integer cnt : blockApartmentCnts) {
            sb.append(cnt + " ");
        }

        System.out.println(sb);

        br.close();
    }

    public static void dfs(int x, int y){
        map[x][y] = 1;
        curBlockApartmentCnt++;

        for (int i = 0; i < dx.length; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if ((0 <= moveX && moveX < map.length) &&
                    (0 <= moveY && moveY < map[moveX].length) &&
                    map[moveX][moveY] == 0) {
                dfs(moveX, moveY);
            }
        }
    }

}