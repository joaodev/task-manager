package com.joaodev.taskmanager.application;

import com.joaodev.taskmanager.application.input.CreateTaskInput;
import com.joaodev.taskmanager.application.output.TaskOutput;
import com.joaodev.taskmanager.domain.Task;
import com.joaodev.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}
