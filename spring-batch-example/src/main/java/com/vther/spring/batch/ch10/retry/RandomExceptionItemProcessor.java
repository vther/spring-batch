
package com.vther.spring.batch.ch10.retry;

import org.springframework.batch.item.ItemProcessor;

import java.util.Random;

/**
 *
 *
 * 2013-10-21下午10:12:01
 */
public class RandomExceptionItemProcessor implements ItemProcessor<String, String> {
	Random ra = new Random();
	
	public String process(String item) throws Exception {
		int i = ra.nextInt(10);
		System.out.println("Process " + item + "; Random i=" + i);
		if(i%2 == 0){
			throw new RuntimeException("make error!");
		}else{
			return item;
		}
	}
}
