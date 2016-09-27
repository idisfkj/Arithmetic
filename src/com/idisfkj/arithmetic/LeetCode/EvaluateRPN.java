package com.idisfkj.arithmetic.LeetCode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * Created by idisfkj on 16/9/26.
 */
public class EvaluateRPN {

    public static void main(String[] args) {
        String[] tokens = new String[]{"0","3","/"};
        System.out.println(new EvaluateRPN().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
