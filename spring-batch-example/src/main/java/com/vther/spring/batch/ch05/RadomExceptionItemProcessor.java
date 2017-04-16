
package com.vther.spring.batch.ch05;

import org.springframework.batch.item.ItemProcessor;

import java.util.Random;

/**
 *
 *         2013-3-22下午04:50:05
 */
public class RadomExceptionItemProcessor implements ItemProcessor<String, String> {
    private Random random = new Random();

    public String process(String item) throws Exception {
        int i = random.nextInt(10);
        System.out.println("Process " + item + "; Random i=" + i);
        if (i % 2 == 0) {
            throw new RuntimeException("make error!");
        } else {
            return item;
        }
    }
}
