/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private List<Integer> searchPath;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        searchPath = new ArrayList<>();
        // 1. p의 (왼, 중, 오) 노드 방문 결과 수집
        List<Integer> pLeftSearch = new ArrayList<>();
        
        searchLeft(p, 1);
        pLeftSearch = new ArrayList<>(searchPath);
        searchPath.clear();

        // 2. q의 (왼, 중, 오) 노드 방문 결과 수집
        List<Integer> qLeftSearch = new ArrayList<>();

        searchLeft(q, 1);
        qLeftSearch = new ArrayList<>(searchPath);
        searchPath.clear();

        // 3. p와 q의 (왼,중,오) 비교
        return isSame(pLeftSearch, qLeftSearch);
    }

    private void searchLeft(TreeNode node, int depth) {
        if(node == null) return;

        searchLeft(node.left, depth*2);
        searchPath.add(node.val + depth);
        searchLeft(node.right, depth*2+1);
    }

    private boolean isSame(List<Integer> n1, List<Integer> n2) {
        if(n1.size() != n2.size()) return false;

        for(int i = 0; i < n1.size(); i++) {
            int n1Node = n1.get(i);
            int n2Node = n2.get(i);
            if(n1Node != n2Node) return false;
        }

        return true;
    }
}