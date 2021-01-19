package com.nextBaseCrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory4 {

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
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']")).click();
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("/html/body")).clear();
        driver.findElement(By.xpath("/html/body")).sendKeys("Good morning everyone!!!");
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//input[@id='question_0']")).sendKeys("Good morning everyone!!!");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys("Great");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys("Fine");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='vote-checkbox']")).click(); // multi choice
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='vote-new-question-link addq']")).click(); // add question
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='UF_BLOG_POST_VOTE_n0_DATA[QUESTIONS][1][QUESTION]']")).sendKeys("What is your favorite book?");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='UF_BLOG_POST_VOTE_n0_DATA[QUESTIONS][1][ANSWERS][0][MESSAGE]']")).sendKeys("Secret");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='UF_BLOG_POST_VOTE_n0_DATA[QUESTIONS][1][ANSWERS][1][MESSAGE]']")).sendKeys("Harry Potter");
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']")).click(); // cancel button
        driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click(); // send button
        Thread.sleep(3000);


    }

    @AfterClass
    public void teardown(){
        driver.close();
    }



}
/*
User Story:
4. As a user, I should be able to create a poll
Acceptance Criteria:
1. Verify users can write a poll message title with question & answer.
2. Verify users can check ""allow multiple Choice""
3. Verify users can add questions
4. Verify users can cancel poll
 */