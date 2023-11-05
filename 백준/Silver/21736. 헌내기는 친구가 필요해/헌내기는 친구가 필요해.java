import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final int[] dx = {-1, 0, 1, 0};
        final int[] dy = {0, 1, 0, -1};
        final int WALL = -1, EMPTY = 0, START = 1, PEOPLE = 2;
        final Map<Character, Integer> converter = new HashMap<>();
        converter.put('O', EMPTY);
        converter.put('X', WALL);
        converter.put('I', START);
        converter.put('P', PEOPLE);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] map = new int[n][m];
        int[] startPoint = new int[2];
        for (int i = 0; i < map.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                map[i][j] = converter.get(c);
                if(map[i][j] == START){
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(startPoint);
        map[startPoint[0]][startPoint[1]] = WALL;
        int visitPeopleCnt = 0;
        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int fx = point[0] + dx[i];
                int fy = point[1] + dy[i];

                if ((0 <= fx && fx < n) &&
                        (0 <= fy && fy < m) &&
                        map[fx][fy] != WALL) {
                    q.add(new int[]{fx, fy});
                    if(map[fx][fy] == PEOPLE){
                        visitPeopleCnt++;
                    }
                    map[fx][fy] = WALL;
                }
            }
        }

        if(visitPeopleCnt == 0){
            System.out.println("TT");
        }else {
            System.out.println(visitPeopleCnt);
        }

        br.close();
    }
}
