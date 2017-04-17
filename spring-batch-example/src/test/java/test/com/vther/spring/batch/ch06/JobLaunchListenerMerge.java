
package test.com.vther.spring.batch.ch06;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.vther.spring.batch.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-8-16下午09:09:42
 */
public class JobLaunchListenerMerge extends JobLaunchBase {


	public static void main(String[] args) {
		executeJob("ch06/job/job-listener.xml", "mergeChunkJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
