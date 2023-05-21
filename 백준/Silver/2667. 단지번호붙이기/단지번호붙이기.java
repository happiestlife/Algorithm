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

    static List<Integer> oneBlockApartmentCnt;

    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        String input;
        for (int i = 0; i < map.length; i++) {
            input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        oneBlockApartmentCnt = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]){
                    dfs(i, j);
                    blockCnt++;
                    oneBlockApartmentCnt.add(curBlockApartmentCnt);
                    curBlockApartmentCnt = 0;
                }
            }
        }

        Collections.sort(oneBlockApartmentCnt);

        StringBuilder sb = new StringBuilder();
        sb.append(blockCnt + "\n");
        for (Integer apartCnt : oneBlockApartmentCnt) {
            sb.append(apartCnt + "\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static void dfs(int x, int y){
        isVisited[x][y] = true;
        curBlockApartmentCnt++;

        int mapMaxSize = map.length;
        for (int i = 0; i < dx.length; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if ((0 <= moveX && moveX < mapMaxSize) &&
                    (0 <= moveY && moveY < mapMaxSize) &&
                    map[moveX][moveY] == 1 &&
                    !isVisited[moveX][moveY]) {
                dfs(moveX, moveY);
            }
        }
    }

}
