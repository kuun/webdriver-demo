package org.test.webdriverdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
