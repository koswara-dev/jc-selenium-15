package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://demoqa.com/alerts");
        System.out.println("Open Browser");

        // alertButton, timerAlertButton, confirmButton, promtButton
        driver.findElement(By.id("alertButton")).click();
        delay(2);
        driver.switchTo().alert().accept();
        System.out.println("Alert OK");

        driver.findElement(By.id("timerAlertButton")).click();
        delay(5);
        driver.switchTo().alert().accept();
        System.out.println("Timer Alert OK");

        // IF alert input

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

}
