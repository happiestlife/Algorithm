package P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        int[] profits = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < profits.length; i++) {
            profits[i] = Integer.parseInt(stk.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int profit = profits[i];
            if (map.containsKey(profit)) {
                map.put(profit, map.get(profit) + 1);
            }else{
                map.put(profit, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.keySet().size() + " ");
        for (int i = k; i < profits.length; i++) {
            int prevProfit = profits[i - k];
            int nextProfit = profits[i];

            if(map.get(prevProfit) <= 1){
                map.remove(prevProfit);
            }else{
                map.put(prevProfit, map.get(prevProfit) - 1);
            }

            if(map.containsKey(nextProfit)){
                map.put(nextProfit, map.get(nextProfit) + 1);
            }else{
                map.put(nextProfit, 1);
            }

            sb.append(map.keySet().size() + " ");
        }

        System.out.println(sb);

        br.close();
    }
}
