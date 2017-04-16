
package com.vther.spring.batch.ch07.xml;

import org.springframework.batch.item.xml.StaxWriterCallback;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 *
 * 2013-9-21下午03:47:06
 */
public class HeaderStaxWriterCallback implements StaxWriterCallback {

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.xml.StaxWriterCallback#write(javax.xml.stream.XMLEventWriter)
	 */
	@Override
	public void write(XMLEventWriter writer) throws IOException {
		XMLEventFactory factory = XMLEventFactory.newInstance();
		try {
			writer.add(factory.createComment("credit 201310 begin."));
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

}
