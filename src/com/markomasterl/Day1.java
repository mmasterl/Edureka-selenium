package com.markomasterl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day1 {
    WebDriver driver;
    JavascriptExecutor jse;

    public void invokeBrowser() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/markomasterl/Downloads/webdrivers/chrome/chromedriver");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("http://www.edureka.co");
            searchCourse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchCourse() {
        try {
            driver.findElement(By.id("homeSearchBar")).sendKeys("Java");
            driver.findElement(By.id("homeSearchBarIcon")).click();
            jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(0, 800)");
            driver.findElement(By.xpath("//label[contains(text(), 'Weekend)']")).click();
//            driver.findElement(By.className("weekendfilter batch_category_select")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Day1 myobj = new Day1();
        myobj.invokeBrowser();
    }
}
