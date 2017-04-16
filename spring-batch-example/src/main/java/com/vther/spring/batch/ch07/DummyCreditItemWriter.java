
package com.vther.spring.batch.ch07;

import org.springframework.batch.item.ItemWriter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * 2013-9-29下午02:27:58
 */
public class DummyCreditItemWriter implements ItemWriter<CreditBill> {

	public List<CreditBill> creditBills = new ArrayList<>();

	public void write(List<? extends CreditBill> items) throws Exception {
		creditBills.addAll(items);
	}

	public List<CreditBill> getCredits() {
		return creditBills;
	}
}
