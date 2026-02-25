

🏛️ ForumHub API
Status do Projeto: Concluído ✅ (Challenge Alura - ForumHub)

O ForumHub é uma API REST robusta que simula o backend de um fórum de discussões. O sistema permite o gerenciamento completo de tópicos, garantindo que apenas usuários autenticados e com as devidas permissões possam interagir com a plataforma.

🎯 Objetivo
O desafio consistia em replicar o comportamento de um fórum, focando em:

Persistência de dados com validações complexas.

Segurança avançada utilizando autenticação Stateless.

Organização de permissões (RBAC - Role Based Access Control).

🛠️ Stack Tecnológica
Linguagem: Java 25 (OpenJDK)

Framework: Spring Boot 4.0.3

Segurança: Spring Security + Auth0 JSON Web Token

Banco de Dados: MySQL 8.0

Versionamento de Banco: Flyway Migration

Documentação/Auxiliares: Lombok & Jakarta Validation

🔐 Camada de Segurança
A API implementa um fluxo de segurança rigoroso:

Autenticação JWT: O usuário realiza login e recebe um token assinado.

Proteção de Endpoints: A configuração foi definida para que apenas usuários com a Role ADMIN acessem os recursos do fórum após o login.

Criptografia: Senhas são armazenadas utilizando o algoritmo BCrypt, garantindo que nem mesmo o administrador do banco de dados tenha acesso às credenciais originais.

