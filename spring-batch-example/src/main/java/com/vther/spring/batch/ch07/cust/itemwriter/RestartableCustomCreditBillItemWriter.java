
package com.vther.spring.batch.ch07.cust.itemwriter;

import com.vther.spring.batch.ch07.CreditBill;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * 2013-9-29下午12:18:47
 */
public class RestartableCustomCreditBillItemWriter implements ItemWriter<CreditBill>, ItemStream {
    private static final String CURRENT_LOCATION = "current.location";
    private List<CreditBill> result = new ArrayList<CreditBill>();
    private int currentLocation = 0;
	
	@Override
	public void write(List<? extends CreditBill> items) throws Exception {
		for(;currentLocation < items.size();){
			result.add(items.get(currentLocation++));
		}
	}

	@Override
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
		if(executionContext.containsKey(CURRENT_LOCATION)){
			currentLocation = new Long(executionContext.getLong(CURRENT_LOCATION)).intValue();
        }else{
        	currentLocation = 0;
        }
	}

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		executionContext.putLong(CURRENT_LOCATION, new Long(currentLocation).longValue());
	}

	@Override
	public void close() throws ItemStreamException {}

	public List<CreditBill> getResult() {
		return result;
	}
}
