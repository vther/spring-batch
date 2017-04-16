package com.vther.spring.batch.ch11.partition.remote;

import org.springframework.batch.core.StepExecution;
import org.springframework.integration.Message;

import java.util.Collection;

/**
 *
 *
 * 2014-3-23下午06:16:21
 */
public class MessageTransformer {
	@SuppressWarnings("unchecked")
	public Message<Collection<StepExecution>> extract(Message<?>  inMessage)  {
		return (Message<Collection<StepExecution>>)inMessage;
	}
}
