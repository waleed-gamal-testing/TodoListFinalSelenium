package com.qacart.todo.testcases;

import com.github.javafaker.Faker;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.utils.UsersUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
@Feature("Auth Feature")
public class RegisterTest extends BaseTest {
    @Story("SignUp Test Case")
    @Test(description = "register using fake data")
    public void registerWithValidCredentials() throws IOException {
        String firstNameRegister = UsersUtils.generateRandomNewUserForRegister().getFirstName();
        String lastNameRegister = UsersUtils.generateRandomNewUserForRegister().getLastName();
        String emailRegister =UsersUtils.generateRandomNewUserForRegister().getEmail();
        String passwordRegister =UsersUtils.generateRandomNewUserForRegister().getPassword();
        String confirmPasswordRegister =UsersUtils.generateRandomNewUserForRegister().getConfirmPassword();

        RegisterPage registerPage =new RegisterPage(getDriver());
        try {
            String actualMsgWhenRegistered = registerPage
                    .load()
                    .addValidDataInSignUpForm(firstNameRegister,lastNameRegister,emailRegister,passwordRegister,confirmPasswordRegister)
                    .validateWelcomeMsgWhenRegistered().toLowerCase();
            String expectedWelcomeMsg =firstNameRegister.toLowerCase(Locale.ROOT);
            Assert.assertTrue(actualMsgWhenRegistered.contains(expectedWelcomeMsg));

        } catch (IOException e) {
            throw new RuntimeException("register not correct");
        }
    }
}
