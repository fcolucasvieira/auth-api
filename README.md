# 🔐 Spring Boot JWT Authentication API

![Java](https://img.shields.io/badge/java-21-orange?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/spring_boot-4.0.2-brightgreen?style=for-the-badge\&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/postgresql-database-blue?style=for-the-badge\&logo=postgresql)
![JWT](https://img.shields.io/badge/JWT-authentication-black?style=for-the-badge\&logo=jsonwebtokens)
![Swagger](https://img.shields.io/badge/swagger-documentation-green?style=for-the-badge\&logo=swagger)

## 📌 Sobre o projeto

Esta é uma **API REST desenvolvida com Spring Boot** com o objetivo de demonstrar a implementação de **autenticação e autorização utilizando JWT (JSON Web Token)**.

O projeto implementa um fluxo completo de autenticação com **registro de usuário, login e proteção de rotas**, utilizando **Spring Security**.

Além da parte de segurança, a aplicação também demonstra boas práticas comuns no desenvolvimento de APIs backend, como:

* Arquitetura em camadas
* Uso de DTOs
* Mapeamento com MapStruct
* Paginação de resultados
* Tratamento global de exceções
* Documentação automática com Swagger
* Migrations de banco de dados com Flyway

O projeto foi desenvolvido como **estudo de backend focado em segurança e boas práticas em APIs REST com Spring Boot**.

---

# 🧰 Tecnologias utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Token)**
* **PostgreSQL**
* **Flyway (Database Migrations)**
* **MapStruct**
* **Swagger / OpenAPI**
* **Maven**

---

# 🏗️ Arquitetura do projeto

O projeto segue uma **arquitetura em camadas**, comum em aplicações Spring Boot:

```
Controller → Service → Repository → Database
```

Além disso, foram utilizados componentes auxiliares:

```
DTO
Mapper
Infra (configurações, segurança e exceções)
```

Estrutura principal do projeto:

```
src/main/java/com/fcolucasvieira/auth

controller
service
repository
domain
dto
mapper
infra
   ├── config
   ├── security
   └── exception
```

Essa organização facilita:

* manutenção
* escalabilidade
* separação de responsabilidades

---

# ⚙️ Como executar o projeto

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/fcolucasvieira/auth-api.git
```

## 2️⃣ Acessar o diretório do projeto

```bash
cd auth-api
```

## 3️⃣ Configurar o banco de dados

Certifique-se de que o **PostgreSQL** esteja rodando.

Configure as credenciais no arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/authdb
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## 4️⃣ Executar a aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

---

# 📚 Documentação da API

A documentação da API foi gerada utilizando **Swagger / OpenAPI**.

Após iniciar a aplicação, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

No Swagger é possível:

* visualizar todos os endpoints
* testar requisições
* autenticar utilizando JWT
* explorar os parâmetros da API

---

# 🔐 Fluxo de autenticação

A autenticação da API utiliza **JWT (JSON Web Token)**.

Fluxo básico:

### 1️⃣ Registrar usuário

```
POST /auth/register
```

### 2️⃣ Realizar login

```
POST /auth/login
```

Resposta:

```json
{
  "token": "SEU_TOKEN_JWT"
}
```

### 3️⃣ Autorizar no Swagger

Clique em **Authorize** e insira:

```
Bearer SEU_TOKEN_JWT
```

Agora você poderá acessar os endpoints protegidos.

---

# 📡 Endpoints da API

## Autenticação

```
POST /auth/register → registra um novo usuário
POST /auth/login → autentica usuário e retorna JWT
```

## Produtos (rotas protegidas)

```
POST /products → cria um novo produto
GET /products → lista produtos com paginação
```

Exemplo de requisição:

```json
{
  "name": "Arroz",
  "price": 7.50
}
```

---

# 🗄️ Banco de dados

O projeto utiliza **PostgreSQL** como banco de dados.

As migrations são gerenciadas com **Flyway**.

Exemplo de migration:

```
V1__create_table_products.sql
```

Isso permite:

* versionamento do banco
* controle de alterações no schema
* consistência entre ambientes

---

# ❗ Tratamento de erros

A API possui tratamento global de exceções utilizando:

```
@RestControllerAdvice
```

Exemplo de resposta de erro:

```json
{
  "timestamp": "2026-03-08T18:20:11",
  "status": 400,
  "error": "Validation Error",
  "message": "Price must be greater than zero"
}
```

---

# 🚀 Possíveis melhorias futuras

Algumas evoluções possíveis para o projeto:

* Dockerização da aplicação
* Testes automatizados
* Pipeline CI/CD
* Deploy em nuvem

---

# 👨‍💻 Autor

**Lucas Vieira**

Estudante de Engenharia de Computação – UFC Sobral

GitHub:
https://github.com/fcolucasvieira
