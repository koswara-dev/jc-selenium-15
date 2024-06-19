package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSelect {

    public static void main(String[] args) {

        // System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        // WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement txtDropdown = driver.findElement(By.xpath("//*[@id=\"post-909\"]/div/div[1]/div/div[3]/div/div[1]/div[9]/div/div/h4/span"));
        js.executeScript("arguments[0].scrollIntoView();", txtDropdown);

        WebElement selectCar = driver.findElement(By.xpath("//*[@id=\"post-909\"]/div/div[1]/div/div[3]/div/div[1]/div[9]/div/div/div/select"));
        Select select = new Select(selectCar);
        // select.selectByValue("audi");
        // select.selectByIndex(3);
        select.selectByVisibleText("Audi");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

}
