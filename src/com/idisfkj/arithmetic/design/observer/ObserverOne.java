package com.idisfkj.arithmetic.design.observer;

/**
 * Created by idisfkj on 16/8/11.
 */
public class ObserverOne implements IObserver{
    @Override
    public void update() {
        System.out.println("One to update!");
    }
}
