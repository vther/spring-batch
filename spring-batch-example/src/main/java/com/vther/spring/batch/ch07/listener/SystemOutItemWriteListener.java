
package com.vther.spring.batch.ch07.listener;

import com.vther.spring.batch.ch07.CreditBill;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;


/**
 *
 *
 * 2013-9-29下午01:50:36
 */
public class SystemOutItemWriteListener implements ItemWriteListener<CreditBill> {
	public void beforeWrite(List<? extends CreditBill> items) {
		System.out.println("SystemOutItemWriteListener.beforeWrite()");
	}

	public void afterWrite(List<? extends CreditBill> items) {
		System.out.println("SystemOutItemWriteListener.afterWrite()");
	}

	public void onWriteError(Exception exception,
			List<? extends CreditBill> items) {
		System.out.println("SystemOutItemWriteListener.onWriteError()");
	}
}
