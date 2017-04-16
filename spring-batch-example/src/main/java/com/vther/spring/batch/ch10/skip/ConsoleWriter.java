
package com.vther.spring.batch.ch10.skip;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 *
 *
 * 2013-10-20下午10:06:38
 */
public class ConsoleWriter implements ItemWriter<String> {

	public void write(List<? extends String> items) throws Exception {
		System.out.println("Write begin:");
		for(String item : items){
			System.out.print(item + ",");
		}
		System.out.println("Write end!!");
	}

}
