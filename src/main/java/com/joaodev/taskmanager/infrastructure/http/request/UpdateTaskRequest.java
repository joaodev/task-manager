package com.joaodev.taskmanager.infrastructure.http.request;

import com.joaodev.taskmanager.application.input.UpdateTaskInput;
import com.joaodev.taskmanager.domain.TaskStatus;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<@Size(min = 3, max = 100) String> title,
        Optional<@Size(max = 500) String> description,
        Optional<String> status
) {
    public UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
