package com.joaodev.taskmanager.infrastructure.repository;

import com.joaodev.taskmanager.domain.TaskRepository;
import com.joaodev.taskmanager.domain.TaskRepositoryTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InMemoryTaskRepositoryTest extends TaskRepositoryTest {

    private InMemoryTaskRepository repository;

    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}