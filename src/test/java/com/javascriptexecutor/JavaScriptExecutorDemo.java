package com.javascriptexecutor;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\win\\IdeaProjects\\cromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();
        WebElement joinfree = driver.findElement(By.xpath("//header/div[1]/ul[1]/li[2]/a[1]/span[1]"));
//Flashing element
        JavascriptUtil.flash(joinfree, driver);
//Draw Border
        JavascriptUtil.drawBorder(joinfree, driver);
//Screenshots
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File trg = new File("C:\\Users\\win\\IdeaProjects\\JavaScriptExcecutor\\Screenshots\\Twoplug.png");
        try {
            FileUtils.copyFile(src, trg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Title of the page
        String title = JavascriptUtil.getTitleByJS(driver);
        System.out.println("title of the page:" + title);

        //Click on element
        WebElement loginbtn = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a"));
        JavascriptUtil.clickElementByJS(loginbtn, driver);

        //Generate Alert
        JavascriptUtil.generateAlert(driver, "You clicked on login button");

        //Refresh Browser
        JavascriptUtil.refreshBrowserByJS(driver);

        //Scroll until find element
        WebElement image = driver.findElement(By.xpath("//*[@id=\"rslides3_s0\"]/div[1]/img"));
        JavascriptUtil.scrollIntoView(image, driver);

        //Scroll down
        JavascriptUtil.scrollPageDown(driver);

    }
}
