package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Feature("Todo Item")
public class DependOnUserStateDeleteTodoTest extends BaseTest {
    @Story("Delete Todo Item")
    @Test(description = "Delete todo item that depend on user state or app state manually adding task")
    public void checkAbleToDeleteTodoTask() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());  //sending driver to LoginPage
        String actualMsg =
                loginPage
                        .loadPage()
                        .validLogin(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getpassword())
                        .clickOnAddBtn().addTodoItems("learn selenium")
                        .clickOnSubmitBtn()
                        .clickOnDeleteBtn()
                        .checkNoTodoItemsWhenDelete();
       /* builder pattern design used to move from method to another method by using one object like chain
        to use this you have to add return this to each method to link it to other methods */
        String expectedResult = "No Available Todos";
        Assert.assertEquals(actualMsg, expectedResult, "assertion for delete todo item");


    }
}