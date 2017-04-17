
package test.com.vther.spring.batch.ch10;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.vther.spring.batch.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-2-28下午08:34:48
 */
public class JobLaunchSkip {

	public static void main(String[] args) {
		JobLaunchBase.executeJob("ch10/job/job-step-skip.xml", "skipJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
