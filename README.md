# GreenEvents API 

API RESTful para gerenciamento de eventos desenvolvida com Java e Spring Boot, seguindo padrões de arquitetura em camadas, separação de responsabilidades com DTOs e tratamento global de exceções.

##  Tecnologias Utilizadas
* **Linguagem:** Java
* **Framework:** Spring Boot
* **Acesso a Dados:** Spring Data JPA / Hibernate
* **Validação:** Bean Validation
* **Banco de Dados:** H2 Database (Ambiente de Testes) / PostgreSQL

## Arquitetura e Boas Práticas
* **Camadas bem definidas:** Controller (endpoints HTTP), Service (regras de negócio) e Repository (persistência).
* **Segregação por DTOs:** Uso de `EventRequestDTO` e `EventResponseDTO` para isolar as entidades de domínio da camada de exposição.
* **Tratamento Global de Erros:** Captura centralizada de exceções (`ResourceExceptionHandler`) retornando respostas HTTP padronizadas (`400 Bad Request`, `404 Not Found`).

## Endpoints da API

| Método | Rota | Descrição | Status de Sucesso |
| :--- | :--- | :--- | :--- |
| `POST` | `/events` | Cria um novo evento | `201 Created` |
| `GET` | `/events` | Lista todos os eventos | `200 OK` |
| `GET` | `/events/{id}` | Busca evento por ID | `200 OK` |
| `PUT` | `/events/{id}` | Atualiza dados de um evento | `200 OK` |
| `DELETE` | `/events/{id}` | Deleta um evento por ID | `204 No Content` |

