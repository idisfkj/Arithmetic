package com.idisfkj.arithmetic.design.factory;

/**
 * Created by idisfkj on 16/8/12.
 */
public class EmailSender implements Sender {
    @Override
    public void send() {
        System.out.println("发送email!");
    }
}
