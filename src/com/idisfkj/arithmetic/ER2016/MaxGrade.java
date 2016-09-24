package com.idisfkj.arithmetic.ER2016;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by idisfkj on 16/9/23.
 */
public class MaxGrade {
    public static class Operation {
        private String operation;
        private int first;
        private int second;

        public Operation(String operation, int first, int second) {
            this.operation = operation;
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] grade = new int[n];
            for (int i = 0; i < n; i++) {
                grade[i] = in.nextInt();
            }
            ArrayList<Operation> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(new Operation(in.next(), in.nextInt(), in.nextInt()));
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int k = 0; k < m; k++) {
                Operation op = list.get(k);
                if (op.operation.equals("Q")) {
                    int max = 0;
                    int start = op.first;
                    int end = op.second;
                    if (op.second < op.first) {
                        start = op.second;
                        end = op.first;
                    }
                    for (int i = start - 1; i < end; i++) {
                        if (grade[i] > max)
                            max = grade[i];
                    }
                    result.add(max);
                } else {
                    grade[op.first - 1] = op.second;
                }
            }

            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
