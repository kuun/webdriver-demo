package org.test.webdriverdemo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
}
