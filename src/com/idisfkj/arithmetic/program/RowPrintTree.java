package com.idisfkj.arithmetic.program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * Created by idisfkj on 16/9/20.
 */
public class RowPrintTree {

    public static ArrayList<ArrayList<Integer>> print(TreeDepth.TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeDepth.TreeNode> queue1 = new LinkedList<>();
        Queue<TreeDepth.TreeNode> queue2 = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue1.offer(pRoot);
        boolean flag = true;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (flag) {//层次分割
                TreeDepth.TreeNode node = queue1.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
                if (queue1.isEmpty()) {
                    result.add(list);
                    list = new ArrayList<>();
                    flag = false;
                }
            } else {//层次分割
                TreeDepth.TreeNode node = queue2.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue1.offer(node.left);
                }
                if (node.right != null) {
                    queue1.offer(node.right);
                }
                if (queue2.isEmpty()) {
                    result.add(list);
                    list = new ArrayList<>();
                    flag = true;
                }
            }
        }
        return result;
    }
}
