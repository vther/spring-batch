
package test.com.vther.spring.batch.ch08;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.vther.spring.batch.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-9-30上午11:11:02
 */
public class JobLaunchTranslate {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch08/job/job-translate.xml", "translateJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
