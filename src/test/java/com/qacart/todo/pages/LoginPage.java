package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage {
    //constructor  >> used to receive driver from loginTest inherit from BasePage
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElement emailField ;

    @FindBy(xpath = "//input[@data-testid=\"password\"]")
    private WebElement passwordField ;

    @FindBy(xpath = "//button[@data-testid=\"submit\"]")
    private WebElement loginBtn ;



    //Actions
    @Step("load login page url directly")
    public LoginPage loadPage() throws IOException {
      /* Properties props = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
        driver.get(props.getProperty("baseUrl"));*/

       driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this ;  // >> BUILDER PATTERN DESIGN >> to use object from this class one time only
    }
    @Step
    public TodoPage validLogin(String email , String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new TodoPage(driver);
    }


}

