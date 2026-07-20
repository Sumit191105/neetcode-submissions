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

    static class TreeInfo{
        boolean isBalanced;
        int height;
        TreeInfo(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private TreeInfo dfs(TreeNode root){
        if(root==null ) return new TreeInfo(true,0);
        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);
        boolean isBalance = left.isBalanced && right.isBalanced && Math.abs(right.height-left.height)<=1;
        int height = Math.max(left.height,right.height)+1;
        return new TreeInfo(isBalance,height);
    }


    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }

    

    
}
