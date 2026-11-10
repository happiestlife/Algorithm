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

class LevelNode {
    TreeNode node;
    int level;

    public LevelNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();


        Queue<LevelNode> q = new LinkedList<>();
        if(root != null) q.add(new LevelNode(root, 1));
        while(!q.isEmpty()) {
            LevelNode curLevelNode = q.poll();
            TreeNode curNode = curLevelNode.node;
            int curLevel = curLevelNode.level;
            
            if(result.size() < curLevel) {
                result.add(new ArrayList<>());
            }
            result.get(curLevel-1).add(curNode.val);

            if(curNode.left != null) q.add(new LevelNode(curNode.left, curLevel+1));
            if(curNode.right != null) q.add(new LevelNode(curNode.right, curLevel+1));
        }
        return result; 
    }
}