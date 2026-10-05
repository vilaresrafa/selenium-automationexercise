package com.exercicio.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.exercicio.selenium.pages.HomePage;
import com.exercicio.selenium.pages.SignupLoginPage;

public class LoginIncorrectTest extends BaseTest {

    private final String EXPECTED_ERROR = "Your email or password is incorrect!";

    // Metodo auxiliar para executar o cenario de login incorreto
    private void loginWithBadCredentials(String email, String password) {
        HomePage home = new HomePage(driver);
        home.open();
        assertTrue(home.isHomeVisible());

        home.clickSignupLogin();

        SignupLoginPage loginPage = new SignupLoginPage(driver);
        assertTrue(loginPage.isLoginHeaderVisible());

        loginPage.login(email, password);

        assertEquals(EXPECTED_ERROR, loginPage.getErrorMessage());
    }

    // 1. Particionamento em Classes de Equivalencia: usuario nao cadastrado
    @Test
    public void testInvalidEmail() {
        loginWithBadCredentials("wrong_user_test@email.com", "Password123!");
    }

    // 2. Analise de Valor Limite: senha com tamanho minimo (1 caractere)
    @Test
    public void testShortPassword() {
        loginWithBadCredentials("test_boundary@email.com", "1");
    }

    // 3. Particionamento em Classes de Equivalencia: e-mail com caracteres especiais (+ e pontos)
    @Test
    public void testSpecialCharsEmail() {
        loginWithBadCredentials("student+test.qa@email.com", "WrongPassword99");
    }

    // 4. Analise de Valor Limite: e-mail longo no limite pratico de caracteres
    @Test
    public void testLongEmail() {
        loginWithBadCredentials("student_test_long_email_boundary_value_selenium@email.com", "Password123");
    }

    // 5. Particionamento em Classes de Equivalencia: e-mail totalmente em maiusculas
    @Test
    public void testUppercaseEmail() {
        loginWithBadCredentials("STUDENT_UPPERCASE@EMAIL.COM", "Password123");
    }
}
