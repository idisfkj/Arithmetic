package com.idisfkj.arithmetic.program;

/**
 * 二叉树深度
 * Created by idisfkj on 16/9/8.
 */
public class TreeDepth {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int result = 0;
    public int temp = 0;
    public static void main(String[] args){
        TreeDepth depth = new TreeDepth();
        TreeNode pRoot = new TreeNode(1);
        pRoot.left = new TreeNode(2);
        pRoot.right = new TreeNode(3);
        pRoot.left.right = new TreeNode(4);
        System.out.println(depth.solution(pRoot));
    }

    public int solution(TreeNode pRoot){
        if (pRoot!=null){
            temp++;
            solution(pRoot.left);
            solution(pRoot.right);
            temp--;
        }
        if (temp>result){
            result = temp;
        }
        return result;
    }
}
