import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    private static final int HOME = 1;
    private static final int CHICKEN = 2;

    static int n, m;
    static List<Integer> select;
    static Queue<Point> house;
    static List<Point> chicken;
    static int min = Integer.MAX_VALUE;
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        house = new LinkedList<>();
        chicken = new ArrayList<>();
        select = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int where = Integer.parseInt(stk.nextToken());
                if (where == HOME) {
                    house.add(new Point(i, j));
                } else if (where == CHICKEN) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < chicken.size(); i++) {
            dfs(i, 1);
        }
        System.out.println(min);

        br.close();
    }

    public static void dfs(int x, int level) {
        // 지금 치킨 지점보다 다음 위치에 있는 치킨집 dfs() 해보면서 최소거리 찾기

        // 방문중인 치킨집 위치 추가
        select.add(x);

        // 최대 치킨집 개수에 도달하면 거리 반환
        if (level == m) {
            min = Math.min(min, calcDist());
            select.remove(select.size() - 1);
            return;
        }

        // 현재보다 다음 위치에 있는 치킨집 방문해보면서 최소 거리 구하기
        for (int i = x+1; i < chicken.size(); i++) {
            dfs(i, level + 1);
        }

        // 방문중인 치킨집 위치 제거
        select.remove(select.size() - 1);
    }

    private static int calcDist() {
        int sum = 0;
        for (Point hp : house) {
            int min = Integer.MAX_VALUE;
            for (Integer ind : select) {
                int d = Math.abs(hp.x - chicken.get(ind).x) + Math.abs(hp.y - chicken.get(ind).y);
                min = Math.min(min, d);
            }

            sum += min;
        }

        return sum;
    }
}
