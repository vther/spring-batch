
package test.com.vther.spring.batch.ch04;

import com.vther.spring.batch.ch04.stop.StopStepListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 *
 *         2013-3-20下午10:35:56
 */
public class JobLaunchStopBusiness {

    /**
     * 执行批处理作业.<br>
     *
     * @param jobPath 作业配置文件
     * @param jobName 作业名
     * @param builder 作业参数构造器
     */
    public static void executeJobAndStop(String jobPath, String jobName, JobParametersBuilder builder) {
        ApplicationContext context = new ClassPathXmlApplicationContext(jobPath);
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncherAsyn");
        StopStepListener<?> stopListener = (StopStepListener<?>) context.getBean("stopListener");
        Job job = (Job) context.getBean(jobName);
        try {
            //任务开启
            launcher.run(job, builder.toJobParameters());

            Thread.sleep(10000L);//模拟一个延时，延时后停止任务

            // 结束任务
            stopListener.setStop(Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void main(String[] args) {
        executeJobAndStop("ch04/job/job-stop.xml", "chunkBusinessJob",
                new JobParametersBuilder().addDate("date", new Date()));
    }
}
