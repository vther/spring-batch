package com.vther.spring.batch.ch09;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

/**
 * 2013-9-30上午11:11:09
 */
public class JobLaunchConditionalStop {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch09/job/job-conditional-stop.xml", "conditionalStopJob",
                new JobParametersBuilder()
                        .addString("inputFile", "classpath:ch09/data/credit-card-bill-201310.zip")
                        .addString("readFileName", "credit-card-bill-201310.csv")
                        .addString("workDirectory", "file:target/ch09/work/")
                        .addString("writeTarget", "file:target/ch09/conditional_stop/outputFile.csv"));
    }
}
