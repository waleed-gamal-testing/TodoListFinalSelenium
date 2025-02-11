package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class TodoPage extends BasePage {
    //constructor
    public TodoPage(WebDriver driver)
    {
        super(driver);
    }
    //locators
    @FindBy(xpath = "//*[@data-testid=\"add\"]")
    private WebElement textBoxAddBtn ;

    @FindBy(xpath = "//h2[@data-testid=\"welcome\"]")
    private WebElement welcomeMsg ;

    @FindBy(xpath = "//h4[@data-testid=\"no-todos\"]")
   private WebElement noTodoMsg ;

    @FindBy(xpath = "//h2[@data-testid=\"todo-text\"]")
    private WebElement todoText ;


    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    private WebElement checkBox ;

    @FindBy(xpath = "//button[@data-testid=\"delete\"]")
    private WebElement deleteBtn ;
    @FindBy(xpath = "//a[@class=\"sc-bZkfAO ljiFAW\"][2]")
    private WebElement todoLinkOnNavBar ;

    //Actioopns
    @Step
    public boolean validateWelcomeMsg()
    {
       return  welcomeMsg.isDisplayed();
    }
    @Step
    public NewTodoPage clickOnAddBtn()
    {
        textBoxAddBtn.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String validateTextInTodoBox()
    {
        return todoText.getText();
    }
    @Step
    public boolean validateFunctionalityOfCheckBox()
    {
        return  checkBox.isEnabled();
    }
    @Step
    public TodoPage clickOnDeleteBtn()
    {
        deleteBtn.click();
        return this;
    }
    @Step
    public String checkNoTodoItemsWhenDelete()
    {
        return noTodoMsg.getText();
    }
    @Step
    public TodoPage load() throws IOException {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_PAGE_ENDPOINT);
        return this;

    }
    @Step
    public TodoPage clickOnTodoLinkInNavBar ()
    {
        todoLinkOnNavBar.click();
        return this ;
    }
    @Step
    public String validateWelcomeMsgWhenRegistered()
    {
       return welcomeMsg.getText();
    }


}
