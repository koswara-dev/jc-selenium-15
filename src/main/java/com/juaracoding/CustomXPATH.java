package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomXPATH {

    public static void main(String[] args) {

        // System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        // WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,300)");
        WebElement txtUsername = driver.findElement(By.xpath("//label[@for='username']"));
        js.executeScript("arguments[0].scrollIntoView();", txtUsername);
        // username, password, submit
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("student");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@class='btn']")).click();
        System.out.println("Login Button Clicked");

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String txtSuccessLogin = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
        System.out.println(txtSuccessLogin);
        // String txtLogout = driver.findElement(By.xpath("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")).getText();
        String txtLogout = driver.findElement(By.xpath("//a[contains(@class, 'wp-block-button__link')]")).getText();
        System.out.println(txtLogout);

        // Lengkapi Assertion IF, buatkan method static assertEquals(String actual, String expected)
        assertEquals(currentUrl, "https://practicetestautomation.com/logged-in-successfully/");
        assertEquals(txtSuccessLogin, "Logged In Successfully");
        assertEquals(txtLogout, "Log out");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

    static void assertEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

}
