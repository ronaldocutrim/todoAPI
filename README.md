<h1 align="center">
  Todo API
</h1>


API para gerenciar tarefas (CRUD) que implementei para fazer a integração com
um [desafio de frontend do frontend mentor](https://www.frontendmentor.io/challenges/todo-app-Su1_KokOW )

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa/)
- [Spring Security](https://spring.io/projects/spring-security)
- [Postgres](https://www.postgresql.org/)
- [Flyway](https://flywaydb.org/)
- [Auth0 JWT](https://github.com/auth0/java-jwt)

## Práticas adotadas

- Consultas com filtros dinâmicos usando o `ExampleMatcher`
- Uso de DTOs para a API
- Injeção de Dependências
- [ ] Tratar erros

## Deploy

`AWS EC2`
`AWS RDS Postgres `
`Docker`

Foi criado um script que roda tudo que e necessário dentro de uma instancia do ec2 para rodar a aplicação
e pra ajudar no deploy criei scripts em um Makefile com essas rotinas de copia e de conexão com a estancia e de push da
imagem para o docker hub

Setup em produção

- Docker Instalado e autenticado
- AWS CLI Instalado e autenticado
- Atualizar o arquivo startup.example.sh com os devidos valores de produção e renomear o arquivo para startup.sh
- Atualizar o arquivo Makefile.example com os devidos valores de produção e renomear para Makefile
- Uma instancia no EC2
- Um banco de dados Postgres podendo ser no RDS
- Fazer o build do projeto com `mvn package` rodar o comando `Make deploy` para subir pro docker hub a imagem
- Rodar o comando `Make copy` para fazer a copia do setup.sh pra dentro a instancia
- Rodar o comando `Make connect` para conectar na instancia
- Rodar o comando ./startup.sh para subir o container da aplicação

Setup em ambiente de desenvolvimento precisara:

- Java 17+
- Postgres
- Atualizar `application.dev.properties` com as propriedades do JPA pra conexão
