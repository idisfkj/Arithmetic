package com.idisfkj.arithmetic.program;

/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回.
 * Created by idisfkj on 16/9/20.
 */
public class GetNext {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;//指向父节点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public static TreeLinkNode solution(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        //右子数不为空
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //不是根节点
        if (pNode.next != null) {
            //右子数
            while (pNode.next != null) {
                //为父节点的左子数
                if (pNode.next.left == pNode)
                    return pNode.next;
                pNode = pNode.next;
            }
        }
        return null;
    }
}
