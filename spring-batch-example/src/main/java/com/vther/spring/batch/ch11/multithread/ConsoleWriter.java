
package com.vther.spring.batch.ch11.multithread;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 *
 *
 * 2013-11-16下午10:58:20
 */
public class ConsoleWriter implements ItemWriter<String> {

	public void write(List<? extends String> items) throws Exception {
		System.out.print("Write begin:");
		for(String item : items){
			System.out.print(item + ",");
		}
		System.out.print("Write end!!");
		System.out.println("Job Write Thread name: " + Thread.currentThread().getName());
	}

}
