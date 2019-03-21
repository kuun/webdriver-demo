package org.test.webdriverdemo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


    @Before
    public void createWebDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    @After
    public void destroyWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("打开登录页面")
    public void openLoginPage() {
        driver.get("http://192.168.50.129");
        userName = driver.findElement(Locator.userName);
        password = driver.findElement(Locator.password);
        loginBtn = driver.findElement(Locator.loginBtn);
    }


    @When("使用正确的用户名与密码登录")
    public void loginWithCorrectCredential() {
        userName.sendKeys("admin");
        password.sendKeys("admin2004");
        loginBtn.click();
    }

    @Then("进入主页面")
    public void intoMainPage() {
        assertTrue(driver.getCurrentUrl().contains("/main/manager_index.jsp"));
    }

    @BeforeEach
    void setup() {
        driver.get("http://192.168.50.129");
        userName = driver.findElement(Locator.userName);
        password = driver.findElement(Locator.password);
        loginBtn = driver.findElement(Locator.loginBtn);
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
