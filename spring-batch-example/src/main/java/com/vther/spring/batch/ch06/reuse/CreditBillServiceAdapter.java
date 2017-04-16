
package com.vther.spring.batch.ch06.reuse;

import com.vther.spring.batch.ch06.CreditBill;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 *
 * 2013-9-7下午01:40:07
 */
public class CreditBillServiceAdapter implements InitializingBean{
	List<CreditBill> creditBillList;
	private ExistService existService;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.creditBillList = existService.queryAllCreditBill();
	}
	
	public CreditBill nextCreditBill() {
		if (creditBillList.size() > 0) {
			return creditBillList.remove(0);
		} else {
			return null;
		}
	}

	public ExistService getExistService() {
		return existService;
	}

	public void setExistService(ExistService existService) {
		this.existService = existService;
	}
}
