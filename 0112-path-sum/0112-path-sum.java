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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return search(root, targetSum, 0);
    }

    private boolean search(TreeNode node, int targetSum, int curSum) {
        // 트리 노드라면 현재 노드까지의 현재까지의 합이 타겟과 동일한지 판단
        if(node.left == null && node.right == null) {
            return targetSum == curSum + node.val;
        }

        // 왼쪽 노드가 있다면 방문
        if(node.left != null) {
            boolean leftSearchResult = search(node.left, targetSum, curSum + node.val);
            if(leftSearchResult) return true;
        }

        // 오른쪽 노드가 있다면 방문
        if(node.right != null) {
            boolean rightSearchResult = search(node.right, targetSum, curSum + node.val);
            if(rightSearchResult) return true;
        }

        return false;
    }
}