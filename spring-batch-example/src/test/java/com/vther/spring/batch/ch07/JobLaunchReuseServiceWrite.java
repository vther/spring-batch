
package com.vther.spring.batch.ch07;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2013-8-16下午09:09:42
 */
public class JobLaunchReuseServiceWrite extends JobLaunchBase {


    public static void main(String[] args) {
        executeJob("ch07/job/job-reuse-service.xml", "reuseServiceJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
