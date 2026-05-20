# Maiawall API

API REST para gerenciamento de pessoas, construída com Spring Boot.

## Tecnologias

- Java 21
- Spring Boot 3.5
- Spring Data JPA + H2 (banco em memória)
- OpenFeign (integração com ViaCEP)
- Resilience4j (circuit breaker)
- Springdoc OpenAPI (Swagger)
- Lombok

## Como rodar

```bash
./mvnw spring-boot:run
```

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/pearson` | Lista todas as pessoas |
| GET | `/pearson/{id}` | Busca pessoa por ID |
| POST | `/pearson` | Cria uma pessoa |
| PATCH | `/pearson/{id}` | Atualiza uma pessoa |
| DELETE | `/pearson/{id}` | Remove uma pessoa |
| GET | `/pearson/{id}/adress` | Busca o endereço da pessoa via ViaCEP |

## Recursos

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **H2 Console:** `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:maiawall`
  - Usuário: `sa` / Senha: *(vazio)*
