package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.Cookies;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Feature("Todo Item")
public class AddTodoCookiesTest extends BaseTest {
    @Description("it will be able to add items or todo tasks but without depending on user or App state using Api and access token")
    @Story("Add Todo")
    @Test(description = "adding todo item that depend on Api not ui")
    public void addTodoItem() throws IOException, InterruptedException {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
         //add all cookies to browserbut we need it after load a page
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        Cookies restAssuredCookies = registerApi.getRestAssuredCookeies();
        newTodoPage.load(); /* get url of todo page direct but maybe all cookies was removed */
        injectCookiesToBrowsers(restAssuredCookies); // add all cookies to browser

        String actualResult =
                          newTodoPage
                         .load()  // 2 times of load todo page >> refresh for page to use cookies to login by user id , access token
                         .clickOnTodoLinkInNavBar()
                         .clickOnAddBtn()
                         .addTodoItems("learn selenium")
                         .clickOnSubmitBtn()
                         .validateTextInTodoBox();
        String expectedResult = "learn selenium";
        Assert.assertEquals(actualResult, expectedResult, "assert that todo item is added successfully");

        // max 3 ui steps for each test case  >> more ui actions >> more flakeness in tests
        // dynamic test which is independent of app state which is login passes using API  not UI dynamically
        /*  builder pattern design used to move from method to another method by using one object like chain
        to use this you have to add return this to each method to link it to other methods   */
    }
}
