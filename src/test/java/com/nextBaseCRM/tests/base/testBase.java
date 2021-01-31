package com.nextBaseCRM.tests.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class testBase {

    public WebDriver driver;

    public void login(){

        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameInput.sendKeys("");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("" + Keys.ENTER);

    }

}
