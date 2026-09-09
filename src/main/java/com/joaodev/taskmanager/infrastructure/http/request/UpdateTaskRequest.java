package com.joaodev.taskmanager.infrastructure.http.request;

import com.joaodev.taskmanager.application.input.UpdateTaskInput;
import com.joaodev.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
) {
    public UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
