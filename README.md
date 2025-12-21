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
* Simulação de integrações externas para autorização ou notificação.

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

## 📍 Testes com Postman

O projeto pode ser testado utilizando o **Postman**, permitindo validar:

* Cadastro de usuários
* Consulta de usuários
* Transferências entre contas

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
