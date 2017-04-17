package com.vther.spring.batch.ch10.retry.template;

import org.junit.Assert;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryContext;


public class DefaultRecoveryCallback<T> implements RecoveryCallback<T> {

    @Override
    public T recover(RetryContext context) throws Exception {
        Assert.assertNotNull(context.getAttribute("count"));
        CountHelper.decrement();
        System.out.println("RecoveryCallback.recover(),times=" + CountHelper.getCount());
        return null;
    }

}
