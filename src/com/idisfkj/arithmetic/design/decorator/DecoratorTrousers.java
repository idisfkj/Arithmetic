package com.idisfkj.arithmetic.design.decorator;

/**
 * Created by idisfkj on 16/8/11.
 */
public class DecoratorTrousers implements Sourceable{
    public Sourceable source;

    public DecoratorTrousers(Sourceable source) {
        this.source = source;
    }

    @Override
    public void method() {
        source.method();
        System.out.println("DecoratorTrousers before!");
        System.out.println("I wear trousers!");
        System.out.println("DecoratorTrousers after!");
    }
}
