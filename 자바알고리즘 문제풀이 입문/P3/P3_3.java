package P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        int[] sales;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        sales = new int[n];

        int max = 0, curSum = 0;
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < sales.length; i++) {
            sales[i] = Integer.parseInt(stk.nextToken());
            if(i < k)
                curSum += sales[i];
        }

        max = curSum;
        for (int i = k; i < sales.length; i++) {
            curSum -= sales[i-k];
            curSum += sales[i];
            if(curSum > max)
                max = curSum;
        }

        System.out.println(max);


        br.close();
    }
}
