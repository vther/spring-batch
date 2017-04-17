
package test.com.vther.spring.batch.ch07;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.vther.spring.batch.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2013-2-28下午08:34:48
 */
public class JobLaunchXmlCallback {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch07/job/job-xml-callback.xml", "xmlFileReadAndWriterJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
