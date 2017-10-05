package com.markomasterl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FB_TEST {
    WebDriver driver;

    public void invokeBrowser() {
        String baseURL = "https://www.facebook.com";

        try {
//            System.setProperty("webdriver.gecko.driver","/Users/markomasterl/Downloads/webdrivers/firefox/geckodriver");
//            System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
//            WebDriver driver = new FirefoxDriver();

            System.setProperty("webdriver.chrome.driver", "/Users/markomasterl/Downloads/webdrivers/chrome/chromedriver");
            driver = new ChromeDriver();

            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get(baseURL);
            testLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testLogin() {
        String facebookUsername = "";
        String facebookPassword = "";

        String emailFieldID     = "email";
        String passFieldID      = "pass";
        String loginButtonID    = "loginbutton";

        try {
            driver.findElement(By.id(emailFieldID)).clear();
            driver.findElement(By.id(emailFieldID)).sendKeys(facebookUsername);
            Thread.sleep(3000);
            driver.findElement(By.id(passFieldID)).clear();
            driver.findElement(By.id(passFieldID)).sendKeys(facebookPassword);
            Thread.sleep(3000);
            driver.findElement(By.id(loginButtonID)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FB_TEST fb_test = new FB_TEST();
        fb_test.invokeBrowser();
    }
}
