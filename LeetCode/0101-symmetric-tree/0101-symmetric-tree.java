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
import java.util.*;

class Solution {

    private List<Integer> result;

    public boolean isSymmetric(TreeNode root) {
        result = new ArrayList<>();

        search(root.left, 1, true);
        List<Integer> leftSearchPath = new ArrayList<>(result);
        result.clear();

        search(root.right, 1, false);
        List<Integer> rightSearchPath = new ArrayList<>(result);
        result.clear();

        return isSame(leftSearchPath, rightSearchPath);
    }

    private void search(TreeNode node, int depth, boolean isLeftSearch) {
        if(node == null) return;

        TreeNode firstSearchNode = isLeftSearch ? node.left : node.right;
        TreeNode secondSearchNode = isLeftSearch ? node.right : node.left;

        search(firstSearchNode, depth*2, isLeftSearch);
        result.add(node.val + depth);
        search(secondSearchNode, depth*2 + 1, isLeftSearch);
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