# Projeto CP Java Advanced

## Requisitos para rodar o projeto

Antes de iniciar o projeto, certifique-se de ter as seguintes dependências instaladas:

- **Java 17** (Oracle JDK 17)
- **Apache Maven 3.6.3**
- **MySQL Server 8.0**
- **IntelliJ IDEA** (ou outra IDE compatível com Java e Spring Boot)

## Configuração do Ambiente

### 1. Configurar as variáveis de ambiente

Certifique-se de configurar as seguintes variáveis no seu sistema:

- `JAVA_HOME`: Deve apontar para o diretório do JDK 17.
- `M2_HOME`: Deve apontar para o diretório do Maven.
- `Path`: Adicione os caminhos `JAVA_HOME/bin` e `M2_HOME/bin`.

Para verificar se as configurações estão corretas, execute os comandos abaixo no terminal:

```sh
java -version
mvn -version
```

Se as versões exibidas forem compatíveis, a configuração está correta.

### 2. Configuração do Banco de Dados MySQL

O projeto utiliza um banco de dados MySQL. Antes de rodar o projeto, crie o banco de dados e configure as credenciais no arquivo `application.properties`.

```sql
CREATE DATABASE cp_java_advanced;
```

No arquivo `src/main/resources/application.properties`, configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cp_java_advanced
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

## Como Rodar o Projeto

### 1. Clonar o repositório

```sh
git clone https://github.com/luizalec7/CP_java_advanced.git
cd cp-java-advanced
```

### 2. Compilar e instalar as dependências

```sh
mvn clean install
```

### 3. Rodar o projeto via Maven

```sh
mvn spring-boot:run
```

### 4. Rodar o projeto via IntelliJ IDEA

1. Abra o IntelliJ IDEA
2. Importe o projeto como um projeto Maven
3. Verifique se o JDK 17 está configurado corretamente
4. Vá até a classe principal `MeuProjetoApplication.java`
5. Clique no botão de **Run** (Executar)

## Testando os Endpoints

### 1. Testar o GET dos produtos

```sh
GET http://localhost:8080/produtos
```

### 2. Criar um novo produto via POST

Abra o Postman ou outra ferramenta de testes de API e envie uma requisição **POST** para:

```sh
POST http://localhost:8080/produtos/salvar
Content-Type: application/json
```

Com o seguinte JSON no corpo da requisição:

```json
{
  "nome": "Produto Teste",
  "descricao": "Este é um produto de teste",
  "preco": 99.90,
  "telefone": "(11) 99999-9999",
  "dataCadastro": "2025-03-13"
}
```

Se a requisição for bem-sucedida, o produto será salvo no banco de dados.

## Possíveis Erros e Soluções

### Erro de versão do Java

Se ao rodar o projeto ocorrer um erro como:

```sh
class file has wrong version 61.0, should be 52.0
```

Isso significa que você está tentando rodar uma versão incompatível do Java. Certifique-se de que a versão do JDK 17 está corretamente configurada e ativada no terminal.

```sh
java -version
```

Caso ainda haja problemas, defina o JDK correto no IntelliJ IDEA em **File > Project Structure > SDK**.

### Erro de conexão com o banco de dados

Se aparecer um erro como:

```sh
Cannot create PoolableConnectionFactory
```

Verifique se o MySQL está rodando e se as credenciais no `application.properties` estão corretas.

## Integrantes do projeto

1. Luiz Alecsander Viana (RM553034)
2. Guilherme Augusto de Oliveira (RM554176)
