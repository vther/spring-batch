package test.com.juxtapose.example.ch07;

import org.springframework.batch.core.JobParametersBuilder;
import test.com.juxtapose.example.JobLaunchBase;

import java.util.Date;

/**
 * 2013-9-23上午08:06:09
 */
public class JobLaunchClassifierComposite {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch07/job/job-composite-classify.xml", "classifierCompositeWriteJob",
                new JobParametersBuilder().addDate("date", new Date()));
    }
}
