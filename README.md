# Atividade Prática - Testes com Selenium WebDriver

Este repositório contém a implementação dos testes automatizados ponta a ponta (End-to-End) para o site [Automation Exercise](https://automationexercise.com/), utilizando Java, Selenium WebDriver, JUnit 5 e o padrão Page Object Model (POM).

---

## Casos de Teste

### 1. Test Case 3: Login com e-mail e senha incorretos
- **Objetivo:** Verificar se a tentativa de login com credenciais incorretas falha e exibe a mensagem de erro: `"Your email or password is incorrect!"`.
- **Classe de Teste:** [`LoginIncorrectTest.java`](src/test/java/com/exercicio/selenium/tests/LoginIncorrectTest.java)

#### Particionamento em Classes de Equivalência e Análise de Valor Limite (5 Entradas)

| Método de Teste | Técnica Utilizada | E-mail de Entrada | Senha de Entrada | Descrição do Caso | Resultado Esperado |
|---|---|---|---|---|---|
| `testInvalidEmail` | Classes de Equivalência | `wrong_user_test@email.com` | `Password123!` | Usuário não cadastrado | Mensagem de erro exibida |
| `testShortPassword` | Análise de Valor Limite | `test_boundary@email.com` | `1` | Senha no limite mínimo (1 caractere) | Mensagem de erro exibida |
| `testSpecialCharsEmail` | Classes de Equivalência | `student+test.qa@email.com` | `WrongPassword99` | E-mail com sub-endereçamento (`+` e pontos) | Mensagem de erro exibida |
| `testLongEmail` | Análise de Valor Limite | `student_test_long_email_boundary_value_selenium@email.com` | `Password123` | E-mail longo no limite prático | Mensagem de erro exibida |
| `testUppercaseEmail` | Classes de Equivalência | `STUDENT_UPPERCASE@EMAIL.COM` | `Password123` | E-mail em letras maiúsculas | Mensagem de erro exibida |

---

### 2. Test Case 1: Registrar Usuário (Fluxo Completo)
- **Objetivo:** Executar o ciclo de vida completo de um novo usuário: cadastro inicial, preenchimento dos dados de conta e endereço, validação de conta criada, validação do usuário logado e posterior exclusão da conta.
- **Classe de Teste:** [`RegisterUserTest.java`](src/test/java/com/exercicio/selenium/tests/RegisterUserTest.java)

---

## Estrutura do Projeto (Page Object Model)

```
aulaselenium/
├── pom.xml
├── README.md
└── src/test/java/com/exercicio/selenium/
    ├── pages/
    │   ├── HomePage.java
    │   ├── SignupLoginPage.java
    │   ├── RegisterAccountPage.java
    │   └── AccountStatusPage.java
    └── tests/
        ├── BaseTest.java
        ├── LoginIncorrectTest.java
        └── RegisterUserTest.java
```

---

## Como Executar os Testes

Na raiz do projeto (`aulaselenium`), execute:

```bash
mvn test
```
