import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /**
     * 인덱스 트리로 해결
     */

    static int k, n;
    static long nums[];
    static long indexTree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        nums = new long[k+1];

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= k; i++) {
            nums[i] = Long.parseLong(stk.nextToken());
        }


        // 인덱스 트리의 크기 찾기기
        int s = 1;
        while(s < k){
            s *= 2;
        }
        indexTree = new long[s * 2];

        init(1, s, 1);

//        for (long l : indexTree) {
//            System.out.print(l + " ");
//        }
//        System.out.println();

        int x, y, a;
        long b;
        while (n-- > 0) {
            stk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            a = Integer.parseInt(stk.nextToken());
            b = Long.parseLong(stk.nextToken());

            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            bw.write(query(1, s, x, y, 1) + "\n");

            long diff = b - indexTree[s + a - 1];
            update(1, s, a, diff, 1);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static long init(int s, int e, int ind) {
        if (s == e) {
            if(s <= k)
                return indexTree[ind] = nums[s];
            else
                return indexTree[ind];
        }

        int mid = (s + e) / 2;

        long left = init(s, mid, ind * 2);
        long right = init(mid + 1, e, ind * 2 + 1);

        return indexTree[ind] = left + right;
    }

    public static long query(int s, int e, int x, int y, int ind){
        if(x <= s && e <= y){
            return indexTree[ind];
        } else if (y < s || e < x) {
            return 0;
        } else {
            int mid = (s + e) / 2;
            long left = query(s, mid, x, y, ind * 2);
            long right = query(mid + 1, e, x, y, ind * 2 + 1);

            return left + right;
        }
    }

    public static void update(int s, int e, int target, long diff, int ind) {
        if(target < s || e < target)
            return;

        indexTree[ind] += diff;

        // 리프 노드이면 반환
        if(s == e)
            return;

        int mid = (s + e) / 2;
        update(s, mid, target, diff, ind * 2);
        update(mid + 1, e, target, diff, ind * 2 + 1);
    }
}
