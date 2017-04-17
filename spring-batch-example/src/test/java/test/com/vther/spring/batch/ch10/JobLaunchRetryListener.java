
package test.com.vther.spring.batch.ch10;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.vther.spring.batch.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-10-21下午10:14:09
 */
public class JobLaunchRetryListener {


	public static void main(String[] args) {
		JobLaunchBase.executeJob("ch10/job/job-step-retry-listener.xml", "retryListener2Job",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}