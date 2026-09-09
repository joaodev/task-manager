# Task Manager

Projeto simples de gerenciamento de tarefas desenvolvido em Java com Spring Boot.

Descrição

Aplicação exemplo que expõe uma API REST para criar, listar, atualizar e remover tarefas. É organizada em camadas (domain, application, infrastructure) e usa um repositório em memória por padrão.

Tecnologias

- Java (toolchain 25)
- Spring Boot 4.1.1
- Lombok
- Gradle (wrapper incluído)
- Spring REST Docs + Asciidoctor (para documentação gerada)

Estrutura principal

- src/main/java/com/joaodev/taskmanager/domain — entidades e enums (Task, TaskStatus, TaskId)
- src/main/java/com/joaodev/taskmanager/application — casos de uso (Create, Get, Update, Delete)
- src/main/java/com/joaodev/taskmanager/infrastructure — controller HTTP, requests/responses e repositório (InMemoryTaskRepository)

Pré-requisitos

- JDK 25
- (Opcional) Docker/DB se quiser persistência real

Como rodar

1. Rodar com o Gradle wrapper:

   ./gradlew bootRun

   A aplicação ficará disponível em: http://localhost:8080

2. Build e testes:

   ./gradlew build
   ./gradlew test

Gerar documentação (Asciidoctor + Spring REST Docs)

   ./gradlew asciidoctor

A documentação HTML gerada ficará em: build/asciidoc/html (ou build/docs/asciidoc/html dependendo da versão do Gradle)

API - Endpoints

- GET /tasks
  - Lista todas as tarefas

- GET /tasks/{id}
  - Retorna uma tarefa pelo id (UUID)

- POST /tasks
  - Cria uma nova tarefa
  - Exemplo de corpo JSON:
    {
      "title": "Comprar leite",
      "description": "Ir ao supermercado"    
    }
  - Resposta: 201 Created com o objeto da tarefa

- PATCH /tasks/{id}
  - Atualiza campos opcionais (title, description, status)
  - Exemplos de status válidos: PENDING, IN_PROGRESS, COMPLETED
  - Exemplo de corpo parcial:
    { "status": "COMPLETED" }

- DELETE /tasks/{id}
  - Remove a tarefa (resposta 204 No Content)

Observações

- Repositório em memória (InMemoryTaskRepository) é usado por padrão. Para persistência, implementar a interface TaskRepository e registrar o bean apropriado (por exemplo, Spring Data JPA).
- Validações: Create exige título não vazio (3-100 chars). Update aceita campos opcionais.

Contribuição

Fork & pull requests são bem-vindos. Abra issues para bugs ou sugestões.

Licença

Sem licença especificada (adicionar LICENSE se desejar).
