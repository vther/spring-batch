
package com.vther.spring.batch.ch04.stop;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 *
 *         2013-3-20下午10:19:47
 */
public class StopStepListener<T> implements StepExecutionListener, ItemReadListener<T> {
    private StepExecution stepExecution;
    private Boolean stop = Boolean.FALSE;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public void beforeRead() {
        if (isStop()) {
            this.stepExecution.setTerminateOnly();
        }
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void afterRead(T item) {
    }

    @Override
    public void onReadError(Exception ex) {
    }

    public Boolean isStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }
}
