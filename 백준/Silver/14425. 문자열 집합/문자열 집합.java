import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 트라이
    // 핵심 포인트(배워가는 점) : pianoman, piano 와 같이 특정 문자열 속 문자열이
    // 있을 수 있기 때문에 각 문자열의 끝 문자에서 finish 되었다는 프로퍼티를 넣어줘야 한다. 
    private static class Node{
        int ind;
        boolean isFinished;
        Node node[];

        public Node(int ind) {
            this.ind = ind;
            node = new Node[26];
            this.isFinished = false;
        }
    }

    static int n, m;
    static Node trie;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        trie = new Node(-1);

        String str;
        while (n-- > 0) {
            str = br.readLine();
            makeTrie(trie, str, 0);
        }

        while (m-- > 0) {
            str = br.readLine();
            Node startNode = trie.node[str.charAt(0) - 'a'];
            if(startNode != null){
                check(startNode, str, 1);
            }
        }

        System.out.println(count);

        bw.flush();
        br.close();
        bw.close();
    }

    static void makeTrie(Node trie, String str, int ind) {
        int cInd = str.charAt(ind++) - 'a';
        if (trie.node[cInd] == null) {
            trie.node[cInd] = new Node(cInd);
        }

        if (ind == str.length()) {
            trie.node[cInd].isFinished = true;
            return;
        }

        makeTrie(trie.node[cInd], str, ind);
    }

    static void check(Node trie, String str, int ind) {
        if(ind == str.length()) {
            if(trie.isFinished)
                count++;

            return;
        }

        int cInd = str.charAt(ind) - 'a';
        if(trie.node[cInd] != null)
            check(trie.node[cInd], str, ind+1);
    }
}
