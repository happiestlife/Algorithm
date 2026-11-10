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
    public void flatten(TreeNode root) {
        search(root);
    }

    private TreeNode search(TreeNode node) {
        if(node == null) return null;
        else if(isLeafNode(node)) {
            return node;
        }

        // 왼쪽 노드가 있다면 
        // 0. 왼쪽 노드 방문
        // 1. 왼쪽 노드의 LeafNode.right는 현재 노드의 right 노드를 가리킴
        // 2. 현재 노드의 right 왼쪽 노드의 LeafNode를 가리킴
        // 3. 현재 노드의 left는 null
        TreeNode leftLeafNode = search(node.left);
        if(leftLeafNode != null) {
            leftLeafNode.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // 오른쪽 노드 방문
        return search(node.right);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}