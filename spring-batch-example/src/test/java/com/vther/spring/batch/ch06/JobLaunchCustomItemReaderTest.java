
package com.vther.spring.batch.ch06;

import com.vther.spring.batch.ch06.cust.itemreader.CustomCreditBillItemReader;
import com.vther.spring.batch.ch06.cust.itemreader.RestartableCustomCreditBillItemReader;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 2013-9-7下午03:03:44
 */
public class JobLaunchCustomItemReaderTest {
	
	/**
	 * 测试自定义ItemReader
	 * @throws Exception
	 */
	@Test
	public void testCustItemReader() throws Exception{
		List<CreditBill> list = new ArrayList<CreditBill>();
		list.add(new CreditBill("1","tom",100.00,"2013-2-2 12:00:08","Lu Jia Zui road"));
		list.add(new CreditBill("2","tom",320,"2013-2-3 10:35:21","Lu Jia Zui road"));
		list.add(new CreditBill("3","tom",360.00,"2013-2-11 11:12:38","Longyang road"));
		CustomCreditBillItemReader reader = new CustomCreditBillItemReader(list);
		Assert.assertEquals("1", reader.read().getAccountID());
		Assert.assertEquals("2", reader.read().getAccountID());
		Assert.assertEquals("3", reader.read().getAccountID());
		Assert.assertNull(reader.read());
	}
	
	/**
	 * 测试可重启的自定义ItemReader
	 * @throws Exception
	 */
	@Test
	public void testRestartableCustItemReader() throws Exception{
		List<CreditBill> list = new ArrayList<CreditBill>();
		list.add(new CreditBill("1","tom",100.00,"2013-2-2 12:00:08","Lu Jia Zui road"));
		list.add(new CreditBill("2","tom",320,"2013-2-3 10:35:21","Lu Jia Zui road"));
		list.add(new CreditBill("3","tom",360.00,"2013-2-11 11:12:38","Longyang road"));
		
		RestartableCustomCreditBillItemReader reader = new RestartableCustomCreditBillItemReader(list);
		ExecutionContext executionContext = new ExecutionContext();
		((ItemStream)reader).open(executionContext);
		Assert.assertEquals("1", reader.read().getAccountID());
		((ItemStream)reader).update(executionContext);
		
		reader = new RestartableCustomCreditBillItemReader(list);
		((ItemStream)reader).open(executionContext);
		Assert.assertEquals("2", reader.read().getAccountID());
	}
	
	
}
