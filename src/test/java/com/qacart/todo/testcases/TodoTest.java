package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.Cookies;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Feature("Todo Item")
public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Test
    public void addTodoItem() throws IOException, InterruptedException {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        Cookies restAssuredCookies = registerApi.getRestAssuredCookeies();
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        TodoPage todoPage = new TodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowsers(restAssuredCookies);
         //sending driver to LoginPage
       String actualResult =  newTodoPage
                .load()
                .clickOnTodoLinkInNavBar()
                .clickOnAddBtn()
                .addTodoItems("learn selenium")
                .clickOnSubmitBtn()
                .validateTextInTodoBox();
        String expectedResult = "learn selenium";
        Assert.assertEquals(actualResult,expectedResult,"assert that todo item is added successfully");
        /*
        builder pattern design used to move from method to another method by using one object like chain
        to use this you have to add return this to each method to link it to other methods
        * */
    }
}
