package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Feature("Todo Item")
public class DeleteTodoItemIndependentTest extends BaseTest {
    @Story("Delete Todo Item")
    @Test(description = "Delete todo item that not depend on user state or app state dynamically using API ")
    public void checkAbleToDeleteTodoTask2() throws IOException, InterruptedException {
        //adding task using API
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());
        TodoPage todoPage = new TodoPage(getDriver()); //sending driver to LoginPage
        todoPage.load();
        injectCookiesToBrowsers(registerApi.getRestAssuredCookeies());
        String actualMsg = todoPage // not depend add todo from user and not depending on login page
                .load()
                .clickOnTodoLinkInNavBar()
                .clickOnDeleteBtn()
                .checkNoTodoItemsWhenDelete();
        String expectedResult = "No Available Todos";
        Assert.assertEquals(actualMsg,expectedResult,"assertion for delete todo item");
    }
}


