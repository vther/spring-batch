
package com.vther.spring.batch.ch08;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2013-9-30上午11:11:09
 */
public class JobLaunchComposite {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch08/job/job-composite.xml", "compositeJob",
				new JobParametersBuilder().addDate("date", new Date())
						.addString("filter", "true"));
	}
}
