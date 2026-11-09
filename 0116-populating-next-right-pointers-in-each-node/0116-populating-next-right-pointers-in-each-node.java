/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
import java.util.*;

class LevelNode {
    Node node;
    int level;

    public LevelNode(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public Node connect(Node root) {
        List<Node> nodesByLevel = new ArrayList<>();
    
        int maxLevel = 0;
        Queue<LevelNode> q = new LinkedList<>();
        if(root != null) {
            q.add(new LevelNode(root, 1));
        }
        while(!q.isEmpty()) {
            LevelNode curNode = q.poll();
            nodesByLevel.add(curNode.node);
            maxLevel = Math.max(maxLevel, curNode.level);

            if(curNode.node.left != null) q.add(new LevelNode(curNode.node.left, curNode.level+1));
            if(curNode.node.right != null) q.add(new LevelNode(curNode.node.right, curNode.level+1));
        }

        for(int i = 0; i < maxLevel; i++) {
            int startIdx = (int)Math.pow(2, i)-1;
            int endIdx = (int)Math.pow(2, i+1)-2;
            for(int j = startIdx; j < endIdx; j++) {
                Node curNode = nodesByLevel.get(j);
                curNode.next = nodesByLevel.get(j+1);
            }
        }

        return root;
    }
}