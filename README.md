# MVC RH

Aplicação MVC de Recursos Humanos para fins didáticos

## Setup e Uso

### Execução / Local dev

#### Terminal

```sh
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

#### [H2 Web UI](http://localhost:8080/h2-console)

> - *url*: jdbc:h2:mem:testdb
> - *usuário*: sa
> - *senha*: password

![](assets/images/h2-console.png)

## Arquitetura

### MER

![](assets/docs/src/mer/mer.svg)

## Java

> [Spring Initializr](https://start.spring.io/) - Criar aplicação conforme a configuração 

### Spring Boot - Configuração

![](assets/images/spring.png)

## Referencias

 - https://spring.io/projects/spring-framework
 - https://plantuml.com/