package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[] works = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < works.length; i++) {
            works[i] = Integer.parseInt(stk.nextToken());
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < works.length; i++) {
            int cacheNum = works[i];
            // 캐시 히트일 때
            int cacheIdx = list.indexOf(cacheNum);
            if (cacheIdx != -1) {
                list.remove(cacheIdx);
                list.add(0, cacheNum);
            }
            // 캐시 미스일 때
            else{
                list.add(0, cacheNum);
                if(list.size() > s)
                    list.remove(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append(num + " ");
        }
        System.out.println(sb);

        br.close();
    }
}
