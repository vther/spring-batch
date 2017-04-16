
package test.com.juxtapose.example.ch10;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-10-21下午10:14:09
 */
public class JobLaunchRetryTasklet {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch10/job/job-step-retry-tasklet.xml", "retryTaskletJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
