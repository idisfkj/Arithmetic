package com.idisfkj.arithmetic.design.adapter;


/**
 * 类的适配器模式
 * Created by idisfkj on 16/8/11.
 */
public class Adapter extends Source implements Targeble {
    @Override
    public void method2() {
        System.out.println("I am targeble method!");
    }

}
