
package com.vther.spring.batch.ch07.db;

import org.springframework.batch.item.ItemProcessor;

/**
 *
 *
 * 2013-9-19下午01:15:37
 */
public class CreditBillProcessor implements
		ItemProcessor<CreditBill, DestinationCreditBill> {

	public DestinationCreditBill process(CreditBill bill) throws Exception {
		System.out.println(bill.toString());
		DestinationCreditBill destCreditBill = new DestinationCreditBill();
		destCreditBill.setAccountID(bill.getAccountID());
		destCreditBill.setAddress(bill.getAddress());
		destCreditBill.setAmount(bill.getAmount());
		destCreditBill.setDate(bill.getDate());
		destCreditBill.setId(bill.getId());
		destCreditBill.setName(bill.getName());
		return destCreditBill;
	}
}
