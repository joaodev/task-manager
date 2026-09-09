package com.joaodev.taskmanager.infrastructure.http.request;

import com.joaodev.taskmanager.application.input.CreateTaskInput;

import java.util.Optional;

public record CreateTaskRequest(String title, Optional<String> description) {
    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }
}
