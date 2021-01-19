package com.nextBaseCrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory3 {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){ //pre-condition
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://login2.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing25@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@name='USER_REMEMBER']")).click();
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
    }

    @Test
    public void test() throws InterruptedException {
        WebElement searchButton = driver.findElement(By.xpath("//input[@class='header-search-input']"));
        Thread.sleep(3000);
        searchButton.sendKeys("calendar");
        Thread.sleep(3000);
        searchButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }

    @AfterClass
    public void teardown(){
       driver.close();
    }
}
/*
User Story:
3. As a user, I should be able to search people,
document and more from search box
Acceptance Criteria:
1. Verify users can search a valid info from search box. (employee, doc, post, etc)
2. Verify users get menu item and suggested modules when they type in the box.
 */