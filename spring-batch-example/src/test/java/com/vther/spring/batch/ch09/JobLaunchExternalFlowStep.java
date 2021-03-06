package com.vther.spring.batch.ch09;

import com.vther.spring.batch.JobLaunchBase;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

/**
 * 2013-9-30上午11:11:09
 */
public class JobLaunchExternalFlowStep {


    public static void main(String[] args) {
        JobLaunchBase.executeJob("ch09/job/job-external-flow-step.xml", "externalFlowStepJob",
                new JobParametersBuilder().addDate("date", new Date())
                        .addString("inputFile", "classpath:ch09/data/credit-card-bill-201310.zip")
                        .addString("readFileName", "credit-card-bill-201310.csv")
                        .addString("workDirectory", "file:target/ch09/work/")
                        .addString("writeTarget", "file:target/ch09/externalFlowStep/outputFile.csv"));
    }
}
