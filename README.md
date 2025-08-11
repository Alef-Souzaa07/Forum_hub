📌 Fórum Hub – API REST com Autenticação JWT
Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar tópicos de fórum, com autenticação segura utilizando JWT (JSON Web Token).
A aplicação permite criar, listar e gerenciar tópicos, além de proteger rotas através de autenticação e autorização baseada em tokens.
🚀 Tecnologias Utilizadas
Backend
Java 21+ – Linguagem principal.

Spring Boot 3.5.4 – Framework para criação da API REST.

Spring Web – Criação e exposição de endpoints RESTful.

Spring Data JPA – Mapeamento objeto-relacional (ORM) e acesso ao banco de dados.

Spring Security – Gerenciamento de autenticação e autorização.

JWT (io.jsonwebtoken) – Implementação de autenticação stateless com tokens.

Spring Validation – Validação de dados recebidos na API.

Lombok – Redução de código boilerplate (getters, setters, construtores, etc).

Flyway – Controle e versionamento de migrações de banco de dados.

Spring Boot DevTools – Ferramentas para desenvolvimento e recarga automática.

Banco de Dados
MySQL – Banco de dados relacional para persistência dos dados.

MySQL Connector/J – Driver JDBC para comunicação com o MySQL.

Testes
JUnit 5 – Testes unitários e de integração.

Spring Security Test – Utilitários para testar endpoints protegidos.

⚙️ Como Executar o Projeto
Pré-requisitos
Java 21+

Maven 3.9+

MySQL 8+

📌 Endpoints Principais
Autenticação
POST /auth/login – Realiza login e retorna token JWT.

Tópicos
GET /topicos – Lista todos os tópicos.

POST /topicos – Cria um novo tópico (necessita token JWT).

GET /topicos/{id} – Detalha um tópico.

PUT /topicos/{id} – Atualiza um tópico.

DELETE /topicos/{id} – Remove um tópico.

Configuração

application.properties: Configura a aplicação, incluindo os detalhes de conexão com o banco de dados MySQL, configurações de JPA para ddl-auto (update) e desabilitando o Flyway para gerenciamento de esquema. Ele também define a propriedade server.error.include-stacktrace como never.
Tratamento de Erros (error package):

TratadorDeExcecoes.java: Um manipulador de exceções global que usa @ControllerAdvice para gerenciar exceções em toda a aplicação. Inclui um manipulador para RegistroDuplicadoException que retorna um status HTTP BAD_REQUEST com a mensagem da exceção.

RegistroDuplicadoException.java: Uma exceção de tempo de execução personalizada usada para indicar que um registro já existe. 
