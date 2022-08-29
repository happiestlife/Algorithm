import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Node[] tree;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tree = new Node[26];

        StringTokenizer stk;
        int p, lc, rc;
        while (n-- > 0) {
            stk = new StringTokenizer(br.readLine());

            p = stk.nextToken().charAt(0) - 'A';
            lc = stk.nextToken().charAt(0) - 'A';
            rc = stk.nextToken().charAt(0) - 'A';

            tree[p] = new Node(lc, rc);
        }

//        for (int i = 0; i < 26; i++) {
//            System.out.println('A' + i);
//            System.out.println((char)(root[i].left+'A') + "," + (char)(root[i].right+'A'));
//        }

        pre(0);
        bw.write("\n");
        in(0);
        bw.write("\n");
        post(0);
        bw.write("\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void pre(int ind) throws IOException {
        bw.write((char) (ind + 'A'));
        if(tree[ind].left >= 0)
            pre(tree[ind].left);
        if(tree[ind].right >= 0)
            pre(tree[ind].right);
    }

    public static void in(int ind) throws IOException {
        if(tree[ind].left >= 0)
            in(tree[ind].left);
        bw.write((char) (ind + 'A'));
        if(tree[ind].right >= 0)
            in(tree[ind].right);
    }

    public static void post(int ind) throws IOException {
        if(tree[ind].left >= 0)
            post(tree[ind].left);
        if(tree[ind].right >= 0)
            post(tree[ind].right);
        bw.write((char) (ind + 'A'));
    }
}


class Node{
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
