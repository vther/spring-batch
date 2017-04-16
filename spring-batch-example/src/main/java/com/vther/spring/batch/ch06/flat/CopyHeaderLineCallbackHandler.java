package com.vther.spring.batch.ch06.flat;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.LineCallbackHandler;

import java.io.IOException;
import java.io.Writer;

/**
 *
 *
 * 2013-4-3下午08:01:45
 */
public class CopyHeaderLineCallbackHandler implements LineCallbackHandler,
		FlatFileHeaderCallback {
	private String header = "";

	public void handleLine(String line) {
		this.header = line;
	}

	public void writeHeader(Writer writer) throws IOException {
		writer.write(header);
	}
}
