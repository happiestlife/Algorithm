package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8_2 {

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[] dogs = new int[n];
        for (int i = 0; i < dogs.length; i++) {
            dogs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < dogs.length; i++) {
            dfs(c, dogs, i, dogs[i]);
        }

        System.out.println(max);

        br.close();
    }

    private static void dfs(int maxWeight, int[] dogs, int curIdx, int curWeightSum) {
        for (int i = curIdx + 1; i < dogs.length; i++) {
            int nextWeightSum = curWeightSum + dogs[i];
            if (nextWeightSum < maxWeight) {
                max = Math.max(max, nextWeightSum);
                dfs(maxWeight, dogs, i, nextWeightSum);
            }
        }
    }
}
