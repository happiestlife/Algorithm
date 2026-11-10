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
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();

        search(root);
        
        return result;
    }

    private void search(TreeNode node) {
        if(node == null) return;

        // 1. 왼쪽 노드 방문
        search(node.left);
        // 2. 자신의 노드 출력
        result.add(node.val);
        // 3. 우측 노드 방문
        search(node.right);
    }
}