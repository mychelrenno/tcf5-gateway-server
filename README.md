# TCF5 Gateway Server

## Descrição

O **TCF5 Gateway Server** é um servidor de gateway baseado no Spring Cloud Gateway, projetado para atuar como ponto de entrada único para os microsserviços do projeto TCF5. Ele gerencia o roteamento de requisições para os serviços downstream, incluindo autenticação, descoberta de serviços via Eureka e filtros de segurança.

## Funcionalidades

- **Roteamento Dinâmico**: Roteia requisições para serviços como `tcf5-auth-server`, `tcf5-health-record-producer`, `tcf5-health-record-transformer` e `tcf5-health-record-provider` com base em caminhos específicos.
- **Descoberta de Serviços**: Integração com Eureka para descoberta automática de instâncias de serviço.
- **Autenticação**: Filtro de autenticação para proteger rotas sensíveis.
- **Balanceamento de Carga**: Usa `lb://` para balanceamento de carga entre instâncias de serviço.

## Arquitetura

O gateway serve como um proxy reverso, interceptando requisições HTTP e direcionando-as para os microsserviços apropriados. Ele inclui:

- **AuthenticationFilter**: Verifica tokens de autenticação para rotas protegidas.
- **AuthClient**: Cliente para comunicação com o servidor de autenticação.
- **ClientConfig**: Configuração para clientes HTTP.

## Pré-requisitos

- Java 11 ou superior
- Maven 3.6 ou superior
- Eureka Server rodando (padrão: http://localhost:8761/eureka/)

## Como Executar

1. Clone o repositório:
   ```
   git clone <url-do-repositorio>
   cd tcf5-gateway-server
   ```

2. Execute o projeto:
   ```
   ./mvnw spring-boot:run
   ```
   Ou usando Maven:
   ```
   mvn spring-boot:run
   ```

3. O servidor estará disponível em `http://localhost:8080`.

## Configuração

A configuração principal está no arquivo `src/main/resources/application.yaml`. Principais configurações:

- **Porta do Servidor**: 8080
- **Serviços**:
  - `auth-server`: URL base para o servidor de autenticação
- **Rotas do Gateway**:
  - `/auth/**` → `tcf5-auth-server`
  - `/health-record-producer/**` → `tcf5-health-record-producer`
  - `/health-record-transformer/**` → `tcf5-health-record-transformer`
  - `/health-record-provider/**` → `tcf5-health-record-provider`
- **Eureka**: Cliente configurado para registrar no Eureka Server em `http://localhost:8761/eureka/`
- **Logging**: Níveis de log DEBUG/TRACE para componentes do Gateway

## Estrutura do Projeto

```
tcf5-gateway-server/
├── src/
│   ├── main/
│   │   ├── java/com/devrenno/tcf5/gateway/
│   │   │   ├── Application.java          # Classe principal Spring Boot
│   │   │   ├── auth/
│   │   │   │   ├── AuthClient.java       # Cliente para autenticação
│   │   │   │   ├── AuthenticationFilter.java # Filtro de autenticação
│   │   │   │   └── ClientConfig.java     # Configuração de cliente
│   │   └── resources/
│   │       └── application.yaml          # Configurações
│   └── test/
│       └── java/com/devrenno/tcf5/gateway/
│           └── ApplicationTests.java     # Testes unitários
├── pom.xml                               # Dependências Maven
├── mvnw                                  # Wrapper Maven
└── HELP.md                               # Documentação adicional
```

## Dependências

- Spring Boot
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka Client
- Outras dependências definidas no `pom.xml`

## Testes

Execute os testes com:
```
./mvnw test
```

## Contribuição

Para contribuir:
1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está sob a licença [MIT](LICENSE). # Substitua pela licença apropriada se houver.

## Contato

Para dúvidas ou sugestões, entre em contato com a equipe de desenvolvimento.
