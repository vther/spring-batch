
package com.vther.spring.batch.ch07.flat;

import org.springframework.batch.item.file.FlatFileFooterCallback;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * 2013-9-20上午09:14:05
 */
public class DefaultFlatFileFooterCallback implements FlatFileFooterCallback {

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.file.FlatFileFooterCallback#writeFooter(java.io.Writer)
	 */
	@Override
	public void writeFooter(Writer writer) throws IOException {
		writer.write("##credit 201310 end.");
	}

}
