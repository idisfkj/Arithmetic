package com.idisfkj.arithmetic.design.adapter;

/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容
 * 性问题。主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 * Created by idisfkj on 16/8/11.
 */
public class AdapterTest {
    public static void main(String[] args) {
        //类的适配器模式
//        Targeble adapter = new Adapter();
//        adapter.method1();
//        adapter.method2();
        //对象适配器
//        Source source = new Source();
//        Targeble objAdapter = new ObjAdapter(source);
//        objAdapter.method1();
//        objAdapter.method2();
        //接口适配器
        Targeble absAdapter = new AbsAdapter();
        absAdapter.method1();
        absAdapter.method2();
    }
}
