package com.idisfkj.arithmetic.design.startegy;

/**
 * Created by idisfkj on 16/8/11.
 */
public abstract class Calculator {
    public int[] split(String exp, String opt) {
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}
