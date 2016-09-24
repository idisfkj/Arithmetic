package com.idisfkj.arithmetic.program;

/**
 * Created by idisfkj on 16/9/22.
 */
public class MinimumDepth {
    public static class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.print(new MinimumDepth().run(root));
    }
    public int run(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left==null)
            return run(root.right)+1;
        if(root.right==null)
            return run(root.left)+1;
        return Math.min(run(root.left),run(root.right))+1;
    }
}
