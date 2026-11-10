import java.util.*;

class Node{
    int size;
    int cnt;

    public Node(int size, int cnt) {
        this.size = size;
        this.cnt = cnt;
    }
}

class Solution {
    public int numSquares(int n) {
        int[] minCnt = new int[n+1];
        Arrays.fill(minCnt, -1);

        List<Integer> squareSizes = new ArrayList<>();
        int s = 1;
        while(s*s <= n) {
            squareSizes.add(s*s);
            s++;
        }
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0));
        minCnt[0] = 0;
        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int curSize = curNode.size;
            int curCnt = curNode.cnt;

            for(int squareSize : squareSizes) {
                int addSize = curSize + squareSize;
                if(addSize > n) break;

                if(minCnt[addSize] == -1) {
                    q.add(new Node(addSize, curCnt+1));
                    minCnt[addSize] = curCnt+1;
                }
            }
        }

        return minCnt[n];
    }
}