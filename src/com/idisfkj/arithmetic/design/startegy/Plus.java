package com.idisfkj.arithmetic.design.startegy;

/**
 * Created by idisfkj on 16/8/11.
 */
public class Plus extends Calculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}
