package com.exercicio.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "img[alt='Website for automation practice']")
    private WebElement logo;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAsText;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://automationexercise.com");
    }

    public boolean isHomeVisible() {
        return logo.isDisplayed();
    }

    public void clickSignupLogin() {
        click(signupLoginLink);
    }

    public boolean isLoggedInAs(String username) {
        return loggedInAsText.getText().contains(username);
    }

    public void clickDeleteAccount() {
        click(deleteAccountLink);
    }

    // Metodo auxiliar para clicar evitando bloqueios de anuncios
    private void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
