
package com.vther.spring.batch.ch05.step.listener;

import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

/**
 *
 * 2012-9-1上午08:11:52
 */
public class SystemOutItemWriteListener implements ItemWriteListener<String> {

	public void beforeWrite(List<? extends String> items) {
		System.out.println("ItemWriteListener.beforeWrite()");		
	}

	public void afterWrite(List<? extends String> items) {
		System.out.println("ItemWriteListener.afterWrite()");		
	}

	public void onWriteError(Exception exception, List<? extends String> items) {
		System.out.println("ItemWriteListener.onWriteError()");		
	}

}
