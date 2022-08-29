import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static long arr[];
    static long indexTree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        arr = new long[n+1];

        int s = 1;
        while (s < n) {
            s *= 2;
        }
        indexTree = new long[2 * s];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, s, 1);

        int cmd = m + k;
        int a, b;
        long c;
        while (cmd-- > 0) {
            stk = new StringTokenizer(br.readLine());

            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            c = Long.parseLong(stk.nextToken());

            if (a == 1) {
                long diff = c - indexTree[s + b - 1];
                update(1, s, b, diff, 1);
            } else {
                bw.write(find(1, s, b, (int) c, 1) + "\n");
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }

    static long init(int start, int end, int ind) {
        if (start == end) {
            if(start <= n)
                return indexTree[ind] = arr[start];
            else
                return indexTree[ind] = 0;
        }

        int mid = (start + end) / 2;
        return indexTree[ind] = init(start, mid, ind * 2)
                + init(mid + 1, end, ind * 2 + 1);
    }

    public static long find(int s, int e, int fs, int fe, int ind) {
        if(fs <= s && e <= fe)
            return indexTree[ind];
        else if(s > fe || e < fs)
            return 0;
        else{
            int mid = (s + e) / 2;
            return find(s, mid, fs, fe, ind * 2) + find(mid + 1, e, fs, fe, ind * 2 + 1);
        }
    }

    public static void update(int s, int e, int target, long diff, int ind) {
        if(s == e && s == target) {
            indexTree[ind] += diff;
            return;
        }

        if (s <= target && target <= e) {
            indexTree[ind] += diff;

            int mid = (s + e) / 2;
            update(s, mid, target, diff, ind * 2);
            update(mid+1, e, target, diff, ind * 2 + 1);
        }
    }

}
