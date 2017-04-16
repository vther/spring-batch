
package test.com.juxtapose.example.ch07;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-9-21下午05:25:54
 */
public class JobLaunchFileSets {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch07/job/job-filesets.xml", "filesetsWriterJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
