package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(stk.nextToken());
            sb.append(whoWin(a[i], b) + "\n");
        }
        System.out.println(sb);

        br.close();
    }

    public static String whoWin(int a, int b) {
        if(a == b){
            return "D";
        }else{
            String rst = a > b ? "A" : "B";
            switch(a + b){
                case 3:
                case 5:
                    return rst;
                case 4:
                    if(rst == "A")
                        return "B";
                    else
                        return "A";
                default:
                    return "";
            }
        }
    }
}