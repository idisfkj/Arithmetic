package com.idisfkj.arithmetic.design.decorator;

/**
 * Created by idisfkj on 16/8/11.
 */
public class DecoratorClothes implements Sourceable{
    public Sourceable source;

    public DecoratorClothes(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        source.method();
        System.out.println("DecoratorClothes before!");
        System.out.println("I'm wearing clothes!");
        System.out.println("DecoratorClothes after!");
    }
}
