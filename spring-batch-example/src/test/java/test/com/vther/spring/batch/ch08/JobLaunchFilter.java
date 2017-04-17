
package test.com.vther.spring.batch.ch08;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.vther.spring.batch.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-9-30上午11:11:09
 */
public class JobLaunchFilter {


	public static void main(String[] args) {
		JobLaunchBase.executeJob("ch08/job/job-filter.xml", "filterJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
