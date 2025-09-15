# 🛒 Sales API
É uma aplicação desenvolvida em Java com Spring Boot para gerenciar vendas de veículos. Ela oferece endpoints REST para registrar vendas, atualizar status de pagamento via webhook e listar veículos disponíveis ou vendidos. A aplicação utiliza um banco de dados H2 e suporta execução local ou em contêineres Docker. Além disso, conta com integração contínua e deploy automatizado utilizando GitHub Actions e AWS App Runner.

## Descrição do Projeto

---

## 📚 Tecnologias Utilizadas
- Java 17
- Spring Boot
- H2
- Docker
- GitHub Actions (CI/CD)
- AWS ECR (Elastic Container Registry)
- AWS App Runner

---

## 🚀 Como Rodar Localmente

### 1️⃣ Clonar o repositório
```sh
git clone https://github.com/LucasRFigueiredo/fiap-sub-vendas.git
cd vendas-api
```

---

## 📦 Docker
### Build e execução com Docker
```sh
docker build -t sales-api .
docker run -p 8081:8081 sales-api
```

---

## 📬 Endpoints Principais
- **POST** `/sale` - Registrar uma nova venda
- **POST** `/sale/webhook` - Atualizar status de pagamento
- **GET** `/veiculo/disponiveis` - Listar veículos disponíveis para venda
- **GET** `/veiculo/vendidos` - Listar veículos vendidos