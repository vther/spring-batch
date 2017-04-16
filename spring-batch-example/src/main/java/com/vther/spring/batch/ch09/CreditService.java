
package com.vther.spring.batch.ch09;


/**
 *
 * 2013-10-7上午10:06:37
 */
public interface CreditService {
	
	/**
	 * 解压缩文件
	 */
	void decompress(String inputFile,String outputDirectory);
	
	/**
	 * 校验文件
	 */
	String verify(String outputDirectory, String readFileName);
	
	/**
	 * 清空临时作业空间
	 */
	void clean(String outputDirectory);
	
	
	/**
	 * 检查文件是否存在
	 */
	boolean exists(String file);
}
