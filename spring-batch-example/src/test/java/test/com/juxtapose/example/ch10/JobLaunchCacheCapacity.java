
package test.com.juxtapose.example.ch10;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-10-21下午10:31:59
 */
public class JobLaunchCacheCapacity {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch10/job/job-step-retry.xml", "retryCacheCapacityJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
