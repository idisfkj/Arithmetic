package com.idisfkj.arithmetic.design.singleton;

/**
 * Created by idisfkj on 16/9/27.
 */
public class SSingleton {
    //私有的构造方法
    private SSingleton() {
    }

    //私有的静态对象
    private static class SSingletonHelp {
        private static SSingleton instance = new SSingleton();
    }

    //公有的静态方法提供获取该类的私有对象
    public static SSingleton getInstance() {
        return SSingletonHelp.instance;
    }
}
