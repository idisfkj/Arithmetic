package com.idisfkj.arithmetic.LeetCode;

import java.util.Vector;

/**
 * Created by idisfkj on 16/10/5.
 */
public class Parent {
    public int i = 1;

    protected Vector<String> method(){
        System.out.println("Parent -> " + i);
        return null;
    }

    public void ov() throws RuntimeException{
        System.out.println("Parent -> ov");
    }

}
