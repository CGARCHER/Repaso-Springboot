package com.cgarcher.mybatch.tasklet;

import org.generator.api.StudentControllerApi;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldTasketlet implements Tasklet {

    private final StudentControllerApi studentControllerApi;

    public HelloWorldTasketlet(StudentControllerApi studentControllerApi) {
        this.studentControllerApi = studentControllerApi;
    }


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {


        studentControllerApi.getAllByFinished(true);

        System.out.println("Hola mundo");
        return RepeatStatus.FINISHED;
    }
}
