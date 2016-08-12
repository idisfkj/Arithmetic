package com.idisfkj.arithmetic.design.singleton;

/**
 * 懒汉式
 * Created by idisfkj on 16/8/12.
 */
public class LSingleton {
    //私有的静态类对象
    private static volatile LSingleton instance;

    //私有的构造方法
    private LSingleton() {
    }

    public static LSingleton getInstance() {
        if (instance == null) {
            synchronized (LSingleton.class) {
                if (instance == null) {
                    instance = new LSingleton();
                }
            }
        }
        return instance;
    }
}
