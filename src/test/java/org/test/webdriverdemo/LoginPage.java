package org.test.webdriverdemo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("登录页面测试")
public class LoginPage {
    @Test
    @DisplayName("成功的登录")
    void testSuccess() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.50.129");
        WebElement userName = driver.findElement(By.name("user.name"));
        WebElement password = driver.findElement(By.name("user.passwd"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[4]/input"));
        userName.sendKeys("admin");
        password.sendKeys("admin2003");
        loginBtn.click();
        assertTrue(driver.getCurrentUrl().contains("/main/manager_index.jsp"));
        driver.quit();
    }

    @Test
    @DisplayName("密码错误")
    void testWrongPassword() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.50.129");
        WebElement userName = driver.findElement(By.name("user.name"));
        WebElement password = driver.findElement(By.name("user.passwd"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[4]/input"));
        userName.sendKeys("admin");
        password.sendKeys("wrongpass1");
        loginBtn.click();
        WebElement loginFailedTip = (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("tipId"))
        );
        assertEquals("用户名或密码或指纹错误", loginFailedTip.getText());
        driver.quit();
    }
}
