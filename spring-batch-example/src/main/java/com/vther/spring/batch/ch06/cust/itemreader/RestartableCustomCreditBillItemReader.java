
package com.vther.spring.batch.ch06.cust.itemreader;

import com.vther.spring.batch.ch06.CreditBill;
import org.springframework.batch.item.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 2013-9-7下午02:16:52
 */
public class RestartableCustomCreditBillItemReader implements ItemReader<CreditBill>,ItemStream{
    private static final String CURRENT_LOCATION = "current.location";
    private List<CreditBill> list = new ArrayList<CreditBill>();
    private int currentLocation = 0;
	
	public RestartableCustomCreditBillItemReader(List<CreditBill> list){
		this.list = list;
	}

	@Override
	public CreditBill read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if (!list.isEmpty()) {
            return list.get(currentLocation++);
        }
		return null;
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
}
