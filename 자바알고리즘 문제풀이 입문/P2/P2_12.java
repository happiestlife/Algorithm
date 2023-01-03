package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        ArrayList<int[]>[] grd = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            grd[i] = new ArrayList<int[]>();
            for (int j = 0; j < n; j++) {
                // [0] : 학생 인덱스, [1] : 학생 등수
                grd[i].add(new int[]{Integer.parseInt(stk.nextToken()) - 1, j});
            }
        }

        // 1. 첫번째를 제외한 나머지 시험의 결과를 학생읜 인덱스 오름차순으로 정렬
        for (int i = 1; i < m; i++) {
            Collections.sort(grd[i], Comparator.comparingInt((int[] o) -> o[0]));
        }

        // 2. 정렬된 첫번째 시험의 결과를 가지고 형성될 수 있는 모든 멘토-멘티 관계에 대해서 나머지 시험에서 테스트
        // 2-1. 모든 테스트에서 성공 시 count++
        int count = 0;
        for (int i = 0; i < grd[0].size(); i++) {
            for (int j = i + 1; j < grd[0].size(); j++) {
                // 멘토-멘티 관계 경우의 수 추출
                int mentor = grd[0].get(i)[0];
                int mentee = grd[0].get(j)[0];

                // 나머지 시험에서 테스트
                boolean isFail = false;
                for (int k = 1; k < m; k++) {
                    if(grd[k].get(mentor)[1] >= grd[k].get(mentee)[1]){
                        isFail = true;
                        break;
                    }
                }


                if(!isFail) {
                    count++;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}