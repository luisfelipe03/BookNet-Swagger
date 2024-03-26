# BookNet API

## Tecnologias usadas no projeto

<img align="center" alt="Felipe-java" height="60" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg"> -
<img align="center" alt="Felipe-java" height="60" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg"> -
<img align="center" alt="Felipe-java" height="60" width="80" src="https://h2database.com/html/images/h2-logo-2.png" />


## Visão Geral
A API BookNet é um gerenciador de livros desenvolvido em Java com o framework Spring Boot e utiliza o banco de dados H2 para persistência de dados.

## Dependências

O projeto utiliza as seguintes dependências Maven:

- **spring-boot-starter-data-jpa**: Fornece suporte para persistência de dados com JPA (Java Persistence API).
- **spring-boot-starter-web**: Utilizado para criar aplicativos web usando o Spring MVC.
- **h2**: Banco de dados em tempo de execução utilizado para desenvolvimento e testes.
- **spring-boot-starter-test**: Dependência para testes unitários e de integração.

## Configurações do Projeto

- **Versão do Java**: 17
- **Plugin do Spring Boot Maven**: Configurado para empacotar o aplicativo como um JAR executável.

## Configuração do Banco de Dados H2

- **URL de Conexão**: `jdbc:h2:mem:booknetdb`
- **Driver JDBC**: `org.h2.Driver`
- **Usuário**: `sa`
- **Senha**: `password`

## Console do H2

- O console do H2 está habilitado.
- O console pode ser acessado em `/h2-console`.

## Modelos de Dados

### Livro

```java
@Entity
public class Livro {
    // Atributos e métodos do modelo Livro
}
```

### Avaliação

```java
@Entity
public class Avaliacao {
    // Atributos e métodos do modelo Avaliação
}
```

## Endpoints da API

A API BookNet oferece os seguintes endpoints para gerenciamento de livros:

- **Listar Livros**
  - Método: GET
  - URL: `/api/livros`
  - Descrição: Retorna uma lista de todos os livros cadastrados.

- **Buscar Livro por ID**
  - Método: GET
  - URL: `/api/livros/{id}`
  - Descrição: Retorna os detalhes de um livro específico com base no ID fornecido.

- **Cadastrar Livro**
  - Método: POST
  - URL: `/api/livros`
  - Descrição: Cadastra um novo livro no sistema.

- **Atualizar Livro**
  - Método: PATCH
  - URL: `/api/livros`
  - Descrição: Atualiza os detalhes de um livro existente.

- **Deletar Livro**
  - Método: DELETE
  - URL: `/api/livros/{id}`
  - Descrição: Exclui um livro existente com base no ID fornecido.

- **Avaliar Livro**
  - Método: POST
  - URL: `/api/livros/{id}/avaliar`
  - Descrição: Avalia um livro específico com base no ID fornecido.

- **Atualizar Avaliação**
  - Método: PATCH
  - URL: `/api/livros/{id}/avaliar`
  - Descrição: Atualiza a avaliação de um livro existente com base no ID fornecido.

- **Deletar Avaliação**
  - Método: DELETE
  - URL: `/api/livros/{id}/avaliar`
  - Descrição: Exclui a avaliação de um livro existente com base no ID fornecido.

## Como Executar o Projeto

1. Clone o repositório do projeto.
2. Navegue até o diretório raiz do projeto.
3. Execute o comando `mvn spring-boot:run` para iniciar o servidor.
