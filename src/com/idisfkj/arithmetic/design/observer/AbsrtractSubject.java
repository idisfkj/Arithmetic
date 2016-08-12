package com.idisfkj.arithmetic.design.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by idisfkj on 16/8/11.
 */
public abstract class AbsrtractSubject implements ISubject{
    public Vector<IObserver> vector = new Vector<>();

    @Override
    public void add(IObserver observer) {
        vector.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<IObserver> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            IObserver observer = enumeration.nextElement();
            observer.update();
        }
    }
}
