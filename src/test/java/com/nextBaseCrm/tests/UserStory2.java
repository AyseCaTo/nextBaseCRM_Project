package com.nextBaseCrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory2 {

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
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click(); // message button
        Thread.sleep(2000);
        //iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("/html/body")).sendKeys("Hello everybody!!!");
        driver.switchTo().parentFrame();


        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']")).click();
        Thread.sleep(2000);
        //Assert.assertFalse(sendButton.isDisplayed(), "You are able send message!");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']")).sendKeys("http://www.amazon.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='adm-btn-save']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();
        Thread.sleep(2000);

    }



    @AfterClass
    public void teardown(){
        driver.close();
    }


}
/*
User Story:
2. As a user, I should be able to send message.
Acceptance Criteria
1. Verify users can send message by clicking ""MESSAGE"" tab
2. Verify users can cancel message.
3. Verify users can attach link by clicking on the link icon.
 */