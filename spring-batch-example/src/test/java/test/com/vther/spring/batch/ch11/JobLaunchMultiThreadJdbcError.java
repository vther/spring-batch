
package test.com.vther.spring.batch.ch11;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.vther.spring.batch.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-11-16下午10:59:46
 */
public class JobLaunchMultiThreadJdbcError {


	public static void main(String[] args) {
		JobLaunchBase.executeJob("ch11/job/job-multithreade-db.xml", "dbErrorJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}