package com.idisfkj.arithmetic.design.adapter;

/**
 * Created by idisfkj on 16/8/12.
 */
public class ObjAdapter implements Targeble {
    public Source source;

    public ObjAdapter(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("I am targeble method!");
    }
}
