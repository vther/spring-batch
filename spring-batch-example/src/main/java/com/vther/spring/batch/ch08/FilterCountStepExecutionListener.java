
package com.vther.spring.batch.ch08;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

/**
 *
 * 2013-9-30下午03:20:11
 */
public class FilterCountStepExecutionListener extends StepExecutionListenerSupport {
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		int filterCount = stepExecution.getFilterCount();
		System.out.println("Filter count=" + filterCount);
		return stepExecution.getExitStatus();
	}
}
