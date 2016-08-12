package com.idisfkj.arithmetic.design.singleton;

/**
 * 饿汉式
 * Created by idisfkj on 16/8/12.
 */
public class ESingleton {
    //直接创建对象
    private static ESingleton instance = new ESingleton();

    //私有的构造方法
    private ESingleton() {
    }

    //返回对象实例
    public static ESingleton getInstance() {
        return instance;
    }
}
