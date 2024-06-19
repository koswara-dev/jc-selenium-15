package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ECommorce {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://www.saucedemo.com/");
        System.out.println("Open Browser");

        // Scenario Positive Test Case
        //input[@id='user-name']
        driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // lengkapi assert if
        // harus logout
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        delay(1);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();

        // Scenario Negative Test Case
        delay(1);
        driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String txtLoginError = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(txtLoginError);
        assertEquals(txtLoginError, "is required");

        // List
        List<WebElement> listInput = driver.findElements(By.xpath("//input"));
        System.out.println(listInput.size());
        for (int i = 0; i < listInput.size(); i++) {
            System.out.println(listInput.get(i).getText());
        }

        //div[@class='inventory_item_name']

        // perform key press
        WebElement username = driver.findElement(By.xpath("//input[contains(@id,'user')]"));
        username.sendKeys("standard_user");
        username.sendKeys(Keys.CONTROL+"A");
        username.sendKeys(Keys.DELETE);

        delay(3);

        driver.quit();


    }

    static void delay(long detik){
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void assertEquals(String actual, String expected){
        if(actual.contains(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

}
