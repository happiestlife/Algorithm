package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class P5_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        // 한명씩 제거해나갈 것이기 때문에 LinkedList 선언
        List<Integer> princes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            princes.add(i + 1);
        }

        int num = 1, idx = 0;
        while (princes.size() > 1) {
            // 자신의 숫자 외치기

            // 만약 그 숫자가 k라면 현재 왕자 제거
            // 제거되면 자동으로 인덱스가 한단계씩 당겨지기 때문에 인덱스를 증가시키지 않는다.
            if(num == k){
                princes.remove(idx);
                num = 0;
            }
            else{
                idx = (++idx) % princes.size();
            }
            num++;
        }

        System.out.println(princes.get(0));

        br.close();
    }
}
