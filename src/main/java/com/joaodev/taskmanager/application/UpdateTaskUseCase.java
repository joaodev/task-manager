package com.joaodev.taskmanager.application;

import com.joaodev.taskmanager.application.input.UpdateTaskInput;
import com.joaodev.taskmanager.application.output.TaskOutput;
import com.joaodev.taskmanager.domain.TaskId;
import com.joaodev.taskmanager.domain.TaskNotFoundException;
import com.joaodev.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }
}
