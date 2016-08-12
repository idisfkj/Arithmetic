package com.idisfkj.arithmetic.design.factory;

/**
 * Created by idisfkj on 16/8/12.
 */
public class SimpleFactory {
    public Sender createFactory(String type) {
        if ("email".equals(type)) {
            return new EmailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            return null;
        }
    }
}
