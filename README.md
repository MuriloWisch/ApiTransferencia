# ApiTransferencia

Projeto de **API RESTful desenvolvido como forma de estudo e aprimoramento em backend**, com foco em boas práticas, arquitetura organizada e uso de tecnologias amplamente utilizadas no mercado.

A ApiTransferencia é o desafio do picpay que simula um sistema de **transferências entre usuários**, sendo baseada em um desafio técnico de backend. O projeto foi adaptado e renomeado, deixando de lado a marca original e adotando o nome ApiTransferencia, com o objetivo exclusivo de aprendizado e evolução técnica.

---

## 🚀 Tecnologias Utilizadas

* **Java** – Linguagem principal da aplicação
* **Spring Boot** – Framework para construção da API REST
* **MySQL** – Banco de dados relacional
* **Docker** – Containerização da aplicação e do banco de dados
* **Postman** – Testes e validação dos endpoints

---

## 📌 Visão Geral

A **TransferenciaAPI** permite:

* Cadastro de usuários com validação de dados únicos;
* Realização de transferências entre usuários;
* Validação de saldo antes da transferência;
* Execução das transferências de forma transacional;

A API segue princípios REST e foi desenvolvida visando clareza, organização e facilidade de manutenção, servindo como um projeto prático de estudos em backend.

---

## 🧱 Estrutura do Projeto

O projeto segue a estrutura padrão de uma aplicação Spring Boot:

```
src/
├── main/
│   ├── java/
│   │   └── com/ApiTransferencia/…
│   │       ├── controller/dto
│   │       ├── service/
│   │       ├── repository/
│   │       ├── entity/
│   │       └── config/ 
│   └── resources/
│       ├── application.properties
│       └── …
├
Dockerfile
docker-compose.yml
pom.xml

```

* **Controller** – Definição dos endpoints REST
* **Service** – Regras de negócio
* **Repository** – Persistência de dados com JPA
* Config - Configurar carregante de dados
* **Entity / DTO** – Entidades e objetos de transferência de dados

---

## 🛠️ Como Rodar Localmente

### 🐋 Pré-requisitos

* Docker e Docker Compose
* Git
* Java 17+
* Maven

---

### 📦 Passo a passo

1. Clone o repositório:

```bash
git clone https://github.com/MuriloWisch/ApiTransferencia.git
cd ApiTransferencia
```

2. Suba os containers:

```bash
docker compose up -d
```

3. A aplicação ficará disponível em:

```
http://localhost:8080
```

---

## 🔧 Endpoints

Exemplo de endpoint para realizar uma transferência:

```
POST /transferencia
Content-Type: application/json

{
  "valor": 100.0,
  "remetente": 1,
  "recebedor": 2
}
```

Esse endpoint valida saldo e regras de negócio antes de concluir a operação.

---

✨ Funcionalidade Adicional – Crédito de Saldo

Foi implementada uma feature extra de crédito de valor em carteira, permitindo adicionar saldo a um usuário sem a necessidade de uma transferência entre contas.

Essa funcionalidade foi criada com o objetivo de aprofundar o aprendizado em:

Atualizações parciais de recursos (PATCH);

Regras de negócio isoladas na camada de serviço;

Validações de entrada;

Boas práticas de design de endpoints REST.

Essa adição reforça o caráter evolutivo do projeto, indo além do desafio base e explorando situações do mundo real no desenvolvimento backend.

```
🔗 Endpoint (Postman)

PATCH /carteira/1/creditar
Content-Type: application/json

📦 Body (JSON)

{
  "saldo": 100
}
👉 Esse valor será somado ao saldo atual da carteira.


```

## 📍 Testes com Postman

O projeto pode ser testado utilizando o **Postman**, permitindo validar:

* Cadastro de usuários
* Consulta de usuários
* Transferências entre contas
* Creditar valor para usuários

---

## 🐳 Docker

O projeto conta com:

* **Dockerfile** para build da aplicação
* **docker-compose.yml** para orquestrar API e banco MySQL

Facilitando a execução do projeto em qualquer ambiente.

---

## 📝 Considerações Finais

Este projeto tem como principal objetivo o **MEU aprendizado prático em desenvolvimento backend**, explorando:

* Arquitetura em camadas
* Boas práticas com Spring Boot
* Integração com banco de dados relacional
* Uso de Docker no ambiente de desenvolvimento
