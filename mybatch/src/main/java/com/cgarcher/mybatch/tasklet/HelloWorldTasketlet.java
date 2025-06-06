package com.cgarcher.mybatch.tasklet;

import com.cgarcher.mybatch.service.IStudentFinishedService;
import org.generator.api.StudentControllerApi;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldTasketlet implements Tasklet {

    private final StudentControllerApi studentControllerApi;

    private final IStudentFinishedService studentFinishedService;

    public HelloWorldTasketlet(StudentControllerApi studentControllerApi, IStudentFinishedService studentFinishedService) {
        this.studentControllerApi = studentControllerApi;
        this.studentFinishedService = studentFinishedService;
    }


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        studentFinishedService
                .createStudentsFinished(studentControllerApi.getAllByFinished(true));

        return RepeatStatus.FINISHED;
    }
}
