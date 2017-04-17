package com.vther.spring.batch.ch10.skip;

import org.springframework.batch.item.ItemProcessor;

import java.util.Random;

/**
 * 2013-10-20下午10:06:48
 */
public class RandomExceptionItemProcessor implements ItemProcessor<String, String> {
    
    private Random ra = new Random();

    public String process(String item) throws Exception {
        int i = ra.nextInt(10);
        System.out.println("Process " + item + "; Random i=" + i);
        if (i % 2 == 0) {
            throw new RuntimeException("make error!");
        } else {
            return item;
        }
    }
}
