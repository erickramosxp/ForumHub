﻿#      <p align=center> ForumHub API </p>

<div align = center>
    <img width="500px" src="https://i.imgur.com/nSTSUOj.png">
</div>

## Descrição

A Forum API é uma aplicação back-end, desenvolvida em Java com Spring Boot, que fornece a base para a criação de um fórum online. A API permite a gestão de usuários, tópicos e respostas, além de oferecer autenticação segura através do Auth0.

## Funcionalidades Principais

## Usuários:

- Cadastro de novos usuários
- Listagem de todos os usuários
- Detalhamento de um usuário específico
- Autenticação
- Criptografia de senhas com Bcrypt

## Tópicos:

- Criação de novos tópicos
- Listagem de todos os tópicos
- Detalhamento de um tópico específico
- Atualização de tópicos existentes

## Respostas:

- Inserção de respostas em tópicos
- Listagem de respostas de um tópico específico
- Detalhamento de uma resposta específica (pelo ID do tópico e da resposta)

# Tecnologias Utilizadas

```
Linguagem: Java
Framework: Spring Boot
Banco de Dados: MySQL
Gerenciamento de Migrações: Spring Boot Migrations
Documentação da API: Swagger (OpenAPI 3.0)
Autenticação: Auth0
Criptografia: Bcrypt

```
## Como Executar o Projeto

## Pré-requisitos:
```
Java JDK 17 ou superior
MySQL instalado e configurado
```
## Configurar o projeto:
```
Clone o repositório: git clone [link do repositório]
Configure as credenciais do MySQL no arquivo application.properties
```
## Executar o projeto:
```
Abra o projeto em sua IDE favorita (ex: IntelliJ, Eclipse)
Execute a classe principal da aplicação Spring Boot
```
## Documentação da API

A documentação completa da API, incluindo detalhes sobre os endpoints, parâmetros e exemplos de requisição/resposta, está disponível através da interface do Swagger:

Acesse http://localhost:8080/swagger-ui.html após executar a aplicação.



## Contribuição

- Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Contato
<a style="margin-left:15px; font-size:20px; font-weight:bolder; text-decoration:none; border-radius:5px; background:#001;  padding:5px; border: solid 1px black; color:#ddf" href="https://www.linkedin.com/in/erickramossilva/">Linkedin</a>
## Observações

Certifique-se de ter o MySQL configurado corretamente antes de executar o projeto.
A documentação do Swagger fornece informações detalhadas sobre o uso da API.
