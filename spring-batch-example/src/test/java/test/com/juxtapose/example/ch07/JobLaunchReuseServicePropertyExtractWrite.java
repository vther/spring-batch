
package test.com.juxtapose.example.ch07;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-8-16下午09:09:42
 */
public class JobLaunchReuseServicePropertyExtractWrite extends JobLaunchBase{


    public static void main(String[] args) {
        executeJob("ch07/job/job-reuse-service.xml", "reuseServicePropertyExtractJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
