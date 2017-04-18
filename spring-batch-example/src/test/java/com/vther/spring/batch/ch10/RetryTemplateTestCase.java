package com.vther.spring.batch.ch10;

import com.vther.spring.batch.ch10.retry.template.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.classify.Classifier;
import org.springframework.classify.ClassifierSupport;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryListener;
import org.springframework.retry.RetryState;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.DefaultRetryState;
import org.springframework.retry.support.RetryTemplate;


public class RetryTemplateTestCase {
    @Before
    public void setUp() throws Exception {
        CountHelper.init();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSimpleRetry() {
        RetryCallback<String> retryCallback = new DefaultRetryCallback();
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(5);
        RetryListener[] listeners = new RetryListener[]{new CountRetryListener()};
        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(retryPolicy);
        template.setListeners(listeners);
        try {
            template.execute(retryCallback);
            Assert.assertFalse(true);
        } catch (Exception e) {
            Assert.assertTrue(true);//这行代码一直无法执行
            Assert.assertEquals(5, CountHelper.getCount());
        }
    }

    @Test
    public void testTimeoutRetry() {
        RetryCallback<String> retryCallback = new DefaultRetryCallback(500L);
        TimeoutRetryPolicy retryPolicy = new TimeoutRetryPolicy();
        retryPolicy.setTimeout(1100L);
        RetryListener[] listeners = new RetryListener[]{new CountRetryListener()};
        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(retryPolicy);
        template.setListeners(listeners);
        try {
            template.execute(retryCallback);
            Assert.assertFalse(true);//这行代码一直无法执行
        } catch (Exception e) {
            Assert.assertTrue(true);
            Assert.assertEquals(3, CountHelper.getCount());
        }
    }

    // BackOffPolicy 会在每次重试结束后执行backOff方法,经过测试发现最后一次重试失败不会执行
    //  ----- !! 原因是补偿策略只有在异常被抛出之前执行，最后一次重试导致了失败，所以补偿策略没有被触发
    @Test
    public void testBackOffPolicy() {
        RetryCallback<String> retryCallback = new DefaultRetryCallback();
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        RetryListener[] listeners = new RetryListener[]{new CountRetryListener()};
        BackOffPolicy backOffPolicy = new DefaultBackOffPolicy();
        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(retryPolicy);
        template.setListeners(listeners);
        template.setBackOffPolicy(backOffPolicy);
        try {
            template.execute(retryCallback);
            Assert.assertFalse(true);
        } catch (Exception e) {
            Assert.assertTrue(true);
            Assert.assertEquals(1, CountHelper.getCount());
        }
    }

    // RecoveryCallback 只会在所有重试结束后执行一次recover方法,通常用在有状态的重试中
    @Test
    public void testRecoveryCallback() {
        RetryCallback<String> retryCallback = new DefaultRetryCallback();
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        RetryListener[] listeners = new RetryListener[]{new CountRetryListener()};
        RecoveryCallback<String> recoveryCallback = new DefaultRecoveryCallback<>();
        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(retryPolicy);
        template.setListeners(listeners);
        try {
            template.execute(retryCallback, recoveryCallback);
            Assert.assertTrue(true);
            Assert.assertEquals(0, CountHelper.getCount());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testSimpleRetryPolicyStateful() {
        RetryCallback<String> retryCallback = new DefaultRetryCallback();
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        RetryListener[] listeners = new RetryListener[]{new CountRetryListener()};
        BackOffPolicy backOffPolicy = new DefaultBackOffPolicy();
        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(retryPolicy);
        template.setListeners(listeners);
        template.setBackOffPolicy(backOffPolicy);
        //FALSE 表示发生任何异常都不会RollBack，TRUE表示发生异常就会停止
        @SuppressWarnings("unchecked")
        Classifier<? super Throwable, Boolean> classifier = new ClassifierSupport(Boolean.FALSE);
        // TODO 查资料表示true会每次都刷新RetryContext，false表示沿用上次的，但是不明白什么含义
        RetryState retryState = new DefaultRetryState("key", false, classifier);
        try {
            template.execute(retryCallback, retryState);
            Assert.assertFalse(true);//这行代码一直无法执行
        } catch (Exception e) {
            Assert.assertTrue(true);
            Assert.assertEquals(1, CountHelper.getCount());
        }
    }
}
