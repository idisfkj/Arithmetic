package com.idisfkj.arithmetic.program;

import java.util.Stack;

/**
 * 翻转单词顺序列
 * 例如，“student. a am I”把句子单词的顺序翻转为“I am a student.”。
 * Created by idisfkj on 16/9/12.
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String str = "a";
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        if (str.trim().equals(""))
            return str;
        String result = "";
        Stack<String> stack = new Stack<>();
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            stack.push(split[i]);
        }
        if (!stack.isEmpty())
            result += stack.pop();
        while (!stack.isEmpty())
            result += " " + stack.pop();
        return result;
    }
}
