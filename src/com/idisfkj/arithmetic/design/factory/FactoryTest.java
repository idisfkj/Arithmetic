package com.idisfkj.arithmetic.design.factory;

/**
 * Created by idisfkj on 16/8/12.
 */
public class FactoryTest {
    public static void main(String[] args) {
        //简单工厂
//        SimpleFactory factory = new SimpleFactory();
//        Sender sender = factory.createFactory("email");
//        sender.send();
        //多工厂
//        MultiFactory factory = new MultiFactory();
//        Sender sender = factory.createEmailFactory();
//        sender.send();
        //静态工厂
        Sender sender = StaticFactory.createEmailFactory();
        sender.send();
    }
}
