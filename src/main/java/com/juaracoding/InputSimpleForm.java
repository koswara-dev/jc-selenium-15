package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputSimpleForm {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://ultimateqa.com/complicated-page");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1200)"); // pixel

//        et_pb_contact_name_0
//        et_pb_contact_email_0
//        et_pb_contact_message_0
//        et_pb_contact_captcha_0
        String captcha = driver.findElement(By.className("et_pb_contact_captcha_question")).getText();
        System.out.println(captcha);
        int num1 = Integer.parseInt(captcha.substring(0,2).trim());
        int num2 = Integer.parseInt(captcha.substring(captcha.length()-1));
        System.out.println(num1);
        Integer result = num1+num2;
        driver.findElement(By.name("et_pb_contact_captcha_0")).sendKeys(result.toString());
        // button submit
        driver.findElement(By.name("et_builder_submit_button")).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

}
