
package com.vther.spring.batch.ch07;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2013-9-29下午12:36:33
 */
public class JobLaunchCustomItemWriter {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch07/job/job-custom-itemwriter.xml", "customItemWriteJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
