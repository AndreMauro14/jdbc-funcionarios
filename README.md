# Primeiro Projeto Java com JDBC e MySQL

Este repositório contém três classes Java que, juntas, formam meu primeiro exercício usando JDBC para conectar uma aplicação Java a um banco de dados MySQL. O objetivo foi criar um fluxo simples de cadastro para praticar conexão, prepared statements e fechamento seguro de recursos.

## Visão Geral

- O programa lê dados via terminal (nome, email, data de nascimento, salário e id do departamento) e faz um INSERT na tabela `seller` utilizando `PreparedStatement`, evitando SQL injection básico.
- A conexão é configurada por um arquivo `db.properties` e gerenciada por uma classe utilitária que abre e fecha recursos (`Connection`, `Statement`, `ResultSet`).

## Estrutura do Projeto

- `application/Programa`: ponto de entrada; coleta dados com `Scanner`, formata a data (`SimpleDateFormat`) e executa o INSERT usando JDBC.
- `db/DB`: carrega `db.properties`, cria a conexão via `DriverManager` e fornece métodos para fechar `Statement`, `ResultSet` e a própria conexão.
- `db/DbException`: exceção personalizada (runtime) para padronizar o tratamento de erros de banco e facilitar o diagnóstico.

## O que aprendi

- Configurar o MySQL Connector/J (JDBC) e abrir conexões usando `DriverManager` com URL e propriedades.
- Executar inserções com `PreparedStatement`, mapear tipos Java ↔ SQL (incluindo `java.util.Date` → `java.sql.Date`) e interpretar a contagem de linhas afetadas.
- Boas práticas: externalizar credenciais em `db.properties`, fechar recursos em `finally`/utilitários e centralizar erros com exceções personalizadas.

## Por que este projeto

Este é meu primeiro código unindo Java + JDBC + MySQL. Mantive o exemplo “simples” para praticar fundamentos antes de evoluir para um CRUD completo, camadas (DAO/Service) e testes automatizados.

