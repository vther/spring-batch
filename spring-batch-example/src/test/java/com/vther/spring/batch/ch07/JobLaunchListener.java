
package com.vther.spring.batch.ch07;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2013-8-16下午09:09:42
 */
public class JobLaunchListener extends JobLaunchBase {


    public static void main(String[] args) {
        executeJob("ch07/job/job-listener.xml", "itemReadJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
