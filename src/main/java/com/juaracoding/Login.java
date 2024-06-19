package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

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
        WebElement txtUsername = driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/label"));
        js.executeScript("arguments[0].scrollIntoView();", txtUsername);
        // username, password, submit
        // driver.findElement(By.linkText("Gmail")).click();
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        System.out.println("Login Button Clicked");

        String url = driver.getCurrentUrl();
        System.out.println(url);
        String txtSuccessLogin = driver.findElement(By.className("post-title")).getText();
        System.out.println(txtSuccessLogin);
        String txtLogin = driver.findElement(By.cssSelector("#loop-container > div > article > div.post-content > div > div > div > a")).getText();
        System.out.println(txtLogin);

        // Lengkapi Assertion IF

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

}
