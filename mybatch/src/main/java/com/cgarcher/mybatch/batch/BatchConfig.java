package com.cgarcher.mybatch.batch;

import com.cgarcher.mybatch.tasklet.HelloWorldTasketlet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final HelloWorldTasketlet helloWorldTasketlet;
    private final JobLauncher jobLauncher;


    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager, HelloWorldTasketlet helloWorldTasketlet, JobLauncher jobLauncher) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        this.jobRepository = jobRepository;
        this.platformTransactionManager = platformTransactionManager;
        this.helloWorldTasketlet = helloWorldTasketlet;
        this.jobLauncher = jobLauncher;

    }

    @Bean
    public Job HelloJob(){
        return new JobBuilder("helloJob", jobRepository)
                .start(step())
                .build();
    }

    @Bean
    public Step step(){
        return new StepBuilder("step", jobRepository)
                .tasklet(helloWorldTasketlet, platformTransactionManager)
                .build();
    }




}
