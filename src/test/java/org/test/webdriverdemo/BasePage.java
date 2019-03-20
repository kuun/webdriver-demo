package org.test.webdriverdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    static WebDriver driver;

    @BeforeAll
    static void createWebDriver() {
        driver = new ChromeDriver();
    }

    @AfterAll
    static void destroyWebDriver() {
        driver.quit();
    }

    // wait for an element, default timeout is 10s.
    static WebElement waitFor(By locator) {
        return waitFor(locator, 10);
    }

    static WebElement waitFor(By locator, int timeout) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeout);
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
