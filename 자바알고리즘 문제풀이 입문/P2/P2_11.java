import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2_11 {

    static final int GRADE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 각 학생마다 같은 반이었던 적이 있었던 친구들
        Set<Integer>[] stuWithSameClass= new HashSet[n];
        // key : 반, value : 같은 반에 속한 학생들의 인덱스가 담긴 list
        Map<Integer, List<Integer>>[] grd = new Map[GRADE];
        for (int i = 0; i < n; i++) {
            stuWithSameClass[i] = new HashSet<>();
        }
        for (int i = 0; i < GRADE; i++) {
            grd[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < GRADE; j++) {
                int clz = Integer.parseInt(stk.nextToken());
                if (grd[j].get(clz) == null) {
                    grd[j].put(clz, new ArrayList<>());
                }

                // j학년의 clz반에 i번째 학생이 속해있다.
                grd[j].get(clz).add(i);
            }
        }

        // 각 학년마다 조사
        for (int i = 0; i < grd.length; i++) {
            // 모든 반에 대해서 조사한다.
            for (Integer clz : grd[i].keySet()) {

                // 같은 반인 학생들이 2명이상이면
                List<Integer> stuWithSameClz = grd[i].get(clz);
                if(stuWithSameClz.size() >= 2){

                    // 해당 학생들은 같은 반이었던 것으로 만들어주기 -> 모든 경우의 수에 set에 추가해주기
                    for (int j = 0; j < stuWithSameClz.size(); j++) {
                        for (int k = j + 1; k < stuWithSameClz.size(); k++) {
                            int stu1 = stuWithSameClz.get(j);
                            int stu2 = stuWithSameClz.get(k);

                            stuWithSameClass[stu1].add(stu2);
                            stuWithSameClass[stu2].add(stu1);
                        }
                    }
                }
            }
        }

        // 각 학생들은 조사해서 가장 많은 친구들과 같은 반이 되었던 친구 찾기
        int max = 0;
        int stuInd = 0;
        for (int i = 0; i < stuWithSameClass.length; i++) {
            if (stuWithSameClass[i].size() > max) {
                max = stuWithSameClass[i].size();
                stuInd = i;
            }
        }

        System.out.println(stuInd + 1);

        br.close();
    }
}