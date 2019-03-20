package org.test.webdriverdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("登录页面测试")
public class LoginPage extends BasePage {
    WebElement userName;
    WebElement password;
    WebElement loginBtn;

    static class Locator {
        static By userName = By.name("user.name");
        static By password = By.name("user.passwd");
        static By loginBtn = By.xpath("//*[@id=\"login_form\"]/div[4]/input");
        static By tip = By.id("tipId");
    }

    @BeforeEach
    void setup() {
        driver.get("http://192.168.50.129");
        userName = driver.findElement(Locator.userName);
        password = driver.findElement(Locator.password);
        loginBtn = driver.findElement(Locator.loginBtn);
    }

    @Test
    @DisplayName("成功的登录")
    void testSuccess() throws Exception {
        userName.sendKeys("admin");
        password.sendKeys("admin2003");
        loginBtn.click();
        assertTrue(driver.getCurrentUrl().contains("/main/manager_index.jsp"));
    }

    @Test
    @DisplayName("密码错误")
    void testWrongPassword() throws Exception {
        userName.sendKeys("admin");
        password.sendKeys("wrongpass1");
        loginBtn.click();
        // 等待登录错误提示在页面中出现
        WebElement loginFailedTip = (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(Locator.tip));
        assertEquals("用户名或密码或指纹错误", loginFailedTip.getText());
    }
}
