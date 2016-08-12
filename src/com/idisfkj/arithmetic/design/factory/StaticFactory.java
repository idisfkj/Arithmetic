package com.idisfkj.arithmetic.design.factory;

/**
 * Created by idisfkj on 16/8/12.
 */
public class StaticFactory {

    public static Sender createEmailFactory() {
        return new EmailSender();
    }

    public static Sender createSmsFactory() {
        return new SmsSender();
    }
}
