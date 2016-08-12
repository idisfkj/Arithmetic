package com.idisfkj.arithmetic.design.factory;

/**
 * Created by idisfkj on 16/8/12.
 */
public class MultiFactory {
    public Sender createEmailFactory() {
        return new EmailSender();
    }

    public Sender createSmsFactory() {
        return new SmsSender();
    }
}
