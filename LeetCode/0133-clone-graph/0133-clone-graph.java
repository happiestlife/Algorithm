/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    
    private Map<Node, Node> newAddrByPrevAddr = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node prevNode) {
        if(prevNode == null) return null;

        Node newCurNode = new Node(prevNode.val);
        newAddrByPrevAddr.put(prevNode, newCurNode);

        List<Node> newNeighbors = new ArrayList<>();
        for(Node prevNeighbor: prevNode.neighbors) {
            Node newNeighborAddr = newAddrByPrevAddr.get(prevNeighbor);
            if(newNeighborAddr == null) {
                Node newNeighbor = dfs(prevNeighbor);
                newNeighbors.add(newNeighbor);
            }
            else {
                newNeighbors.add(newNeighborAddr);
            }
        }
        newCurNode.neighbors = newNeighbors;

        return newCurNode;
    }
}