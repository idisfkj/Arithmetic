package com.idisfkj.arithmetic.design.observer;

/**
 * Created by idisfkj on 16/8/11.
 */
public class Subject extends AbsrtractSubject {

    @Override
    public void operation() {
        notifyObservers();
    }
}
