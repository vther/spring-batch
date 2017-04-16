
package com.vther.spring.batch.ch07.reuse;

import com.vther.spring.batch.ch07.CreditBill;

import java.util.ArrayList;
import java.util.List;


/**
 * 模拟存在的服务.<br>
 *
 * 2013-9-29上午10:30:23
 */
public class ExistService {
	List<CreditBill> billList = new ArrayList<>();
	
	public void insert(CreditBill creditBill){
		billList.add(creditBill);
		System.out.println("ExistService insert:" + creditBill.toString());
	}
	
	public void insert(String accountID, String name, double amount,
			String date, String address) {
		CreditBill creditBill = new CreditBill(accountID, name, amount, date, address);
		billList.add(creditBill);
		System.out.println("ExistService insert:" + creditBill.toString());
	}
}
