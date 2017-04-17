
package com.vther.spring.batch.ch10;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2013-10-21下午10:30:00
 */

public class JobLaunchRetryPolicy {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch10/job/job-step-retry.xml", "retryPolicyJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
