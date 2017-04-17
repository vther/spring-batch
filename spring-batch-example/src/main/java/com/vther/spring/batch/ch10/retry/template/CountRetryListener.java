package com.vther.spring.batch.ch10.retry.template;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;


public class CountRetryListener implements RetryListener {


    @Override
    public <T> boolean open(RetryContext context, RetryCallback<T> callback) {
        System.out.println("CountRetryListener.open()");
        return true;
    }


    @Override
    public <T> void close(RetryContext context, RetryCallback<T> callback, Throwable throwable) {
        System.out.println("CountRetryListener.close()");
    }


    @Override
    public <T> void onError(RetryContext context, RetryCallback<T> callback, Throwable throwable) {
        CountHelper.increment();
        System.out.println("CountRetryListener.onError(),times=" + CountHelper.getCount());
    }

}
