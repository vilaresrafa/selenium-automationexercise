package com.exercicio.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement titleHeader;

    @FindBy(id = "id_gender1")
    private WebElement genderMrRadio;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement offersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTitleVisible() {
        return titleHeader.isDisplayed();
    }

    public void fillAccountInformation(String password, String day, String month, String year) {
        click(genderMrRadio);
        passwordInput.sendKeys(password);
        new Select(daysSelect).selectByValue(day);
        new Select(monthsSelect).selectByValue(month);
        new Select(yearsSelect).selectByValue(year);
        click(newsletterCheckbox);
        click(offersCheckbox);
    }

    public void fillAddressInformation(String firstName, String lastName, String company,
                                       String address, String address2, String country,
                                       String state, String city, String zipcode, String mobile) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        addressInput.sendKeys(address);
        address2Input.sendKeys(address2);
        new Select(countrySelect).selectByVisibleText(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobile);
        click(createAccountButton);
    }

    // Metodo auxiliar para clicar evitando bloqueios de anuncios
    private void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
