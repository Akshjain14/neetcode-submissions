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
    public boolean isValidBST(TreeNode root) {
        return helper(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root,int minval, int maxval){
        if(root==null) return true;
        if(root.val<=minval || root.val>=maxval) return false;
        return helper(root.left,minval,root.val) && helper(root.right,root.val, maxval);

    }
}
