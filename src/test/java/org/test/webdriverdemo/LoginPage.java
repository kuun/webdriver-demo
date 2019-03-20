package org.test.webdriverdemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    @Test
    void testSuccess() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.50.129");
        Thread.sleep(5000);
        WebElement userName = driver.findElement(By.name("user.name"));
        WebElement password = driver.findElement(By.name("user.passwd"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[4]/input"));
        userName.sendKeys("admin");
        password.sendKeys("admin2003");
        Thread.sleep(5000);
        loginBtn.click();
        Thread.sleep(5000);
        driver.quit();
    }

}
