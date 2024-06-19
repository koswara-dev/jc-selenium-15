package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingActions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://www.browserstack.com/");
        System.out.println("Open Browser");

        WebElement menuDevelopers = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(menuDevelopers).perform();

        // actions.doubleClick();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

}
