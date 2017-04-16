
package test.com.juxtapose.example.ch08;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-9-30上午11:11:09
 */
public class JobLaunchValidate {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch08/job/job-validate.xml", "validateJob",
				new JobParametersBuilder().addDate("date", new Date())
						.addString("filter", "false"));
	}
}
