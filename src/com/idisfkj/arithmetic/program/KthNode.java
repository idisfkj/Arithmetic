package com.idisfkj.arithmetic.program;

/**
 * 二叉搜索树的第k个结点
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * Created by idisfkj on 16/9/21.
 */
public class KthNode {
    private TreeDepth.TreeNode temp = null;
    private int num;
    public TreeDepth.TreeNode solution(TreeDepth.TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        num = k;
        searchNode(pRoot);
        return temp;
    }


    public void searchNode(TreeDepth.TreeNode node) {
        if (node == null)
            return;
        if (num < 0)
            return;
        searchNode(node.left);
        num--;
        if (num == 0) {
            temp = node;
            return;
        }
        searchNode(node.right);

    }
}
