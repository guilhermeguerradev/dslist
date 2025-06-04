
# 🎮 DSList - Game Organizer API

API RESTful para listar, consultar e reordenar jogos em listas personalizadas, desenvolvida com Java e Spring Boot.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7+-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![License](https://img.shields.io/badge/License-MIT-blue)

---

## 📚 Sobre o Projeto

O **DSList** é uma aplicação backend que oferece uma API REST para gerenciar listas de jogos.  
Você pode buscar jogos cadastrados, ver os detalhes de cada jogo, organizar jogos dentro de listas específicas e reordenar esses jogos de forma dinâmica.

Este projeto simula uma funcionalidade típica de **catálogos de games** como Steam ou Game Pass.

---

## 🚀 Funcionalidades

- ✅ Listagem de todos os jogos
- ✅ Consulta detalhada de um jogo por ID
- ✅ Listagem de jogos por lista
- ✅ Reordenação de jogos dentro de uma lista com persistência no banco

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de Dados Relacional (H2 ou PostgreSQL)
- Maven

---

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │   └── com.devsuperior.dslist/
     │       ├── controllers/
     │       ├── dto/
     │       ├── entities/
     │       ├── projections/
     │       ├── repositories/
     │       └── services/
     └── resources/
         ├── application.properties
         └── data.sql (opcional para popular o banco)
```

---

## 📦 Como Rodar o Projeto

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/dslist.git
cd dslist
```

### 2. Abra na sua IDE favorita (IntelliJ, Eclipse...)

### 3. Configure o banco
- Use H2 (em memória) ou configure PostgreSQL no `application.properties`.

### 4. Execute a aplicação
```bash
./mvnw spring-boot:run
```

---

## 🌐 Endpoints da API

| Verbo HTTP | Rota                            | Descrição                               |
|------------|----------------------------------|------------------------------------------|
| GET        | `/games`                         | Lista todos os jogos (resumido)          |
| GET        | `/games/{id}`                    | Detalhes completos de um jogo            |
| GET        | `/lists`                         | Lista todas as listas de jogos           |
| GET        | `/lists/{listId}/games`          | Lista os jogos de uma lista específica   |
| POST       | `/lists/{listId}/replacement`    | Reordena jogos dentro de uma lista       |

---

## 📥 Exemplo de Requisição (reordenar jogos)

```http
POST /lists/1/replacement
Content-Type: application/json

{
  "sourceIndex": 3,
  "destinationIndex": 1
}
```

---

## 🧠 Conceitos Demonstrados

- Uso de DTOs para encapsular respostas
- Camada de serviços com regras de negócio
- Uso de chave composta com @Embeddable e @EmbeddedId
- Consultas SQL otimizadas com projeções
- Atualização com @Modifying e @Query
- Clean code e arquitetura em camadas

---


📧 contato: guilhermeguerrajf@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/guilherme-guerra-663989213/)

---



