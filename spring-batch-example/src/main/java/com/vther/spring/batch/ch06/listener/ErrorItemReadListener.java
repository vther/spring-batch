
package com.vther.spring.batch.ch06.listener;

import com.vther.spring.batch.ch06.CreditBill;
import org.springframework.batch.core.ItemReadListener;

/**
 *
 * 2013-9-16下午06:22:13
 */
public class ErrorItemReadListener implements ItemReadListener<CreditBill> {
	@SuppressWarnings("unused")
	public void beforeRead() {
		int i = 1/0;
		System.out.println("ErrorItemReadListener.beforeRead()");
	}

	public void afterRead(CreditBill item) {
		System.out.println("ErrorItemReadListener.afterRead()");
	}

	public void onReadError(Exception ex) {
		System.out.println("ErrorItemReadListener.onReadError()");
	}
}
