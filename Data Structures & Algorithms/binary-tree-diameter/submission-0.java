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

class TreeInfo{
    int height;
    int diameter;
    TreeInfo(int height,int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return solve(root).diameter;

    }
}

private  TreeInfo solve(TreeNode root){
    if(root==null) return new TreeInfo(0,0);
    TreeInfo left = solve(root.left);
    TreeInfo right = solve(root.right);
    int height = Math.max(left.height,right.height)+1;
    int diameterThroughRoot = left.height + right.height ;
    int diameter = Math.max(diameterThroughRoot,Math.max(right.diameter,left.diameter));
    TreeInfo info = new TreeInfo(height,diameter);
    return  info;
    
}
