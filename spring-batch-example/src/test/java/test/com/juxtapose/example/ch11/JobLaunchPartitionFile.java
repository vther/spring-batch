
package test.com.juxtapose.example.ch11;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-11-16下午10:59:46
 */
public class JobLaunchPartitionFile {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch11/job/job-partition-file.xml", "partitionJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
