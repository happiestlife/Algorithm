package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class P8_8 {

    private static List<Integer> nums;
    private static boolean[] isVisited;

    private static int n;
    private static int f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        f = Integer.parseInt(stk.nextToken());

        isVisited = new boolean[n + 1];
        nums = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if(dfs(i))
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i) + " ");
        }

        System.out.println(sb);


        br.close();
    }

    public static boolean dfs(int num) {
        nums.add(num);
        isVisited[num] = true;
        if (nums.size() == n) {
            if(isSuccess())
                return true;
            else{
                nums.remove(nums.size() - 1);
                isVisited[num] = false;
                return false;
            }
        }

        for (int i = 1; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                if(dfs(i))
                    return true;
            }
        }

        nums.remove(nums.size() - 1);
        isVisited[num] = false;
        return false;
    }

    public static boolean isSuccess() {
        Integer[][] map = new Integer[n][n];
        map[0] = nums.toArray(new Integer[0]);
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map.length - i; j++) {
                map[i][j] = map[i - 1][j] + map[i - 1][j + 1];
            }
        }

        return map[map.length - 1][0] == f;
    }
}
