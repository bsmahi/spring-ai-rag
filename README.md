# Spring AI RAG (Retrieval-Augmented Generation)

A demo project showcasing Retrieval-Augmented Generation (RAG) using [Spring AI](https://docs.spring.io/spring-ai/reference/). It integrates LLMs with vector-based document retrieval to answer questions with context-rich, accurate responses.

---

## 🚀 Features

- ✅ Spring Boot + Spring AI integration
- ✅ Embedding documents using OpenAI embeddings
- ✅ Vector store support (in-memory or pluggable)
- ✅ REST API to query AI with contextual data
- ✅ Configurable LLM backends

---

## 🧰 Tech Stack

- Java 21+
- Spring Boot 3.x
- Spring AI
- OpenAI API
- Maven

---

## 📂 Project Structure

````tree
spring-ai-rag/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bsmahi/
│   │   │           └── springairag/
│   │   │               ├── controller/
│   │   │               ├── service/
│   │   │               ├── config/
│   │   │               └── SpringAiRagApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/                # (optional for frontend files)
│   │       └── templates/             # (optional for Thymeleaf templates)
│
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── bsmahi/
│                   └── springairag/
│                       └── SpringAiRagApplicationTests.java
│
├── .gitignore
├── README.md
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml

````

## ✅ Core Dependencies

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

```
- Enables Spring Web (REST API, controllers, etc.)
- Required to expose your RAG APIs

## 🧠 Spring AI Dependencies

```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-advisors-vector-store</artifactId>
</dependency>
```
- Provides advisors to enhance responses using a vector store (e.g., RAG-based context injection)

```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-pdf-document-reader</artifactId>
</dependency>
```
- Allows reading and processing PDF documents for embedding into the vector database

```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-starter-model-openai</artifactId>
</dependency>
```
- Integrates OpenAI models (e.g., GPT-4o) with Spring AI
- Required to call OpenAI APIs for embedding and chat generation

```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-starter-vector-store-pgvector</artifactId>
</dependency>
```
- Adds support for pgvector (PostgreSQL extension for vector search)
- Enables storing and querying embeddings in a PostgreSQL database

```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-starter-mcp-server</artifactId>
</dependency>
```

- MCP = Model Coordination Protocol (optional advanced orchestration)
- Used to host an AI coordination layer for LLM routing/middleware (if needed)

## 📖 API Documentation

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.7.0</version>
</dependency>
```
- Enables Swagger UI for your REST APIs
- Auto-generates OpenAPI documentation at /swagger-ui.html

## 🐳 Docker Support

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-docker-compose</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
```

- Native support for docker-compose.yml integration in Spring Boot
- Automatically starts services like pgvector from Docker Compose during development

```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-spring-boot-docker-compose</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
``` 
- Adds Spring AI–specific Docker Compose service configuration (e.g., sets up vector store, LLM mock)

## 🧪 Testing

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```
- Provides JUnit, Mockito, and Spring Boot test utilities

## 📦 Dependency Management (BOM

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.ai</groupId>
      <artifactId>spring-ai-bom</artifactId>
      <version>${spring-ai.version}</version> // 1.0.0
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```
- BOM = Bill of Materials
- Manages consistent versions for all Spring AI modules
- You just need to declare the artifact, version is automatically picked from BOM

## Test via Swagger UI
1. Start your app:
  ```bash
  ./mvnw spring-boot:run
  ```
2. Open Swagger UI in your browser: http://localhost:8080/swagger-ui.html
3. http://localhost:8080/swagger-ui/index.html#/chat-controller/chat
