package P9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P9_6 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        parent = new int[n + 1];
        IntStream.range(1, parent.length)
                .forEach((idx) -> parent[idx] = idx);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            int tmp = a;
            a = Math.min(a, b);
            b = Math.max(tmp, b);

            int aParent = find(a);
            int bParent = find(b);

            if(aParent != bParent){
                if(aParent > bParent){
                    parent[bParent] = aParent;
                }else{
                    parent[aParent] = bParent;
                }
            }
        }

        stk = new StringTokenizer(br.readLine());
        int f1 = Integer.parseInt(stk.nextToken());
        int f2 = Integer.parseInt(stk.nextToken());

        if (find(f1) == find(f2)) {
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }


        br.close();
    }

    public static int find(int node){
        if(node == parent[node]){
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}
