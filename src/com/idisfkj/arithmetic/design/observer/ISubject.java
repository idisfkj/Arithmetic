package com.idisfkj.arithmetic.design.observer;

/**
 * Created by idisfkj on 16/8/11.
 */
public interface ISubject {
    void add(IObserver observer);

    void remove(IObserver observer);

    void notifyObservers();

    void operation();

}
