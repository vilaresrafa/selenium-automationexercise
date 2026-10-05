package com.exercicio.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountStatusPage {

    private WebDriver driver;

    @FindBy(xpath = "//b[contains(text(), 'Account Created!')]")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//b[contains(text(), 'Account Deleted!')]")
    private WebElement accountDeletedText;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    public AccountStatusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountCreatedVisible() {
        return accountCreatedText.isDisplayed();
    }

    public boolean isAccountDeletedVisible() {
        return accountDeletedText.isDisplayed();
    }

    public void clickContinue() {
        click(continueButton);
    }

    // Metodo auxiliar para clicar evitando bloqueios de anuncios
    private void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
