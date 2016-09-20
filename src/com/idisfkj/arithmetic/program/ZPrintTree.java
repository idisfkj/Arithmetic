package com.idisfkj.arithmetic.program;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * Created by idisfkj on 16/9/20.
 */
public class ZPrintTree {
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static boolean isToLeft = false;
    public static ArrayList<Integer> leftList = new ArrayList<>();
    public static ArrayList<Integer> rightList = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> print(TreeDepth.TreeNode pRoot) {
        if (pRoot == null)
            return result;
        Stack<TreeDepth.TreeNode> stackLeft = new Stack<>();
        Stack<TreeDepth.TreeNode> stackRight = new Stack<>();
        stackLeft.push(pRoot);
        while (!stackLeft.isEmpty() || !stackRight.isEmpty()) {
            if (isToLeft) {//从左往右打印
                TreeDepth.TreeNode node = stackLeft.pop();
                leftList.add(node.val);
                if (node.left != null) {
                    stackRight.push(node.left);
                }
                if (node.right != null) {
                    stackRight.push(node.right);
                }
                if (stackLeft.isEmpty()) {
                    result.add(leftList);
                    leftList = new ArrayList<>();
                    isToLeft = false;
                }
            } else {//从右往左打印
                TreeDepth.TreeNode node = stackRight.pop();
                rightList.add(node.val);
                if (node.right != null) {
                    stackLeft.push(node.right);
                }
                if (node.left != null) {
                    stackLeft.push(node.left);
                }
                if (stackRight.isEmpty()) {
                    result.add(rightList);
                    rightList = new ArrayList<>();
                    isToLeft = true;
                }
            }
        }
        return result;
    }
}
