
package com.vther.spring.batch.ch06.listener;

import com.vther.spring.batch.ch06.CreditBill;
import org.springframework.batch.core.ItemReadListener;

/**
 *
 * 2013-9-16下午05:47:05
 */
public class SystemOutItemReadlistener implements ItemReadListener<CreditBill> {
	public void beforeRead() {
		System.out.println("SystemOutItemReadlistener.beforeRead()");
	}

	public void afterRead(CreditBill item) {
		System.out.println("SystemOutItemReadlistener.afterRead()");
	}

	public void onReadError(Exception ex) {
		System.out.println("SystemOutItemReadlistener.onReadError()");
	}
}
