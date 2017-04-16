
package test.com.juxtapose.example.ch10;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

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
