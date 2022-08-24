import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        /**
         * 해당 후보가 최초 호출 시
         * 해당 후보가 사진틀에 있을 경우
         * 해당 후보가 사진틀에 없음
         * 사진틀이 가득 찬 경우
            * 정렬, 지울 후보 선정, 제거
         * 사진틀에 여유가 있는 경우
         */
        No[] nominees = new No[101];

        ArrayList<No> list = new ArrayList<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            int num = Integer.parseInt(stk.nextToken());

            if (nominees[num] == null) {
                nominees[num] = new No(num, 0, 0, false);
            }

            // 해당 후보가 사진 틀에 있을 경우
            if(nominees[num].isIn){
                nominees[num].count++;
            }else {
                // 헤딩 후보가 사진 틀에 없음
                // 사진들이 가득 찬 경우
                if (list.size() == N) {
                    // 정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    No nominee = list.remove(0);
                    nominee.isIn = false;
                }
                // 사진틀에 여유가 있는 경우
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].time = k;
                list.add(nominees[num]);
            }
        }

        Collections.sort(list, new Comparator<No>() {
            @Override
            public int compare(No o1, No o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });

        for (No no : list) {
            System.out.print(no.num + " ");
        }
    }
}

class No implements Comparable<No>{
    int num;
    int count;
    int time;
    boolean isIn;

    public No(int num, int count, int time, boolean isIn) {
        this.num = num;
        this.count = count;
        this.time = time;
        this.isIn = isIn;
    }

    // 1. 추천수 2. 시간
    @Override
    public int compareTo(No o) {
        int comp = Integer.compare(count, o.count);
        if (comp == 0) {
            return Integer.compare(time, o.time);
        }else
            return comp;
    }
}