Sistema de Gerenciamento de Projetos e Tarefas
📋 Sobre o Projeto
Sistema backend para gerenciamento de projetos e tarefas desenvolvido em Java 21 com arquitetura REST API.

🚀 Tecnologias
Java 21

Spring Boot 3.x

Spring Data JPA

H2 Database (desenvolvimento)

PostgreSQL (opcional)

Maven

Docker (opcional)

🗄️ Banco de Dados
H2 (Desenvolvimento)
URL: jdbc:h2:mem:testdb

Console: http://localhost:8080/h2-console

Usuário: sa

Senha: (vazia)

🐳 Docker (PostgreSQL)

🎯 Endpoints Principais
Projetos
GET /projects - Listar projetos

GET /projects/{id} - Buscar projeto por ID

POST /projects - Criar projeto

PUT /projects/{id} - Atualizar projeto

DELETE /projects/{id} - Excluir projeto

Tarefas
GET /tasks - Listar tarefas

GET /tasks/{id} - Buscar tarefa por ID

POST /tasks/{projectId} - Criar tarefa

PUT /tasks/{id} - Atualizar tarefa

DELETE /tasks/{id} - Excluir tarefa

🔧 Configuração
Pré-requisitos
Java 21

Maven 3.6+

Docker (opcional)

📊 Modelo de Dados
Project
id (UUID)

name (String)

startDate (Date)

endDate (Date)

Task
id (UUID)

title (String)

description (String)

status (Enum: TODO, DOING, DONE)

priority (Enum: LOW, MEDIUM, HIGH, URGENT)

dueDate (Date)

project (Project)

![desafio1](https://github.com/user-attachments/assets/00dd958d-0faa-48e4-a505-6cf5b0de5784)


![desafio2](https://github.com/user-attachments/assets/94c2cca6-91ae-433c-8529-6b34b9229191)
