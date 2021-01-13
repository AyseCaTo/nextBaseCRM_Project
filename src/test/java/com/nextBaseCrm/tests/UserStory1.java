package com.nextBaseCrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class UserStory1 {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        //1. Open Browser
        //2. Go to website: "http://login2.nextbasecrm.com/"
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://login2.nextbasecrm.com/");
    }

    @Test
    public void test1() throws InterruptedException {
        //Enter username
        //Enter password
        //Click "Remember me on this computer" option
        //Click "login" button
        //Click "Logout" button

        ArrayList<String> listOfUserName = new ArrayList<>(Arrays.asList("helpdesk25@cybertekschool.com", "helpdesk26@cybertekschool.com"
                ,"marketing25@cybertekschool.com", "marketing26@cybertekschool.com", "hr25@cybertekschool.com", "hr26@cybertekschool.com"));

        String password = "UserUser";

        for (String eachUserName : listOfUserName){
            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(eachUserName);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@name='USER_REMEMBER']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@class='login-btn']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@onclick='showUserMenu()']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[.='Log out']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();
        }

    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']")).click();
        Thread.sleep(3000);

        String expectedTitle = "Get Password";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle, "It's up to you");
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }

}
/*
User Story:
1. As a user, I should be able to login to the app
Acceptance Criteria
"1. Verify users can login
2. verify users can check ""Remember me on this computer"" option
3. Verify users can access to ""FORGOT YOUR PASSWORD?"" link page
"
 */

