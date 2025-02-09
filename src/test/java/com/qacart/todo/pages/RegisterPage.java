package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class RegisterPage extends BasePage {
    //constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-testid=\"first-name\"]")
    private WebElement firstNameElement;

    @FindBy(xpath = "//input[@data-testid=\"last-name\"]")
    private WebElement lastNameElement;

    @FindBy(xpath = "//input[@data-testid=\"email\"]")
    private WebElement emailElement;

    @FindBy(xpath = "//input[@data-testid=\"password\"]")
    private WebElement passwordElement;

    @FindBy(xpath = "//input[@data-testid=\"confirm-password\"]")
    private WebElement confirmPasswordElement;

    @FindBy(xpath = "//span[@class=\"MuiButton-label\"]")
    private WebElement signUpBtn ;

    @FindBy(xpath = "//a[@class=\"sc-bZkfAO ljiFAW\"][3]")
    private WebElement signUpLinkInNavBar ;
    //Actions
    @Step
    public RegisterPage load() throws IOException {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.SIGNUP_PAGE_ENDPOINT);
        signUpLinkInNavBar.click();
        return this ;
    }
    @Step
    public TodoPage addValidDataInSignUpForm(String firstName , String lastName , String email , String password , String confirmPassword)
    {
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(confirmPassword);
        signUpBtn.click();
        return new TodoPage(driver);
    }
}
