package com.idisfkj.arithmetic.program;

/**
 * 平衡二叉树
 * Created by idisfkj on 16/9/9.
 */
public class IsBalanced_Solution {
    public static void main(String[] args) {

    }

    public static boolean solution(TreeDepth.TreeNode root) {
        if (root != null) {
            if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
                return false;
            } else {
                return solution(root.left) && solution(root.right);
            }
        } else {
            return true;
        }
    }

    public static int getDepth(TreeDepth.TreeNode root) {
        if (root != null) {
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            int result = (left > right ? left : right) + 1;
            return result;
        } else {
            return 0;
        }
    }
}
