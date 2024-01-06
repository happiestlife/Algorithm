import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;

    private static int m;

    private static int nums[];

    private static int[] curNumIdxs;
    private static Set<String> resultSet = new HashSet<>();

    private static StringBuilder rs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        nums = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(nums);

        curNumIdxs = new int[m];
        for (int i = 0; i < nums.length; i++) {
            select(0, i);
        }
        System.out.println(rs);

        br.close();
    }

    public static void select(int cnt, int idx) {
        curNumIdxs[cnt] = idx;
        if (cnt == m - 1) {
            calc();
            curNumIdxs[cnt] = -1;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(isInCurNums(i)) continue;

            select(cnt + 1, i);
        }

        curNumIdxs[cnt] = -1;
    }

    public static boolean isInCurNums(int idx){
        for (int j = 0; j < curNumIdxs.length; j++) {
            if (idx == curNumIdxs[j]) {
                return true;
            }
        }

        return false;
    }

    public static void calc() {
        String compString = convertNumsToString();
        if(resultSet.contains(compString)){
            return;
        }

        resultSet.add(compString);
        rs.append(compString + "\n");
    }

    public static String convertNumsToString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curNumIdxs.length; i++) {
            sb.append(nums[curNumIdxs[i]] + " ");
        }

        return sb.toString().trim();
    }
}