import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, 0));

        String[] comp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            stack.push(new Node(i + 1, Integer.parseInt(comp[i])));
        }

        int[] result = new int[n + 1];
        Stack<Node> tmp = new Stack<>();
        while(true) {
            Node cur = stack.pop();
            while(!tmp.isEmpty() && tmp.peek().num <= cur.num) {
                Node node = tmp.pop();
                result[node.idx] = cur.idx;
            }

            if(stack.isEmpty()) {
                tmp.push(cur);
                break;
            }

            Node prev = stack.peek();
            if(prev.num >= cur.num) result[cur.idx] = prev.idx;
            else tmp.push(cur);
        }

        while(!tmp.isEmpty()) {
            Node node = tmp.pop();
            result[node.idx] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static class Node {
        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

}