package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class NewTodoPage extends BasePage {
    //constructor
    public NewTodoPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//input[@data-testid=\"new-todo\"]")
    private WebElement textArea ;

    @FindBy(xpath = "//button[@data-testid=\"submit-newTask\"]")
    private WebElement submitBtn ;

    @FindBy(xpath = "//h2[@data-testid=\"back\"]")
    private WebElement backLinkText ;
    @FindBy(xpath = "//a[@class=\"sc-bZkfAO ljiFAW\"][2]")
    private WebElement todoLinkOnNavBar ;

    //Actions
    @Step
    public NewTodoPage addTodoItems (String todoItem) throws InterruptedException {
        Thread.sleep(1500);
        textArea.sendKeys(todoItem);
        Thread.sleep(1500);
        return this;

    }
    @Step
    public TodoPage clickOnSubmitBtn()
    {
        submitBtn.click();
        return new TodoPage(driver);
    }
   /* public TodoPage clickOnBackLinkText()
    {
        backLinkText.click();
        return new TodoPage(driver);
    }*/
    @Step
    public NewTodoPage load() throws IOException {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_PAGE_ENDPOINT);
        return this ;
    }
    @Step
    public TodoPage clickOnTodoLinkInNavBar ()
    {
        todoLinkOnNavBar.click();
        return new TodoPage(driver) ;
    }
}
