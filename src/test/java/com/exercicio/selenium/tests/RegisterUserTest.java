package com.exercicio.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.exercicio.selenium.pages.AccountStatusPage;
import com.exercicio.selenium.pages.HomePage;
import com.exercicio.selenium.pages.RegisterAccountPage;
import com.exercicio.selenium.pages.SignupLoginPage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void testRegisterAndDeleteUser() {
        String name = "Student User";
        String email = "student_" + System.currentTimeMillis() + "@test.com";

        // 1 e 2. Abrir o navegador e acessar a URL
        HomePage home = new HomePage(driver);
        home.open();

        // 3. Verificar se a pagina inicial carregou com sucesso
        assertTrue(home.isHomeVisible());

        // 4. Clicar no botao 'Signup / Login'
        home.clickSignupLogin();

        // 5. Verificar se 'New User Signup!' esta visivel
        SignupLoginPage loginPage = new SignupLoginPage(driver);
        assertTrue(loginPage.isSignupHeaderVisible());

        // 6 e 7. Preencher nome e e-mail, depois clicar em 'Signup'
        loginPage.signup(name, email);

        // 8. Verificar se 'ENTER ACCOUNT INFORMATION' esta visivel
        RegisterAccountPage registerPage = new RegisterAccountPage(driver);
        assertTrue(registerPage.isTitleVisible());

        // 9, 10 e 11. Preencher informacoes da conta e marcar as caixas de selecao
        registerPage.fillAccountInformation("SecretPass123!", "15", "8", "1998");

        // 12 e 13. Preencher dados de endereco e clicar no botao 'Create Account'
        registerPage.fillAddressInformation(
            "Student",
            "Test",
            "UFF",
            "Rua Passo da Patria 156",
            "Bloco E",
            "Canada",
            "Ontario",
            "Toronto",
            "M5H2N2",
            "1234567890"
        );

        // 14 e 15. Verificar se 'ACCOUNT CREATED!' esta visivel e clicar em 'Continue'
        AccountStatusPage statusPage = new AccountStatusPage(driver);
        assertTrue(statusPage.isAccountCreatedVisible());
        statusPage.clickContinue();

        // 16. Verificar se 'Logged in as username' esta visivel
        assertTrue(home.isLoggedInAs(name));

        // 17. Clicar no botao 'Delete Account'
        home.clickDeleteAccount();

        // 18. Verificar se 'ACCOUNT DELETED!' esta visivel e clicar em 'Continue'
        assertTrue(statusPage.isAccountDeletedVisible());
        statusPage.clickContinue();
    }
}
