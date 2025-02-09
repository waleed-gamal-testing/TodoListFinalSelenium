package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    /*
    * any Test Class should start with @Test then function of each test
    * */
    @Story("Login Test Case")
    @Test(description = "Test the login functionality using email and password and click on submit btn")
    public void shouldBeAbleLoginWithEmailAndPassword() throws IOException {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        LoginPage loginPage = new LoginPage(getDriver());  //sending driver to LoginPage  //declare object one time >> builder pattern design
        boolean welomeMsgIsDisplayed =
                 loginPage
                .loadPage()
                .validLogin(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getpassword())
                .validateWelcomeMsg();
        Assert.assertTrue(welomeMsgIsDisplayed);
         /*
        builder pattern design used to move from method to another method by using one object like chain
        to use this you have to add return this to each method to link it to other methods
        * */




    }
}
