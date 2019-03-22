package org.test.webdriverdemo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    static WebDriver driver;

    // wait for an element, default timeout is 10s.
    WebElement waitFor(By locator) {
        return waitFor(locator, 10);
    }

    WebElement waitFor(By locator, int timeout) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeout);
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    WebElement waitVisibleFor(By locator) {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebElement waitVisibleFor(By locator, int timeout) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeout);
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    boolean waitUrlContains(String url) {
        return waitUrlContains(url, 10);
    }

    boolean waitUrlContains(String url, int timeout) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeout);
        return driverWait.until(ExpectedConditions.urlContains(url));
    }

    boolean waitRefreshed() {
        return waitRefreshed(10);
    }

    boolean waitRefreshed(int timeout) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeout);
        return driverWait.until(
                driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete")
        );
    }
}
