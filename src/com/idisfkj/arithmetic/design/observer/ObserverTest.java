package com.idisfkj.arithmetic.design.observer;

/**
 * 当一个对象变化时，
 * 其它依赖该对象的对象都会收到通知，并且随着变化！对象之间是一种一对多的关系。
 * Created by idisfkj on 16/8/11.
 */
public class ObserverTest {
    public static void main(String[] args) {
        ISubject subject = new Subject();
        subject.add(new ObserverOne());
        subject.add(new ObserverTwo());
        subject.operation();
    }
}
