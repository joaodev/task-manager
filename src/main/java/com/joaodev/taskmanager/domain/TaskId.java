package com.joaodev.taskmanager.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record TaskId(UUID id) {
    public TaskId {
        Assert.notNull(id, "TaskId cannot be null");
    }

    public TaskId() {
        this(UUID.randomUUID());
    }
}
