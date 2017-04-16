
package com.vther.spring.batch.ch07.xml;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.xml.StaxWriterCallback;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 *
 * 2013-9-21下午03:47:23
 */
public class FooterStaxWriterCallback extends StepExecutionListenerSupport
		implements StaxWriterCallback {
	private StepExecution stepExecution;
	/* (non-Javadoc)
	 * @see org.springframework.batch.item.xml.StaxWriterCallback#write(javax.xml.stream.XMLEventWriter)
	 */
	@Override
	public void write(XMLEventWriter writer) throws IOException {
		XMLEventFactory factory = XMLEventFactory.newInstance();
		try {
			writer.add(factory.createComment("Total write count = "
					+ stepExecution.getWriteCount() + ";credit 201310 end."));
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
}
