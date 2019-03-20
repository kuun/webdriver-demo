package org.test.webdriverdemo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Syslog配置管理")
public class SyslogConfigPage extends BasePage {
    WebElement enableCheckbox;
    WebElement ip;
    WebElement port;
    WebElement saveBtn;

    private static class Locator {
        static By enableCheckbox = By.cssSelector(".checkbox > label > input");
        static By ip = By.name("ip");
        static By port = By.name("port");
        static By save = By.tagName("button");
        static By notifyMsg = By.cssSelector("span[data-notify=message]");
    }

    @BeforeEach
    void setup() {
        enableCheckbox = driver.findElement(Locator.enableCheckbox);
        ip = driver.findElement(Locator.ip);
        port = driver.findElement(Locator.port);
        saveBtn = driver.findElement(Locator.save);
    }

    @Test
    @DisplayName("测试启用成功")
    void testEnableSuccess() {
        driver.get("https://192.168.50.129/main/manager_index.jsp");
        if (!enableCheckbox.isSelected()) {
            enableCheckbox.click();
        }
        ip.sendKeys("1.1.1.1");
        port.sendKeys("514");
        saveBtn.click();
        WebElement notifyMsg = waitFor(Locator.notifyMsg);
        assertEquals("保存成功", notifyMsg.getText());
    }

    @Test
    void testIPInvalid () {

    }

    @Test
    void testPortInvalid() {

    }
}
