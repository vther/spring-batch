
package com.vther.spring.batch.ch07;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2013-9-23上午08:06:09
 */
public class JobLaunchComposite {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch07/job/job-composite.xml", "compositeWriteJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
