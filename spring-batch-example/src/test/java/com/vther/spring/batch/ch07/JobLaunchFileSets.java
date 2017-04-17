
package com.vther.spring.batch.ch07;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2013-9-21下午05:25:54
 */
public class JobLaunchFileSets {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch07/job/job-filesets.xml", "filesetsWriterJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
