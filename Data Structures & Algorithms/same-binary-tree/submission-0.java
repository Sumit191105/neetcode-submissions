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

    /*static class TreeInfo{
        boolean isEqual;
        TreeInfo(boolean isEqual){
            this.isEqual = isEqual;
        }
    }*/

    private boolean bfs(TreeNode p , TreeNode q){
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        boolean left = bfs(p.left,q.left);
        boolean right = bfs(p.right,q.right);
        return left && right && p.val==q.val;
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return bfs(p,q);
    }
}
