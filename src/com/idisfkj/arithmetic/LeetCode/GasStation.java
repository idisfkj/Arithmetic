package com.idisfkj.arithmetic.LeetCode;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 * Created by idisfkj on 16/10/3.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[]{};
        int[] cost = new int[]{};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] >= 0) {
                if (max == 0)
                    index = i;
                max += gas[i] - cost[i];
            } else {
                if (Math.abs(gas[i] - cost[i]) <= max) {
                    max += gas[i] - cost[i];
                } else {
                    max = 0;
                    index = -1;
                }
            }
        }
        int result = -1;
        if (max >= 0 && index != -1) {
            result = max;
            for (int i = 0; i < index; i++) {
                result += gas[i] - cost[i];
            }
        }
        if (result >= 0)
            return index;
        else return -1;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = 0;
        int end = gas.length - 1;
        int sum = gas[end] - cost[end];
        while (start < end) {
            if (sum >= 0) {
                sum += gas[start] - cost[start];
                start++;
            } else {
                end--;
                if (start <= end)
                    sum += gas[end] - cost[end];
            }
        }
        if (sum >= 0)
            return end;
        else return -1;
    }

}
