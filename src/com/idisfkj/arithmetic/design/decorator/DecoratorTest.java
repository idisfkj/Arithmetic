package com.idisfkj.arithmetic.design.decorator;

/**
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个
 * 接口，装饰对象持有被装饰对象的实例。
 * Created by idisfkj on 16/8/11.
 */
public class DecoratorTest {
    public static void main(String[] args){
        Source source = new Source();
        Sourceable clothes=  new DecoratorClothes(source);
        Sourceable trousers = new DecoratorTrousers(clothes);
        trousers.method();
    }
}
