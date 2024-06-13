package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://demoqa.com/text-box");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // css selector
        String txtHeader = driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > h1")).getText();
        System.out.println(txtHeader);
        // userName, userEmail, currentAddress, permanentAddress, submit, assert name
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("info@juaracoding.co.id");
        // scroll vertical 500px
        // js.executeScript("window.scrollBy(0,500)");
        // scroll to element
        js.executeScript("arguments[0].scrollIntoView();", userEmail);
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("submit")).click();
        System.out.println("Data Submit");
        String actual = driver.findElement(By.id("name")).getText();
        String expected = "Name:JuaraCoding";

        // Assertion IF
        if(actual.equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

}
