
package com.vther.spring.batch.ch11;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 *
 *
 * 2014-3-23下午08:05:38
 */
public class JobLaunchChunkRemote {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch11/job/job-chunk-remote.xml", "remoteChunkJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
