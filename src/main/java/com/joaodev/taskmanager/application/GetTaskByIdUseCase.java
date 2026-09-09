package com.joaodev.taskmanager.application;

import com.joaodev.taskmanager.application.output.TaskOutput;
import com.joaodev.taskmanager.domain.TaskId;
import com.joaodev.taskmanager.domain.TaskNotFoundException;
import com.joaodev.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
