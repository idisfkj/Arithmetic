package com.idisfkj.arithmetic.LeetCode;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by idisfkj on 16/10/5.
 */
public class Child extends Parent {
    public int i = 0;
    public String str = "aa";
    @Override
    protected Stack<String> method() {
        System.out.println("Child -> " + i);
        return null;
    }

    public void ov() throws EmptyStackException{
        System.out.println("child -> ov");
    }


    public void ov(int j) {
        j++;
        System.out.println(j+" " +i);
        System.out.println(1+2+"c"+2+2);
    }


    private void ov(String i) {
        i = "bb";
        System.out.println(i + " " +str);
    }


    public void ov(short i) {
    }


    public static void main(String[] args) {
        Parent child = new Child();
        child.method();
        Child child1 = new Child();
        child1.ov(child.i);
        System.out.println(child.i);
        child.ov();
        child1.ov("cc");

    }
}
