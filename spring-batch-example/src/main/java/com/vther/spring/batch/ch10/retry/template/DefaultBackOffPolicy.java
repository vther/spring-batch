package com.vther.spring.batch.ch10.retry.template;

import org.junit.Assert;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.BackOffContext;
import org.springframework.retry.backoff.BackOffInterruptedException;
import org.springframework.retry.backoff.BackOffPolicy;

/**
 * 2013-10-21下午10:59:56
 */
public class DefaultBackOffPolicy implements BackOffPolicy {

    @Override
    public BackOffContext start(RetryContext context) {
        System.out.println("DefaultBackOffPolicy.start()");
        return new BackOffContextImpl(context);
    }


    @Override
    public void backOff(BackOffContext backOffContext) throws BackOffInterruptedException {
        Assert.assertNotNull(((BackOffContextImpl) backOffContext).getRetryContext().getAttribute("count"));
        CountHelper.decrement();
        System.out.println("DefaultBackOffPolicy.backOff(),times=" + CountHelper.getCount());
    }

}
