package com.idisfkj.arithmetic.program;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * Created by idisfkj on 16/9/20.
 */
public class SerializedAndDesserialized {
    public static void main(String[] args) {
    }

    public static String serialized(TreeDepth.TreeNode pRoot) {
        StringBuilder builder = new StringBuilder();
        serialized1(pRoot, builder);
        return builder.toString();
    }

    public static void serialized1(TreeDepth.TreeNode pRoot, StringBuilder builder) {
        if (pRoot == null) {
            builder.append("#,");
            return;
        }
        builder.append(pRoot.val);
        builder.append(",");
        serialized1(pRoot.left, builder);
        serialized1(pRoot.right, builder);
    }

    public static TreeDepth.TreeNode desserialized(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        return desserialized1(split);
    }

    static int index = -1;
    public static TreeDepth.TreeNode desserialized1(String[] split) {
        index++;
        if (!split[index].equals("#")) {
            TreeDepth.TreeNode node = new TreeDepth.TreeNode(Integer.parseInt(split[index]));
            node.left = desserialized1(split);
            node.right = desserialized1(split);
            return node;
        }
        return null;
    }
}
