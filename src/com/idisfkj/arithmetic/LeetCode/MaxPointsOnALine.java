package com.idisfkj.arithmetic.LeetCode;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * Created by idisfkj on 16/9/26.
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        //(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)
        Point[] points = new Point[]{new Point(84, 250), new Point(0, 0), new Point(1, 0)
                , new Point(0, -70), new Point(0, -70), new Point(1, -1), new Point(21, 10)
                , new Point(42, 90), new Point(-42, -230)};
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int count = 0;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    //相同的点
                    for (int k = 0; k < points.length; k++) {
                        if (points[i].x == points[k].x && points[i].y == points[k].y) {
                            count++;
                        }
                    }
                } else if (points[i].y - points[j].y == 0) {
                    //与x轴对齐
                    for (int k = 0; k < points.length; k++) {
                        if (points[k].y == points[i].y)
                            count++;
                    }
                } else if (points[i].x - points[j].x == 0) {
                    //与y轴对齐
                    for (int k = 0; k < points.length; k++) {
                        if (points[k].x == points[i].x)
                            count++;
                    }
                } else {
                    //结果类型为double型
                    double temp = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
                    count++;
                    for (int k = 0; k < points.length; k++) {
                        if (points[k].x - points[i].x == 0 || points[k].y - points[i].y == 0) {
                            //与判断依据相同的点
                            if (i != k && (points[i].x == points[k].x && points[i].y == points[k].y)) {
                                count++;
                            }
                            continue;
                        } else if ((double) (points[i].y - points[k].y) / (points[i].x - points[k].x) == temp) {
                            count++;
                        }
                    }
                }
                if (count > max)
                    max = count;
            }
        }
        return max;
    }
}
