
package test.com.juxtapose.example.ch11;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 *
 *
 * 2014-3-23下午08:05:38
 */
public class JobLaunchChunkRemoteOther {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch11/job/job-chunk-remote-other.xml", "remoteChunkJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
