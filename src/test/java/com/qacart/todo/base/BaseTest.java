package com.qacart.todo.base;

import com.qacart.todo.driver.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //declaration WebDriver in this class

    public WebDriver getDriver() {
        return this.driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @BeforeMethod
    public void setup()
    {
        WebDriver driver = new DriverFactory().initialixeDriver();
        setDriver(driver);
    }
    @AfterMethod
    public void tearDown(ITestResult result)
    {
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target"+File.separator+"screenshots"+File.separator+testCaseName+".png"); //name of file is dynamic depend on name of test case
       takeScreenShot(destFile);
        getDriver().quit();
    }
    //convert restAssured cookies to selenium cookiestoable to add it to Browser automatically
    public void injectCookiesToBrowsers(Cookies restAssuredCookies)
    {
        List<org.openqa.selenium.Cookie>seleniumCookies=CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies.asList());
        for (org.openqa.selenium.Cookie cookie : seleniumCookies)
        {
            getDriver().manage().addCookie(cookie);
        }
    }
    public void takeScreenShot(File destFile)
    {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(file ,destFile);
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshots",is);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
