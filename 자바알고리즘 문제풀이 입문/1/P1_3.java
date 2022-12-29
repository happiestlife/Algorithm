import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1_3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        // [0] : 단어 위치, [1] : 단어의 길이
        PriorityQueue<int[]> mh = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        String[] strList = str.split(" ");
        for (int i = 0; i < strList.length; i++) {
            mh.add(new int[]{i, strList[i].length()});
        }
        System.out.println(strList[mh.peek()[0]]);

        br.close();
    }
}