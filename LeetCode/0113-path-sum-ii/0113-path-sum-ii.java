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

    private List<List<Integer>> result;     

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();

        search(root, targetSum, new ArrayList<>(), 0);

        return result;
    }

    private void search(TreeNode node, int targetSum, List<Integer> curNodeValues, int curSum) {
        if(node == null) return;
        curNodeValues.add(node.val);
        curSum += node.val;

        if(isLeafNode(node) && targetSum == curSum) {
            result.add(new ArrayList<>(curNodeValues));
        }

        search(node.left, targetSum, curNodeValues, curSum);
        search(node.right, targetSum, curNodeValues, curSum);

        curNodeValues.remove(curNodeValues.size()-1);
    }
    
    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}