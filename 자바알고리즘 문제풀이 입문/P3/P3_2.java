package P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class P3_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer stk;

        n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(stk.nextToken()));
        }

        List<Integer> rs = new ArrayList<>();
        m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(stk.nextToken());

            if(set.contains(num)){
                rs.add(num);
            }
        }

        Collections.sort(rs);
        StringBuilder sb = new StringBuilder();
        for (Integer num : rs) {
            sb.append(num + " ");
        }

        System.out.println(sb);

        br.close();
    }
}