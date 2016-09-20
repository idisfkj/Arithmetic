package com.idisfkj.arithmetic.program;

/**
 * 对称的二叉树
 * 如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * Created by idisfkj on 16/9/20.
 */
public class isSymmetrical {
    public static void main(String[] args) {
        TreeDepth.TreeNode node = new TreeDepth.TreeNode(8);
        node.left = new TreeDepth.TreeNode(6);
        node.right = new TreeDepth.TreeNode(9);
        node.left.left = new TreeDepth.TreeNode(5);
        node.left.right = new TreeDepth.TreeNode(7);
        node.right.left = new TreeDepth.TreeNode(7);
        node.right.right = new TreeDepth.TreeNode(5);
        System.out.print(solution(node));
    }

    public static boolean solution(TreeDepth.TreeNode pRoot) {
        if (pRoot == null)
            return true;
        TreeDepth.TreeNode temp = pRoot;
        return isSame(pRoot, createMirrorTree(temp));
    }

    public static boolean isSame(TreeDepth.TreeNode p1, TreeDepth.TreeNode p2) {
        if (p1 == null && p2 != null)
            return false;
        if (p1 != null && p2 == null)
            return false;
        if (p1 == null && p2 == null)
            return true;
        if (p1.val != p2.val)
            return false;
        return isSame(p1.left, p2.left) && isSame(p1.right, p2.right);
    }

    public static TreeDepth.TreeNode createMirrorTree(TreeDepth.TreeNode pRoot) {
        if (pRoot == null)
            return null;
        TreeDepth.TreeNode temp = new TreeDepth.TreeNode(pRoot.val);
        temp.left = createMirrorTree(pRoot.right);
        temp.right = createMirrorTree(pRoot.left);
        return temp;
    }
}
